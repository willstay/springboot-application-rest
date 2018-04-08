package com.willstay.springbootapplicationrest.service;

import com.willstay.springbootapplicationrest.dao.jdbc.OwnerDaoJdbc;
import com.willstay.springbootapplicationrest.domain.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OwnerService {
    @Autowired
    OwnerDaoJdbc ownerDaoJdbc;

    public Owner getById(Long id) {
        return ownerDaoJdbc.getById(id);
    }

    public List<Owner> getAll() {
        return ownerDaoJdbc.getAll();
    }

    public List<Owner> getAllByCompanyId(Long companyId) {
        return ownerDaoJdbc.getAllByCompanyId(companyId);
    }

    public Owner save(Owner owner) {
       return ownerDaoJdbc.save(owner);
    }
}
