package com.example.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.model.User;
import com.example.repository.UserRepository;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(User user) {
        // hash the plain-text password
        // ref: https://github.com/patrickfav/bcrypt
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray());
        user.setPassword(bcryptHashString);
        // save user in database
        userRepository.save(user);
    }

    @Override
    public void login(String email, String password) {

    }
}
