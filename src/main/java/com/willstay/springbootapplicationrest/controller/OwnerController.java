package com.willstay.springbootapplicationrest.controller;

import com.willstay.springbootapplicationrest.domain.Account;
import com.willstay.springbootapplicationrest.domain.Owner;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/owner")
@RestController
public class OwnerController {
    @GetMapping("/all")
    List<Owner> findAll() {
        return null;
    }

    @GetMapping("/{id}")
    Owner findById(@PathVariable("id") Long id) {
        return null;
    }

    @PostMapping("/save")
    Owner save(@RequestBody Owner owner) {
        return null;
    }

    @GetMapping("/{id}/accounts")
    List<Account> findAccountsByOwnerId(@PathVariable("id") Long id) {
        return null;
    }

}

