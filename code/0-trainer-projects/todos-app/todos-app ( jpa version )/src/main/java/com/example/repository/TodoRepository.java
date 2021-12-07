package com.example.repository;

import com.example.entity.Todo;

import java.util.List;

public interface TodoRepository {

    // data accessing methods ( dao ) on any datasource ( database )
    void save(Todo todo);

    void update(int id, String title);

    void update(int id, boolean completed);

    void delete(int id);

    List<Todo> findAll(TodoFilter todoFilter, int userId);

}
