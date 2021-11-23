package com.example;

import com.example.entity.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SelectAccount {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();


        Account account=entityManager.find(Account.class,"1");
        System.out.println("number="+account.number+",balance="+account.getBalance());

        account.getTransactions()
                        .forEach(txn-> System.out.println(txn.id));

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }
}
