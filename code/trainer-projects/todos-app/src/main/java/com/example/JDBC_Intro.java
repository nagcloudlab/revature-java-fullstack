package com.example;

//import com.mysql.cj.jdbc.Driver;

import java.sql.*; // JDBC API

public class JDBC_Intro {

    public static void main(String[] args) {

        Connection connection = null;
        try {
            // step-1 : Install / Register JDBC driver
//            DriverManager.registerDriver(new Driver());

            // step-2 : create DB-connection with URL, username & password
            String url = "jdbc:mysql://localhost:3306/todosdb";
            String username = "root";
            String password = "Root$1212";

            connection = DriverManager.getConnection(url, username, password);

            // step-3 :  create JDBC statements with SQL
            String sql = "insert into todos(title,completed,user_id) values (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "todo9");
            ps.setBoolean(2, false);
            ps.setInt(3, 1);


            // step-4 :  execute JDBC-statements & process results
            int rowCount = ps.executeUpdate();
            if (rowCount == 1)
                System.out.println("New Todo inserted into database");


         // step-5 : Handle SQL-exceptions
        } catch (SQLException e) {
            e.printStackTrace(); // print exception details in console
        } finally {
            // step-7 : close / release connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
