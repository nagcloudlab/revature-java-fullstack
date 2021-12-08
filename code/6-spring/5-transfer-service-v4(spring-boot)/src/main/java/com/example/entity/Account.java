package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {
    @Id
    private String number;
    private double balance;
}
