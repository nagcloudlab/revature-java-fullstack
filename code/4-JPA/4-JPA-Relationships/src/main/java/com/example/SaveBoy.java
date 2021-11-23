package com.example;

import com.example.entity.Boy;
import com.example.entity.Girl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.List;

public class SaveBoy {
    public static void main(String[] args) throws IOException {


        Boy boy=new Boy();
        boy.id=111;
        boy.name="Boy1";

        Girl girl=new Girl();
        girl.id=222;
        boy.girl=girl;


        // insert this employee data into DB
        // using Hibernate / JPA api

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();


        entityManager.persist(boy); // insert into employee values(?,?)


        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();


    }
}
