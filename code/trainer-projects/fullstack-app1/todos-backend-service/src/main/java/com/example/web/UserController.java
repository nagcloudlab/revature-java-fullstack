package com.example.web;

import com.example.entity.Todo;
import io.javalin.http.Handler;
import org.eclipse.jetty.http.HttpStatus;

public class UserController {

    public static Handler createNewUser = ctx -> {

        //...

        ctx.status(HttpStatus.CREATED_201);
    };

}
