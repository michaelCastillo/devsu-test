package com.devsu.account.services;

import com.devsu.account.models.Account;
import com.devsu.account.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping
    public Iterable<Account> getAllAccounts() {
        return this.accountRepository.findAll();
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account){
        return this.accountRepository.save(account);
    }
}
