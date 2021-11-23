package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="accounts")
public class Account {

    @Id
    public String number;
    public double balance;

    @Override
    public String toString() {
        return "Account{" +
                "number='" + number + '\'' +
                ", balance=" + balance +
                '}';
    }

    public String getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }
}
