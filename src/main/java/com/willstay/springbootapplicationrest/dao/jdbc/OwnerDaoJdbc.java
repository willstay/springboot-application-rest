package com.willstay.springbootapplicationrest.dao.jdbc;

import com.willstay.springbootapplicationrest.dao.OwnerDao;
import com.willstay.springbootapplicationrest.domain.Owner;
import com.willstay.springbootapplicationrest.mapper.OwnerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OwnerDaoJdbc implements OwnerDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Owner getById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Owner WHERE ID = ?",
                new OwnerRowMapper(), id);
    }

    @Override
    public List<Owner> getAll() {
        return jdbcTemplate.query("SELECt * FROM Owner",
                new OwnerRowMapper());
    }

    @Override
    public List<Owner> getAllByCompanyId(Long companyId) {
        return jdbcTemplate.query("SELECt * FROM Owner WHERE COMPANYID = ?",
                new OwnerRowMapper(), companyId);
    }

    @Override
    public Owner insert(Owner owner) {
        jdbcTemplate.update("INSERT INTO Owner(ID, COMPANYID, FIRSTNAME, SECONDNAME) VALUES (?,?,?,?)",
                owner.getId(), owner.getCompanyId(), owner.getFirstName(), owner.getSecondName());
        return getById(owner.getId());
    }

    @Override
    public Owner update(Owner owner) {
        jdbcTemplate.update("UPDATE Owner SET COMPANYID = ?, FIRSTNAME = ?, SECONDNAME = ? WHERE ID = ?",
                owner.getCompanyId(), owner.getFirstName(), owner.getSecondName(), owner.getId());
        return getById(owner.getId());
    }

    public Owner save(Owner owner) {
        if (jdbcTemplate.query("SELECT * FROM Owner WHERE ID = ?", new OwnerRowMapper(),
                owner.getId()).isEmpty()) {
            return insert(owner);
        } else {
            return update(owner);
        }
    }
}
