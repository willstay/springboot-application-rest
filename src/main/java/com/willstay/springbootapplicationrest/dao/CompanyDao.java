package com.willstay.springbootapplicationrest.dao;

import com.willstay.springbootapplicationrest.domain.Company;

import java.util.List;

public interface CompanyDao {
    Company getById(Long id);

    List<Company> getAll();

    Company insert(Company company);

    Company update(Company company);
}
