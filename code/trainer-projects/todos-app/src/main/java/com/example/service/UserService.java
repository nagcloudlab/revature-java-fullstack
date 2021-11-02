package com.example.service;

import com.example.model.User;

public interface UserService {

    void register(User user);

    void login(String email, String password);

}
