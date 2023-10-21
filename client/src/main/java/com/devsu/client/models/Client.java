package com.devsu.client.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

@Entity
@PrimaryKeyJoinColumn(name = "client_id")
public class Client extends Person {

    @Column
    private String password;

    @Column
    private String status;

    @Column
    private String accounts;

    public String getAccounts() {
        return accounts;
    }

    public String[] getCountsArray(){
        return accounts.split(",");
    }

    public void setAccounts(String accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
