package com.example.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.exceptions.InvalidCredentialException;
import com.example.exceptions.UserNotFoundException;
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
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
            if (result.verified) {
                return user;
            } else {
                throw new InvalidCredentialException("incorrect user/password");
            }
        } else {
            throw new UserNotFoundException("No user found");
        }

    }

}
