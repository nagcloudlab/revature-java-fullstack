package com.example;

import com.example.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

public class Application {
    public static void main(String[] args) {

        Employee employee = new Employee();
        employee.setId(123);
        employee.setName("Nag");


        // insert this employee data into DB
        // using Hibernate / JPA api

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();


        entityManager.persist(employee); // insert into employee values(?,?)


        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();


    }
}
