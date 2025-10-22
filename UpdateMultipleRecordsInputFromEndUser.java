package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateMultipleRecordsInputFromEndUser {

    static final String url = "jdbc:mysql://localhost:3306/jfs30_32";
    static final String username = "root";
    static final String password = "root";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String sql = "UPDATE employee SET ename=?, esal=? WHERE eno=?";

        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = con.prepareStatement(sql)) {

            System.out.print("Enter number of employee records to update: ");
            int n = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            for (int i = 1; i <= n; i++) {
                System.out.println("\n--- Update Record " + i + " ---");

                System.out.print("Enter employee number (eno): ");
                int eno = sc.nextInt();
                sc.nextLine(); // consume newline

                System.out.print("Enter new employee name: ");
                String ename = sc.nextLine();

                System.out.print("Enter new salary: ");
                double esal = sc.nextDouble();
                sc.nextLine(); // consume newline

                // Set parameters
                ps.setString(1, ename);
                ps.setDouble(2, esal);
                ps.setInt(3, eno);

                int rows = ps.executeUpdate();

                if (rows > 0) {
                    System.out.println("✅ Record updated successfully for eno = " + eno);
                } else {
                    System.out.println("⚠️ No record found for eno = " + eno);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
