package com.devsu.client.dto;


import org.springframework.lang.NonNull;

import java.util.Date;

public class MovementDto {




    @NonNull
    public Date date;

    @NonNull
    public Integer ammount;

    @NonNull
    public Integer balance;

    @NonNull
    public AccountDto account;


}
