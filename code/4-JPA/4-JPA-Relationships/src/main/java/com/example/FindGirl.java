package com.example;

import com.example.entity.Boy;
import com.example.entity.Girl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

public class FindGirl {
    public static void main(String[] args) throws IOException {

        // insert this employee data into DB
        // using Hibernate / JPA api

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();


        Girl girl=entityManager.find(Girl.class,22); // select * from girl where id=22
        System.out.println(girl.getName());
        System.out.println(girl.boy.getName());

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();


    }
}
