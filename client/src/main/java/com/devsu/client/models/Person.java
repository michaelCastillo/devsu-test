package com.devsu.client.models;

import jakarta.persistence.*;
public class Person {
    @GeneratedValue
    @Id
    private Long id;

    @Column
    private String name;
    @Column
    private String gender;
    @Column
    private Integer age;
    @Column
    private String identification;
    @Column
    private String address;
    @Column
    private String phone_number;

}
