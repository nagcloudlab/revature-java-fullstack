package com.revature.repository;

import com.revature.db.DatabaseConnectionFactory;
import com.revature.model.Account;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class JdbcAccountRepository implements AccountRepository {

    private static final Logger logger = Logger.getLogger("mts");

    @Override
    public Optional<Account> loadAccount(String accountNumber) {
        logger.info("loading account - " + accountNumber);
        Connection connection = null;
        Account account = null;
        try {
            connection = DatabaseConnectionFactory.getConnection();
            String sql = "select * from accounts where number=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, accountNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) { //
                account = new Account();
                account.setNumber(rs.getString("number"));
                account.setBalance(rs.getDouble("balance"));
            }
        } catch (SQLException e) {
            logger.warn(e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        if (account == null)
            return Optional.empty();
        else
            return Optional.of(account);

    }

    @Override
    public void updateAccount(Account account) {
        logger.info("updaing account - " + account.getNumber());
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
