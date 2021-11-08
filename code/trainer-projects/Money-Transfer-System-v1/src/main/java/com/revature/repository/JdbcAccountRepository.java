package com.revature.repository;

import com.revature.db.DatabaseConnectionFactory;
import com.revature.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcAccountRepository implements AccountRepository {
    @Override
    public Account loadAccount(String accountNumber) {
        Connection connection = null;
        Account account = new Account();
        try {
            connection = DatabaseConnectionFactory.getConnection();
            String sql = "select * from accounts where number=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, accountNumber);
            ResultSet rs = ps.executeQuery();
            rs.next();
            account.setNumber(rs.getString("number"));
            account.setBalance(rs.getDouble("balance"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return account;
    }

    @Override
    public void updateAccount(Account account) {
        {
            Connection connection = null;
            try {
                connection = DatabaseConnectionFactory.getConnection();
                String sql = "update accounts set balance=? where number=?";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setDouble(1, account.getBalance());
                ps.setString(2, account.getNumber());
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
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
}
