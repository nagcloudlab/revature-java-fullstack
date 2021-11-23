package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="accounts")
public class Account {

    @Id
    public String number;
    public double balance;
    @OneToMany(
            mappedBy ="account",
            targetEntity = Transaction.class,
            fetch = FetchType.LAZY
    )
    public List<Transaction> transactions;

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public String getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }
}
