package com.example.service;


import com.example.entity.Todo;
import com.example.entity.User;
import com.example.repository.TodoFilter;

import java.util.List;

public interface TodoService {

    void setUser(User user);

    void addTodo(String title);

    void editTodo(int id, String newTitle);

    void deleteTodo(int id);

    void completeTodo(int id);

    void completeAll();

    void clearCompleted();

    List<Todo> getTodos(TodoFilter todoFilter);


}
