package com.example.repository;

import com.example.entity.Todo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class JpaTodoRepository implements TodoRepository{

    private EntityManagerFactory entityManagerFactory;

    public JpaTodoRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void save(Todo todo) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(todo);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.remove(entityManager.find(Todo.class,id));

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Todo> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        String jpql="from Todo";
        Query query=entityManager.createQuery(jpql);
        List<Todo> todos= query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return  todos;
    }
}
