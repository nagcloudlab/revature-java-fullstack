package org.example;

/**
 *
 * author : Me , a week
 *
 */

// dependent
public class LoginService {

    // dependency
    private UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean doLogin(String username, String password) {

        if (username.isEmpty())
            throw new InvalidInputException("username cannot be empty");

        if (password.isEmpty())
            throw new InvalidInputException("password cannot be empty");

        User user=userRepository.findUser(username);

        if (username.equals(user.getUsername()) && password.equals(user.getPassword()))
            return true;
        else
            return false;

    }

}
