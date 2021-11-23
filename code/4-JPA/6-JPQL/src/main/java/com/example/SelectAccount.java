package com.example;

import com.example.entity.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/*

    in JPA, select entities

    4 ways

    way-1 : by primary key ( em.find() )
    way-2 : by JPQL ( Java Persistent Query Language )

            SQL

                => based relational model
                => partially DBMS dependent

            JPQL

                => object model
                => DBMS independent

     way-3 : by Criteria API
     way-4 : by Native SQL

 */

public class SelectAccount {

    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

//
//        Account account=entityManager.find(Account.class,"1"); // Managed
//        System.out.println(account);

        // SQL : select 'column1,column2' from 'table' where 'condition'

        double balance=300.00;

        String jpql="from Account";
        Query query=entityManager.createQuery(jpql);
        query.setFirstResult(5);
        query.setMaxResults(5);

        query.getResultList()
                        .stream()
                                .forEach(System.out::println);


        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }

}
