package com.willstay.springbootapplicationrest.service;

import com.willstay.springbootapplicationrest.dao.AccountDao;
import com.willstay.springbootapplicationrest.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountService {
    @Autowired
    AccountDao accountDao;

    public Account getById(Long id) {
        return accountDao.getById(id);
    }

    public List<Account> getAll() {
        return accountDao.getAll();
    }

    public List<Account> getAllByOwnerId(Long ownerId) {
        return accountDao.getAllByOwnerId(ownerId);
    }

    public Account save(Account account) {
        try {
            accountDao.getById(account.getId());
            return accountDao.update(account);
        } catch (EmptyResultDataAccessException e){
            return accountDao.insert(account);
        }
    }
}
