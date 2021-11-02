package com.example.repository;

import com.example.model.User;

public interface UserRepository {

    void save(User user);
    User findByEmail(String email);
    //...


}
