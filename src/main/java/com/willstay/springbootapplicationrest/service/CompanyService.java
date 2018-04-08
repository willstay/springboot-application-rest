package com.willstay.springbootapplicationrest.service;

import com.willstay.springbootapplicationrest.dao.jdbc.CompanyDaoJdbc;
import com.willstay.springbootapplicationrest.domain.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyService {
    @Autowired
    CompanyDaoJdbc companyDaoJdbc;

    public Company getById(Long id) {
        return companyDaoJdbc.getById(id);
    }

    public List<Company> getAll() {
        return companyDaoJdbc.getAll();
    }

    public Company save(Company company) {
        return companyDaoJdbc.save(company);
    }
}
