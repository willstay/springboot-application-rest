package com.willstay.springbootapplicationrest.service;

import com.willstay.springbootapplicationrest.dao.OwnerDao;
import com.willstay.springbootapplicationrest.domain.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OwnerService {
    @Autowired
    OwnerDao ownerDao;

    public Owner getById(Long id) {
        return ownerDao.getById(id);
    }

    public List<Owner> getAll() {
        return ownerDao.getAll();
    }

    public List<Owner> getAllByCompanyId(Long companyId) {
        return ownerDao.getAllByCompanyId(companyId);
    }

    public Owner save(Owner owner) {
        try {
            ownerDao.getById(owner.getId());
            return ownerDao.update(owner);
        } catch (EmptyResultDataAccessException e) {
            return ownerDao.insert(owner);
        }
    }
}
