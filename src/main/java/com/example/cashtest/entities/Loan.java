package com.example.cashtest.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Loan
 */

@Entity
@Table(name = "loan")

@NamedNativeQuery(name = "Loan.findLoans", query ="SELECT * FROM loan LIMIT ?,?")
@NamedNativeQuery(name = "Loan.findLoansByUserId", query ="SELECT * FROM loan WHERE user_id = ? LIMIT ?,?")
@NamedNativeQuery(name = "Loan.countLoansByUserId", query = "SELECT count(*) FROM loan WHERE user_id = ? ")
public class Loan {
    
    @Id
    @JsonProperty(value = "loan_id")
    @Column(name = "loan_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loanId;
    private double total;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    public Loan() {
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
}