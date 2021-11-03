package com.example.model;


// Object Model
public class Todo {

    private int id; // 0
    private String title; // null
    private boolean completed; // false

    private User user;

    // constructor
    public Todo() {
    }

    public Todo(String title) {
        this.title = title;
    }

    public Todo(int id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    // accessor methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
