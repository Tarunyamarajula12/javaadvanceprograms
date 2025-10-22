package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteMultipleRecordsInputFromEnduser {

    static final String url = "jdbc:mysql://localhost:3306/jfs30_32";
    static final String username = "root";
    static final String password = "root";

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("How many employee IDs do you want to delete? ");
            int count = scanner.nextInt();

            for (int i = 1; i <= count; i++) {
                System.out.print("Enter employee ID " + i + " to delete: ");
                int deleteId = scanner.nextInt();

                String sql = "DELETE FROM employee WHERE eno = " + deleteId;
                int rowsAffected = statement.executeUpdate(sql);

                if (rowsAffected >= 1) {
                    System.out.println(" Record with ID " + deleteId + " deleted successfully!");
                } else {
                    System.out.println(" No record found with ID " + deleteId + ".");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
