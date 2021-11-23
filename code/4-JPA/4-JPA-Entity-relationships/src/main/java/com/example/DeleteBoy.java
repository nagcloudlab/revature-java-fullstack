package com.example;

import com.example.entity.Boy;
import com.example.entity.Girl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

public class DeleteBoy {
    public static void main(String[] args) throws IOException {

        // insert this employee data into DB
        // using Hibernate / JPA api

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();


        Boy boy=entityManager.find(Boy.class,111);
        entityManager.remove(boy); // delete from boy where id=111


        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();


    }
}
