package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertMultipuleRecordsByPreparedStatement {



	static final String jdbc_Url="jdbc:mysql://localhost:3306/jfs30_32";
	static final String userName="root";
	static final String password="root";
	
	public static void main(String[] args) {
		String sqlQuery = "insert into employee(eno,ename,esal,eaddr) values(? ,?, ? ,?)";
		try(Connection connection = DriverManager.getConnection(jdbc_Url, userName, password);
				PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
			//set values to the positional parameters
			preparedStatement.setInt(1, 666);
			preparedStatement.setString(2, "manesha");
			preparedStatement.setDouble(3, 37000);
			preparedStatement.setString(4, "hyd");
			
			int rowsAffected = preparedStatement.executeUpdate();
			if(rowsAffected==1) {
				System.out.println("record insertion successfull");
			}else {
				System.out.println("record insertion failure");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		

	}
}


