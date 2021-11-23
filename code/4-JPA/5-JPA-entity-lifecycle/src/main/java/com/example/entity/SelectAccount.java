package com.example.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SelectAccount {

    public static void main(String[] args) {



        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();


        Account account=entityManager.find(Account.class,"1"); // Managed
        account.balance=100.00;


        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }

}
