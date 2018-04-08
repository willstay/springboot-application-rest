package com.willstay.springbootapplicationrest.service;

import com.willstay.springbootapplicationrest.dao.jdbc.AccountDaoJdbc;
import com.willstay.springbootapplicationrest.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountService {
    @Autowired
    AccountDaoJdbc accountDaoJdbc;

    public Account getById(Long id) {
        return accountDaoJdbc.getById(id);
    }

    public List<Account> getAll() {
        return accountDaoJdbc.getAll();
    }

    public List<Account> getAllByOwnerId(Long ownerId) {
        return accountDaoJdbc.getAllByOwnerId(ownerId);
    }

    public Account save(Account account) {
        return accountDaoJdbc.save(account);
    }
}
