package org.example;

/**
 *
 * author : You . a week
 *
 */

public class SqlDatabaseUserRepostoryImpl implements UserRepository {

    @Override
    public User findUser(String username) {
        // JDBC code, i.e load user details from database
        return new User(username,"bar");
    }
}
