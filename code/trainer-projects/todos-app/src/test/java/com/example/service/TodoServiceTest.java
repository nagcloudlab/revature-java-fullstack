package com.example.service;

import com.example.model.Todo;
import com.example.model.TodoFilter;
import com.example.model.User;
import com.example.repository.TodoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class TodoServiceTest {

    private TodoRepository todoRepository;
    private TodoService todoService;


    @BeforeEach
    public void setup() {
        todoRepository = Mockito.mock(TodoRepository.class);
        todoService = new TodoServiceImpl(todoRepository);
    }

    @Test
    public void addTodoTest() {
        todoService.addTodo("todo-1");
        Mockito.verify(todoRepository, Mockito.times(1)).save(new Todo("todo-1"));
    }

    @Test
    public void getTodosTest() {
        User user = new User();
        user.setId(1);
        Mockito.when(todoRepository.findAll(TodoFilter.ALL, user.getId())).thenReturn(
                List.of(
                        new Todo(),
                        new Todo()
                )
        );
        todoService.setUser(user);
        List<Todo> todos = todoService.getTodos(TodoFilter.ALL);
        Assertions.assertEquals(2, todos.size());

    }


}
