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
    public List<Todo> findAll(String filter) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        String jpql="from Todo";
        if(filter.equals("active")){
            jpql="from Todo where completed=false";
        }
        if(filter.equals("completed")){
            jpql="from Todo where completed=true";
        }
        Query query=entityManager.createQuery(jpql);
        List<Todo> todos= query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return  todos;
    }

    @Override
    public Todo findById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Todo todo=entityManager.find(Todo.class,id);

        entityManager.getTransaction().commit();
        entityManager.close();
        return  todo;
    }
}
