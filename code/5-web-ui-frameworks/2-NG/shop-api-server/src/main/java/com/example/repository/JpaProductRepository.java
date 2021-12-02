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
    public Product findById(int productId) {
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Product product=entityManager.find(Product.class,productId);
        entityManager.getTransaction().commit();
        entityManager.close();;
        return product;
    }



    @Override
    public void save(Product product) {
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
        entityManager.close();;
    }

    @Override
    public void delete(int productId) {
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Product.class,productId));
        entityManager.getTransaction().commit();
        entityManager.close();;
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
