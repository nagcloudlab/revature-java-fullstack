package com.example.db;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// factory-class
public class MySQLConnectionFactory {

    // factory-method
    public static Connection getConnection() throws SQLException {

        Connection connection = null;
        // step-1 : Install / Register JDBC driver
//        DriverManager.registerDriver(new Driver());

        // step-2 : create DB-connection with URL, username & password
        String url = "jdbc:mysql://localhost:3306/todosdb";
        String username = "root";
        String password = "Root$1212";

        connection = DriverManager.getConnection(url, username, password);

        return connection;
    }

}
