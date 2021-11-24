package com.example;

import com.example.web.TodoController;
import com.example.web.UserController;
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
        app.post("/users", UserController.createNewUser);
        app.post("/users/{userId}/todos",TodoController.createTodo);
        app.get("/users/{userId}/todos", TodoController.getAllTodos);
        app.get("/users/{userId}/todos/{id}",TodoController.getTodo);
        app.delete("/users/{userId}/todos/{id}",TodoController.deleteTodo);


    }
}
