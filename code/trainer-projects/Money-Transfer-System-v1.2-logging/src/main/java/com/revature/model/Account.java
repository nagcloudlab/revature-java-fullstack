package com.revature.model;

// Account data class

public class Account {

    private String number;
    private double balance;

    // constructor
    public Account(String number) {
        this.number = number;
    }

    public Account() {
    }

    public Account(String number, double balance) {
        this.number = number;
        this.balance = balance;
    }

    // accessor methods

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
