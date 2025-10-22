package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTableRecords {
    static final String jdbc_url = "jdbc:mysql://localhost:3306/jfs30_32";
    static final String userName = "root";
    static final String password = "root";

    public static void main(String[] args) {
        // Correct try-with-resources syntax
        try (Connection connection = DriverManager.getConnection(jdbc_url, userName, password);
             Statement statement = connection.createStatement()) {

            // ✅ Fixed SQL syntax (commas between values)
            String insertSql = "INSERT INTO employee (eno, ename, esal, eaddr) " +
                               "VALUES (111, 'malli', 60000, 'hyd')";

            int rowsAffected = statement.executeUpdate(insertSql);

            if (rowsAffected == 1) {
                System.out.println("Record inserted successfully.");
            } else {
                System.out.println("Failed to insert record.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}