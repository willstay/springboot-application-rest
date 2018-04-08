package com.willstay.springbootapplicationrest.dao.jdbc;

import com.willstay.springbootapplicationrest.dao.AccountDao;
import com.willstay.springbootapplicationrest.domain.Account;
import com.willstay.springbootapplicationrest.mapper.AccountRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountDaoJdbc implements AccountDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Account getById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Account WHERE ID = ? ",
                new AccountRowMapper(), id);
    }

    @Override
    public List<Account> getAll() {
        return jdbcTemplate.query("SELECT * FROM Account",
                new AccountRowMapper());
    }

    @Override
    public List<Account> getAllByOwnerId(Long ownerId) {
        return jdbcTemplate.query("SELECT * FROM Account WHERE OWNERID = ? ",
                new AccountRowMapper(), ownerId);
    }

    @Override
    public Account insert(Account account) {
        jdbcTemplate.update("INSERT INTO Account(ID, OWNERID, NAME, RATE) VALUES (?,?,?,?)",
                account.getId(), account.getOwnerId(), account.getName(), account.getRate());
        return getById(account.getId());
    }

    @Override
    public Account update(Account account) {
        jdbcTemplate.update("UPDATE Account SET OWNERID = ?, NAME = ?, RATE = ? WHERE ID = ?",
                account.getOwnerId(), account.getName(), account.getRate(), account.getId());
        return getById(account.getId());
    }

    public Account save(Account account) {
        if (jdbcTemplate.query("SELECT * FROM Account WHERE ID = ?", new AccountRowMapper(),
                account.getId()).isEmpty()) {
            return insert(account);
        } else {
            return update(account);
        }
    }
}
