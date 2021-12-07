package com.example.repository;

import com.example.db.MySQLConnectionFactory;
import com.example.model.Todo;
import com.example.model.TodoFilter;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
    design pattern:
    ------------------

    dao(data accessing object  /repository
    to do CRUD operations against datasource

    why we need dao/repository pattern ?

    => isolate db operation from regular code
    => can-use db operation on multiple parts of applications

 */

public class JdbcTodoRepository implements TodoRepository {

    @Override
    public void save(Todo todo) {
        Connection connection = null;
        try {
            connection = MySQLConnectionFactory.getConnection();
            // step-3 :  create JDBC statements with SQL
            String sql = "insert into todos(title,completed,user_id) values (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, todo.getTitle());
            ps.setBoolean(2, todo.isCompleted());
            ps.setInt(3, todo.getUser().getId()); // user_id hard-coded

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

    @Override
    public void update(int id, String title) {

        Connection connection = null;
        try {
            connection = MySQLConnectionFactory.getConnection();
            String sql = "update todos set title=? where id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, title);
            ps.setInt(2, id);

            int rowCount = ps.executeUpdate();
            if (rowCount == 1) {
                System.out.println("Todo updated..");
            }

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

    @Override
    public void update(int id, boolean completed) {
        {

            Connection connection = null;
            try {
                connection = MySQLConnectionFactory.getConnection();
                String sql = "update todos set completed=? where id=?";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setBoolean(1, completed);
                ps.setInt(2, id);

                int rowCount = ps.executeUpdate();
                if (rowCount == 1) {
                    System.out.println("Todo updated..");
                }

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

    @Override
    public void delete(int id) {
        {

            Connection connection = null;
            try {
                connection = MySQLConnectionFactory.getConnection();
                String sql = "delete from todos where id=?";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, id);

                int rowCount = ps.executeUpdate();
                if (rowCount == 1) {
                    System.out.println("Todo deleted..");
                }

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

    @Override
    public List<Todo> findAll(TodoFilter todoFilter, int userId) {

        List<Todo> todos = new ArrayList<>();

        Connection connection = null;
        try {
            connection = MySQLConnectionFactory.getConnection();
            // step-3 :  create JDBC statements with SQL
            String sql = "select * from todos where user_id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userId);
            // step-4 :  execute JDBC-statements & process results
            ResultSet rs = ps.executeQuery();

            // Mapping relational data to objects
            while (rs.next()) {
                Todo todo = new Todo();
                todo.setId(rs.getInt("id"));
                todo.setTitle(rs.getString("title"));
                todo.setCompleted(rs.getBoolean("completed"));
                todos.add(todo);
            }

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

        return todos;

    }
}

