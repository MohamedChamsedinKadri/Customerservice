package com.example.customerservice;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String Name;
    private String Email;


    //constructor
    public Customer(){}
    public Customer(String name, String email) {
        this.Name = name;
        this.Email = email;
    }

    //Setters & Getters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        this.Name = name;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        this.Email = email;
    }

}

