package com.example.repository;

import com.example.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class JpaProductRepository implements ProductRepository{

    EntityManagerFactory entityManagerFactory;

    public JpaProductRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<Product> findAll() {
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        String jpql="from Product";
        List<Product> products=entityManager.createQuery(jpql).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();;
        return products;
    }
}
