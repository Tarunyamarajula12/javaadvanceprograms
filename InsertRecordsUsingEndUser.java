package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertRecordsUsingEndUser {
	static final String jdbc_Url="jdbc:mysql://localhost:3306/jfs30_32";
	static final String userName="root";
	static final String password="root";

	public static void main(String[] args) {
		try(Connection connection=DriverManager.getConnection(jdbc_Url,userName,password);
				Statement statement=connection.createStatement()){
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Employee Number:");
			int eno=sc.nextInt();
			System.out.println("Enter Employee Name:");
			String ename=sc.next();
			System.out.println("Enter Employee Salary:");
			double esal=sc.nextDouble();
			System.out.println("Enter Employee Address:");
			String eaddr=sc.next();
			
			String insertSql="insert into employee(eno,ename,esal,eaddr)"
				+"values("+eno+",'"+ename+"',"+esal+",'"+eaddr+"')";
			int rowsAffected=statement.executeUpdate(insertSql);
			if(rowsAffected==1) {
				System.out.println("Record Inserted Succesfully");
				
			}else {
				System.out.println("Failed to insert record");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}


	}

}
