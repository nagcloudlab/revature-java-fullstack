package com.example;

import com.example.web.TodoController;
import io.javalin.Javalin;

public class Application {

    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {
            // your config here
            config.enableCorsForAllOrigins();
        }).start(8080); // server:8080



        //------------------------------------
        // REST API
        //------------------------------------

        // Routes
        app.post("/todos",TodoController.postTodo);
        app.get("/todos", TodoController.getAllTodos);
        app.get("/todos/{id}",TodoController.getTodo);
        app.delete("/todos/{id}",TodoController.deleteTodo);


    }
}
