package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class createTable {
	// steps to prepare the jdbc applications
			static final String driver_name="com.mysql.cj.jdbc.Driver";
			static final String jdbc_Url="jdbc:mysql://localhost:3306/jfs30_32";
			static final String userName="root";
			static final String password="root";

	public static void main(String[] args) {
		Connection connection=null;
		Statement statement=null;
		try {
			//load and register the driver
			Class.forName(driver_name);
			// Establish the connection to database.
			connection=DriverManager.getConnection(jdbc_Url,userName,password);
			//3.create statement object
			statement=connection.createStatement();
			
			String sqlQuery="CREATE TABLE IF NOT EXISTS EMPLOYEE("
					+"ENO INT AUTO_INCREMENT PRIMARY KEY,"
					+"ENAME VARCHAR(100),"
					+"ESAL DECIMAL(10,2),"
					+"EADDR VARCHAR(50)"+")";
			
			// 4.send our sql query to database
			statement.execute(sqlQuery);
			System.out.println("Table created succesfully");
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(statement!=null) {
				try {
					statement.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection!=null) {
				try {
					connection.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}