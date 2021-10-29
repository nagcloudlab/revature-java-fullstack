package com.example.repository;

import com.example.model.Todo;
import com.example.model.TodoFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InMemoryTodoRepository implements TodoRepository {

    private List<Todo> inMemoryTodos = new ArrayList<>(); // in-memory-db

    @Override
    public void save(Todo todo) {
        todo.setId(inMemoryTodos.size()+1);
        this.inMemoryTodos.add(todo);
    }

    @Override
    public void update(int id, String title) {
        Todo todo = this.inMemoryTodos
                .stream()
                .filter(ele -> ele.getId() == id)
                .findFirst()
                .get();
        todo.setTitle(title);
    }

    @Override
    public void update(int id, boolean completed) {
        Todo todo = this.inMemoryTodos
                .stream()
                .filter(ele -> ele.getId() == id)
                .findFirst()
                .get();
        todo.setCompleted(completed);
    }

    @Override
    public void delete(int id) {
        inMemoryTodos
                .removeIf(todo -> todo.getId() == id);
    }

    @Override
    public List<Todo> findAll(TodoFilter todoFilter) {
        Predicate<Todo> filterFn = todo -> true;
        if (todoFilter.equals(TodoFilter.ACTIVE))
            filterFn = todo -> !todo.isCompleted();
        if (todoFilter.equals(TodoFilter.COMPLETED))
            filterFn = todo -> todo.isCompleted();
        return inMemoryTodos
                .stream()
                .filter(filterFn)
                .collect(Collectors.toList());
    }
}
