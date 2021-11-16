package com.example.model;

import java.io.Serializable;

// Author : NAg

// Marking the UserSession class objects are serializable
public class UserSession implements Serializable {

    private static final long serialVersionUID=12312312334234L;

    private transient int id;
    private String name;
    private String newProperty;

    public UserSession(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "UserSession{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
