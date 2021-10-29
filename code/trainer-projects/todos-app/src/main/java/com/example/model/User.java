package com.example.model;

import java.util.List;

public class User {

    private String name;
    private String email;

    private List<Todo> todos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
