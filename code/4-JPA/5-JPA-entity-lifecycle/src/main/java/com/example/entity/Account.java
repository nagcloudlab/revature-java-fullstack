package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="accounts")
public class Account {

    @Id
    public String number;
    public double balance;

    public String getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }
}
