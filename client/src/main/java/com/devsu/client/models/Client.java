package com.devsu.client.models;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clientid;

    @Column
    private String password;

    @Column
    private String status;
    @Override
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
}
