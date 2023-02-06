package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import Model.member;


public class DbConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(DbConnection.getDB());

	}
	
	public static Connection getDB() {
		String url="jdbc:mysql://localhost:3306/company";
		String username="root";
		String password="1234";
		
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}

}
