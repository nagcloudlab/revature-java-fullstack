package com.example.service;

import com.example.model.Todo;
import com.example.model.TodoFilter;
import com.example.model.User;

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
