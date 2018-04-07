package com.willstay.springbootapplicationrest.dao;

import com.willstay.springbootapplicationrest.domain.Owner;

import java.util.List;

public interface OwnerDao {
    Owner getById(Long id);

    List<Owner> getAll();

    List<Owner> getAllByCompanyId(Long companyId);

    Owner insert(Owner owner);

    Owner update(Owner owner);
}
