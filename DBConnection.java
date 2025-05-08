package com.Tap.Utility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static final Connection getConnection() {
		
		Connection connection=null;
		try {
			String url="jdbc:mysql://localhost:3306/food_res";
			String username="root";
			String password="rasi@123";
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection(url,username,password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

}



