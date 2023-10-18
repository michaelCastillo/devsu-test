package com.devsu.client.models;

import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "client_id")
public class Client extends Person {

    @Column
    private String password;

    @Column
    private String status;
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
