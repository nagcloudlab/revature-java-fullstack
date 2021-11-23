package com.example.service;


import com.example.entity.User;

public interface UserService {

    void register(User user);

    User login(String email, String password);

}
