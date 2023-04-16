package com.example.demo.classes;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    private String password;
    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private String number;
    private String address;
    private String eircode;
    private String role = "ROLE_USER";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    public User(Integer id, String role, String email, String firstName, String lastName, String number, String address, String eircode, String password) {
        this.id = id;
        this.role = role;
        this.email = email;
        this.username = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.address = address;
        this.eircode = eircode;
        this.password = password;
    }

    public User() {}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getEircode() {
        return eircode;
    }

    public void setEircode(String eircode) {
        this.eircode = eircode;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}

