package com.willstay.springbootapplicationrest.controller;

import com.willstay.springbootapplicationrest.domain.Company;
import com.willstay.springbootapplicationrest.domain.Owner;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/company")
@RestController
public class CompanyController {
    @GetMapping("/all")
    List<Company> findAll() {
        return null;
    }

    @GetMapping("/{id}")
    Company findById(@PathVariable("id") Long id) {
        return null;
    }

    @PostMapping("/save")
    Company save(@RequestBody Company company) {
        return null;
    }

    @GetMapping("/{id}/owners")
    List<Owner> findOwnersByCompanyId(@PathVariable("id") Long id) {
        return null;
    }
}
