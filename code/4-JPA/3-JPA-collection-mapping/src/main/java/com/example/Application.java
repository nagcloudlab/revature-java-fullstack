package com.example;

import com.example.entity.Address;
import com.example.entity.AddressType;
import com.example.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {

        Employee employee = new Employee();
        employee.id = 123;
        employee.name = "Nag";

        Address homeAddress = new Address();
        homeAddress.addrType= AddressType.HOME;
        homeAddress.city = "chennai";
        homeAddress.country = "India";

        Address officeAddress=new Address();
        officeAddress.addrType=AddressType.OFFICE;
        officeAddress.city="bengalore";
        officeAddress.country="India";

        List<Address> addresses=List.of(
                homeAddress,
                officeAddress
        );

        employee.addresses=addresses;


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
