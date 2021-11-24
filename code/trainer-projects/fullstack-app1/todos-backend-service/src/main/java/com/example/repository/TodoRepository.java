package com.example.repository;

import com.example.entity.Todo;

import java.util.List;

public interface TodoRepository {

    void save(Todo todo);
    void delete(int id);
    List<Todo> findAll();

}
