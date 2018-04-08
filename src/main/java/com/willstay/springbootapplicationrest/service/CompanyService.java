package com.willstay.springbootapplicationrest.service;

import com.willstay.springbootapplicationrest.dao.CompanyDao;
import com.willstay.springbootapplicationrest.domain.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyService {
    @Autowired
    CompanyDao companyDao;

    public Company getById(Long id) {
        return companyDao.getById(id);
    }

    public List<Company> getAll() {
        return companyDao.getAll();
    }

    public Company save(Company company) {
        try {
            companyDao.getById(company.getId());
            return companyDao.update(company);
        } catch (EmptyResultDataAccessException e){
            return companyDao.insert(company);
        }
    }
}
