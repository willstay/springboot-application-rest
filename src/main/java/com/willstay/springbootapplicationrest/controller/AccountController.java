package com.willstay.springbootapplicationrest.controller;

import com.willstay.springbootapplicationrest.domain.Account;
import com.willstay.springbootapplicationrest.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/account")
@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/all")
    List<Account> findAll() {
        return accountService.getAll();
    }

    @GetMapping("/{id}")
    Account findById(@PathVariable("id") Long id) {
        return accountService.getById(id);
    }

    @PostMapping("/save")
    Account save(@RequestBody Account person) {
        return accountService.save(person);
    }
}
