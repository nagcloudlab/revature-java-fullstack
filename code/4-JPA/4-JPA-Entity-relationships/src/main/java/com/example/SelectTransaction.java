package com.example;

import com.example.entity.Account;
import com.example.entity.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SelectTransaction {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Transaction transaction=entityManager.find(Transaction.class,2);
        System.out.println(transaction.id);
        System.out.println(transaction.amount);
        System.out.println(transaction.account.number);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }
}
