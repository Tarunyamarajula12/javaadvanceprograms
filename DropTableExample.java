package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class DropTableExample {
    static final String jdbc_url = "jdbc:mysql://localhost:3306/jfs30_32";
    static final String userName = "root";
    static final String password = "root";

    public static void main(String[] args) {
        // Try-with-resources to automatically close connection and statement
        try (Connection connection = DriverManager.getConnection(jdbc_url, userName, password);
             Statement statement = connection.createStatement()) {

            String sql = "DROP TABLE IF EXISTS employee";
            statement.executeUpdate(sql);
            System.out.println("Table deleted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
