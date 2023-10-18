package com.devsu.account.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "movement")
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long movement_id;

    @Column
    private Date date;

    @Column
    private Integer ammount;

    @Column
    private Integer balance;

    @ManyToOne
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Long getMovement_id() {
        return movement_id;
    }

    public void setMovement_id(Long movement_id) {
        this.movement_id = movement_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getAmmount() {
        return ammount;
    }

    public void setAmmount(Integer ammount) {
        this.ammount = ammount;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
