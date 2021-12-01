package com.example.repository;

import com.example.entity.Product;
import com.example.entity.Review;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
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

    @Override
    public List<Review> findAllReviews(int productId) {
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        String jpql="from Review r where r.product.id=:productId";
        Query query=entityManager.createQuery(jpql);
        query.setParameter("productId",productId);
        List<Review> reviews=query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();;
        return reviews;
    }
}
