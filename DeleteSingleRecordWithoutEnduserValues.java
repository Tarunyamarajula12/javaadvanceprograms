package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteSingleRecordWithoutEnduserValues {

    // Database connection details
    static final String url = "jdbc:mysql://localhost:3306/jfs30_32";
    static final String username = "root";
    static final String password = "root";

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            // Hardcoded employee ID to delete
            int deleteId = 2;

            // SQL DELETE query
            String sql = "DELETE FROM employee WHERE eno = " + deleteId;

            // Execute the query
            int rowsAffected = statement.executeUpdate(sql);

            // Display result
            if (rowsAffected >= 1) {
                System.out.println(" Record with ID " + deleteId + " deleted successfully!");
            } else {
                System.out.println(" No record found with ID " + deleteId + ".");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
