package com.willstay.springbootapplicationrest.controller;

import com.willstay.springbootapplicationrest.domain.Company;
import com.willstay.springbootapplicationrest.domain.Owner;
import com.willstay.springbootapplicationrest.service.CompanyService;
import com.willstay.springbootapplicationrest.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/company")
@RestController
public class CompanyController {
    @Autowired
    CompanyService companyService;
    @Autowired
    OwnerService ownerService;

    @GetMapping("/all")
    List<Company> findAll() {
        return companyService.getAll();
    }

    @GetMapping("/{id}")
    Company findById(@PathVariable("id") Long id) {
        return companyService.getById(id);
    }

    @PostMapping("/save")
    Company save(@RequestBody Company company) {
        return companyService.save(company);
    }

    @GetMapping("/{id}/owners")
    List<Owner> findOwnersByCompanyId(@PathVariable("id") Long id) {
        return ownerService.getAllByCompanyId(id);
    }
}
