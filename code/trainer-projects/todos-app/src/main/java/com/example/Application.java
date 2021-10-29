package com.example;

import com.example.model.TodoFilter;
import com.example.repository.InMemoryTodoRepository;
import com.example.repository.TodoRepository;
import com.example.service.TodoService;
import com.example.service.TodoServiceImpl;

public class Application {

    public static void main(String[] args) {

        //------------------------------------------------------------------
        // Init
        //------------------------------------------------------------------

        TodoRepository todoRepository = new InMemoryTodoRepository(); // dependency
        TodoService todoService = new TodoServiceImpl(todoRepository); // dependent

        //------------------------------------------------------------------
        // Use
        //------------------------------------------------------------------

        todoService.addTodo("todo1");
        todoService.addTodo("todo2");
        todoService.addTodo("todo3");

        todoService.editTodo(1,"todo one");
        todoService.completeTodo(2);
        todoService.deleteTodo(3);

        todoService.getTodos(TodoFilter.ALL)
                .forEach(System.out::println);


    }

}
