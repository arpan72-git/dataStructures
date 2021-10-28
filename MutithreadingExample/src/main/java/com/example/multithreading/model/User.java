package com.example.multithreading.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String email;
    private String gender;

    public User(String name, String email, String gender){
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
}
