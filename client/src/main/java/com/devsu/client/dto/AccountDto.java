package com.devsu.client.dto;
import org.springframework.lang.NonNull;

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


}
