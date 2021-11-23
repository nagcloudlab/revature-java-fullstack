package com.example.service;

import com.example.model.Todo;
import com.example.model.TodoFilter;
import com.example.model.User;
import com.example.repository.TodoRepository;

import java.util.List;


/*
    service:

    to process data based business rules

 */

public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;
    private User user;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void addTodo(String title) {
        Todo newTodo = new Todo(title); // entity i.e obj's data we will in database
        newTodo.setUser(user);
        todoRepository.save(newTodo);
    }

    @Override
    public void editTodo(int id, String newTitle) {
        todoRepository.update(id, newTitle);
    }

    @Override
    public void deleteTodo(int id) {
        todoRepository.delete(id);
    }

    @Override
    public void completeTodo(int id) {
        todoRepository.update(id, true);
    }

    @Override
    public void completeAll() {
        // TODO
    }

    @Override
    public void clearCompleted() {
        // TODO
    }

    @Override
    public List<Todo> getTodos(TodoFilter todoFilter) {
        return todoRepository.findAll(todoFilter,user.getId());
    }

}
