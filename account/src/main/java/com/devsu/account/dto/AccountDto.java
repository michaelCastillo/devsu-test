package com.devsu.account.dto;

import com.devsu.account.models.Account;
import com.devsu.account.models.Movement;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class AccountDto {

        @NonNull
        public UUID account_number;

    public String type;

        @NonNull
        public Integer initial_balance;


    public String status;

    public Set<MovementDto> movements;

    public static AccountDto parseAccountToDto(Account account){
        AccountDto accountDto = new AccountDto();
        accountDto.account_number = account.getAccount_number();
        accountDto.initial_balance = account.getInitial_balance();
        return accountDto;
    }

    public static Set<AccountDto> parseAccountArrayToDto(Iterable<Account> accounts) {
        Set<AccountDto> response = new HashSet<>();
        accounts.forEach(account -> {
            AccountDto accountDto = new AccountDto();
            accountDto.account_number = account.getAccount_number();
            accountDto.initial_balance = account.getInitial_balance();
            accountDto.status = account.getStatus();
            accountDto.type = account.getType();
            response.add(accountDto);

            Set<Movement> movements = account.getMovements();
            accountDto.movements = MovementDto.parseMovementArrayToDto(movements);
        });

        return response;
    }


    }



