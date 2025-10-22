package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class createTableexample {
	static final String driver_name="com.mysql.cj.jdbc.Driver";
	static final String jdbc_Url="jdbc:mysql://localhost:3306/jfs30_32";
	static final String userName="root";
	static final String password="root";

	public static void main(String[] args) {
		Connection connection =null;
		Statement statement = null;
		
		try{
			//load and register the driver
		Class.forName(driver_name);
		      //establish connection to database
		connection = DriverManager.getConnection(jdbc_Url, userName, password);
		      //create statement object
		statement =connection.createStatement();
		
		String sqlquery="create table  if not exists student("
				+"sno int auto_increment primary key,"
				+"sname varchar(100),"
				+"sfee decimal(10,2),"
				+"saddr varchar(100)"+")";
		
		//send sql query to database
		statement.execute(sqlquery);
		System.out.println("table created successfully");
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			if(statement!=null) {
				try {
					statement.close();
				}catch(SQLException e) {
					e.printStackTrace();
					
				}finally {
					if(connection!=null) {
						try {
							connection.close();
						}catch(SQLException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		

	}

}
