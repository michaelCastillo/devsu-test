package com.devsu.account.dto;

import com.devsu.account.models.Account;
import com.devsu.account.models.Movement;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.lang.NonNull;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class MovementDto {




    @NonNull
    public Date date;

    @NonNull
    public Integer ammount;

    @NonNull
    public Integer balance;

    @NonNull
    public AccountDto account;

    public static MovementDto parseMovementToDto(Movement movement){
        MovementDto movementDto = new MovementDto();
        movementDto.ammount = movement.getAmmount();
        movementDto.date = movement.getDate();
        movementDto.balance = movement.getBalance();

        AccountDto accountDto = new AccountDto();
        accountDto.account_number = movement.getAccount().getAccount_number();
        accountDto.initial_balance = movement.getAccount().getInitial_balance();

        movementDto.account = accountDto;

        return movementDto;
    }

    public static Set<MovementDto> parseMovementArrayToDto(Iterable<Movement> movements){
        Set<MovementDto> response = new HashSet<>();

        movements.forEach(movement -> {
            MovementDto movementDto = new MovementDto();
            movementDto.ammount = movement.getAmmount();
            movementDto.date = movement.getDate();
            movementDto.balance = movement.getBalance();

            AccountDto accountDto = new AccountDto();
            accountDto.account_number = movement.getAccount().getAccount_number();
            accountDto.initial_balance = movement.getAccount().getInitial_balance();

            movementDto.account = accountDto;
            response.add(movementDto);
        });
        return response;
    }


}
