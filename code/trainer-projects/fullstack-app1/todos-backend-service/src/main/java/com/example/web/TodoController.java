package com.example.web;

import com.example.entity.Todo;
import com.example.repository.JpaTodoRepository;
import com.example.repository.TodoRepository;
import io.javalin.http.Handler;
import org.eclipse.jetty.http.HttpStatus;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TodoController {

    static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
    }

    //-------------------------------------------------
    static TodoRepository todoRepository = new JpaTodoRepository(entityManagerFactory);
    //--------------------------------------------------

    public static Handler createTodo = ctx -> {
        String userId=ctx.pathParam("userId");
        System.out.println(userId);
        Todo todo = ctx.bodyAsClass(Todo.class);
        todoRepository.save(todo);
        ctx.status(HttpStatus.CREATED_201);
    };

    public static Handler getAllTodos = ctx -> {
        String filter = ctx.queryParam("filter");
        if (filter == null) {
            filter = "all";
        }
        List<Todo> todos = todoRepository.findAll(filter);
        ctx.json(todos);
    };

    public static Handler getTodo = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Todo todo = todoRepository.findById(id);
        if (todo == null) {
            ctx.status(HttpStatus.NOT_FOUND_404);
        } else
            ctx.json(todo);
    };

    public static Handler deleteTodo = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        todoRepository.delete(id);
        ctx.status(HttpStatus.OK_200);
    };

}
