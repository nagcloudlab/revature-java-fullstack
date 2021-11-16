package org.example;

import java.util.List;

// repository means kind store where u have data-items e.g file , database

public interface UserRepository {

    User findUser(String username);

}
