package com.example.jwtdemo.data.entity;

import java.util.List;

import com.example.jwtdemo.data.BaseEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Email")
    private String email;

    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserRole> userRoles;

    // public UserDto toInSiteDTO() {
    // return new UserDto(
    // userId,
    // username,
    // password,
    // email);
    // }

    // public UserDto toDTO() {
    // return new UserDto(
    // userId,
    // username,
    // firstName,
    // lastName,
    // email,
    // phoneNumber,
    // address);
    // }
}
