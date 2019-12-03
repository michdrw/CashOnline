package com.example.cashtest.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User
 */

@Entity
@Table(name = "user")
public class User {

    @Id
    @JsonProperty(value = "user_id")
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @JsonProperty(value = "first_name")
    @Column(name = "first_name")
    private String firstName;
    @JsonProperty(value = "last_name")
    @Column(name = "last_name")
    private String lastName;
    private String email;

    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Loan> loans = new ArrayList<Loan>();

    public User() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer id) {
        this.userId = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setPrestamos(List<Loan> loans) {
        this.loans = loans;
    }

    public void addLoan(Loan p) {
        p.setUser(this);
        loans.add(p);
    }

}