package com.example.multithreading.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_tbl")
public class UserEntity {
    @Id
    @SequenceGenerator(name = "seq", sequenceName = "user_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private int id;
    private String name;
    private String email;
    private String gender;

    public UserEntity(String name, String email, String gender){
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
}
