package com.willstay.springbootapplicationrest.controller;

import com.willstay.springbootapplicationrest.domain.Account;
import com.willstay.springbootapplicationrest.domain.Owner;
import com.willstay.springbootapplicationrest.service.AccountService;
import com.willstay.springbootapplicationrest.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/owner")
@RestController
public class OwnerController {
    @Autowired
    OwnerService ownerService;
    @Autowired
    AccountService accountService;

    @GetMapping("/all")
    List<Owner> findAll() {
        return ownerService.getAll();
    }

    @GetMapping("/{id}")
    Owner findById(@PathVariable("id") Long id) {
        return ownerService.getById(id);
    }

    @PostMapping("/save")
    Owner save(@RequestBody Owner owner) {
        return ownerService.save(owner);
    }

    @GetMapping("/{id}/accounts")
    List<Account> findAccountsByOwnerId(@PathVariable("id") Long id) {
        return accountService.getAllByOwnerId(id);
    }
}

