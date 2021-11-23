package com.example.repository;

import com.example.entity.Todo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class JpaTodoRepository implements TodoRepository {

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
    public void update(int id, String title) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.find(Todo.class,id).setTitle(title);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void update(int id, boolean completed) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.find(Todo.class,id).setCompleted(completed);

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
    public List<Todo> findAll(TodoFilter todoFilter, int userId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        String jpql="from Todo where user.id=:userId";
        Query query=entityManager.createQuery(jpql);
        query.setParameter("userId",userId);
        List<Todo> todos= query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return  todos;
    }
}
