package com.willstay.springbootapplicationrest.dao.jdbc;

import com.willstay.springbootapplicationrest.dao.CompanyDao;
import com.willstay.springbootapplicationrest.domain.Company;
import com.willstay.springbootapplicationrest.mapper.CompanyRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyDaoJdbc implements CompanyDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Company getById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Company WHERE ID = ?",
                new CompanyRowMapper(), id);
    }

    @Override
    public List<Company> getAll() {
        return jdbcTemplate.query("SELECT * FROM Company",
                new CompanyRowMapper());
    }

    @Override
    public Company insert(Company company) {
        jdbcTemplate.query("INSERT INTO Company(ID,TITLE) VALUES (?,?)",
                new CompanyRowMapper(), company.getId(), company.getTitle());
        return getById(company.getId());
    }

    @Override
    public Company update(Company company) {
        jdbcTemplate.update("UPDATE Company SET TITLE = ? WHERE ID = ?",
                company.getTitle(), company.getId());
        return getById(company.getId());
    }

    public Company save(Company company) {
        if (jdbcTemplate.query("SELECT * FROM Company WHERE ID = ?", new CompanyRowMapper(),
                company.getId()).isEmpty()) {
            return insert(company);
        } else {
            return update(company);
        }
    }
}
