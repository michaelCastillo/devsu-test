package com.devsu.account.models;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID account_number;

    @Column
    private String type;

    @Column
    private Integer initial_balance;

    @Column
    private String status;

    @OneToMany
    private Set<Movement> movements;

    public Set<Movement> getMovements() {
        return movements;
    }

    public void setMovements(Set<Movement> movements) {
        this.movements = movements;
    }

    public UUID getAccount_number() {
        return account_number;
    }

    public void setAccount_number(UUID account_number) {
        this.account_number = account_number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getInitial_balance() {
        return initial_balance;
    }

    public void setInitial_balance(Integer initial_balance) {
        this.initial_balance = initial_balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
