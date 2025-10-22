package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateSingleRecordWithoutEnduserValues {

    static final String url = "jdbc:mysql://localhost:3306/jfs30_32";
    static final String username = "root";
    static final String password = "root";

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            int updateId = 555;
            String newName = "Ravi";
            double newSalary = 55000;

            // Change "salary" to "esal" if your column name is different
            String sql = "UPDATE employee SET ename='" + newName + "', esal=" + newSalary + " WHERE eno=" + updateId;
            int rowsaffected = statement.executeUpdate(sql);

            if (rowsaffected >= 1) {
                System.out.println(" Record with ID " + updateId + " updated successfully!");
            } else {
                System.out.println(" No record found with ID " + updateId + ".");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
