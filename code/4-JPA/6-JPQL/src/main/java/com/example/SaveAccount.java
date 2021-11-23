package com.example;

import com.example.entity.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SaveAccount {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();


        for (int i = 0; i < 10; i++) {
            Account account=new Account(); // New / Transient
            account.number=String.valueOf(i+1);
            account.balance=100.00*(i+1);
            entityManager.persist(account); // Managed
        }

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }

}
