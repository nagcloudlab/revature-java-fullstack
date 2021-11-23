package com.example;

import com.example.entity.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SaveAccount {
    public static void main(String[] args) {

        Account account=new Account();
        account.number="2";
        account.balance=1000.00;


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();


        entityManager.persist(account);


        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }
}
