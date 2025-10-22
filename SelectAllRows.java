package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAllRows {
    static final String jdbc_Url = "jdbc:mysql://localhost:3306/jfs30_32";
    static final String userName = "root";
    static final String password = "root";

    public static void main(String[] args) {
        // ✅ Correct syntax for try-with-resources (semicolon between resources)
        try (Connection connection = DriverManager.getConnection(jdbc_Url, userName, password);
             Statement statement = connection.createStatement()) {

            String selectQuery = "SELECT * FROM employee";
            ResultSet rs = statement.executeQuery(selectQuery);

            System.out.println("ENO\tEname\tEsal\tEaddr");
            System.out.println("===========================================");

            while (rs.next()) {
                int eno = rs.getInt(1);
                String ename = rs.getString(2);
                double esal = rs.getDouble(3);
                String eaddr = rs.getString(4);

                System.out.println(eno + "\t" + ename + "\t" + esal + "\t" + eaddr);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
