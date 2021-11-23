package com.example;

import com.example.entity.Boy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

public class FindBoy {
    public static void main(String[] args) throws IOException {

        // insert this employee data into DB
        // using Hibernate / JPA api

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();


        Boy boy=entityManager.find(Boy.class,111); // select * from boy where id=11
        System.out.println(boy.getName());
        System.out.println(boy.getGirl().getName());

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();


    }
}
