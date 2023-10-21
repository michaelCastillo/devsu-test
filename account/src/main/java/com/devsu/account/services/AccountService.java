package com.devsu.account.services;

import com.devsu.account.dto.AccountDto;
import com.devsu.account.models.Account;
import com.devsu.account.repositories.AccountRepository;
import com.devsu.account.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/account")
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping
    public Iterable<AccountDto> getAllAccounts() {

        Iterable<Account> accounts = this.accountRepository.findAll();
        return AccountDto.parseAccountArrayToDto(accounts);
    }

    @PostMapping
    public AccountDto createAccount(@Validated @RequestBody Account account){
        Account accountResponse = this.accountRepository.save(account);
        return AccountDto.parseAccountToDto(accountResponse);
    }

    @PutMapping
    public AccountDto updateAccount(@Validated @RequestBody Account account){
        Account accountResponse = this.accountRepository.save(account);
        return AccountDto.parseAccountToDto(accountResponse);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable UUID id){
        this.accountRepository.deleteById(id);
    }

}
