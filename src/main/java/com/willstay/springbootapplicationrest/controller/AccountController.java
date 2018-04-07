package com.willstay.springbootapplicationrest.controller;

import com.willstay.springbootapplicationrest.domain.Account;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/account")
@RestController
public class AccountController {
    @GetMapping("/all")
    List<Account> findAll() {
        return null;
    }

    @GetMapping("/{id}")
    Account findById(@PathVariable("id") Long id) {
        return null;
    }

    @PostMapping("/save")
    Account save(@RequestBody Account person) {
        return null;
    }
}
