package com.revature;

import com.revature.db.DatabaseConnectionFactory;
import com.revature.model.Account;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/*
    // Atomic Transaction
    => keep changes if all steps are successful in unit-of-work
       else bring back original state

       -or-

    => All or nothing

 */

public class Ex_TransactionManagement {

    private static final Logger logger = Logger.getLogger("mts");

    public static void main(String[] args) {

        Connection connection = null;

        try {
            connection = DatabaseConnectionFactory.getConnection();
            connection.setAutoCommit(false); // start transaction

            Account account1 = new Account("1", 1000.00);
            Account account2 = new Account("2", 1000.00);

            String sql = "insert into accounts values(?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            // step-1: insert account-3
            ps.setString(1, account1.getNumber());
            ps.setDouble(2, account1.getBalance());
            ps.executeUpdate();
//
//            boolean b = true;
//            if (b)
//                throw new IllegalStateException("something bad happened");

            // step-2: insert account-3
            ps.setString(1, account2.getNumber());
            ps.setDouble(2, account2.getBalance());
            ps.executeUpdate();
//

            connection.commit(); // changes in db become permanent
            System.out.println("transaction is successfully");

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback(); //
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
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


    }

}
