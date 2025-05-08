package com.Tap.DAOImp;



	import com.Tap.DAO.UserDAO;
	import com.Tap.Model.User;
	import com.Tap.Utility.DBConnection;

	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

	public class UserDAOImpl implements UserDAO {

		@Override
		public boolean addUser(User user) {
		    String insert = "INSERT INTO user(name, userName, password, email, phone, address, role, createDate, lastLoginDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		    try (Connection connection = DBConnection.getConnection();
		         PreparedStatement preparedStatement = connection.prepareStatement(insert)) {

		        preparedStatement.setString(1, user.getName());
		        preparedStatement.setString(2, user.getUserName());
		        preparedStatement.setString(3, user.getPassword());
		        preparedStatement.setString(4, user.getEmail());
		        preparedStatement.setString(5, user.getPhone());
		        preparedStatement.setString(6, user.getAddress());
		        preparedStatement.setString(7, user.getRole());
		       // preparedStatement.setDate(8, new java.sql.Date(user.getCreateDate().getTime()));
		       // preparedStatement.setDate(9, new java.sql.Date(user.getLastLoginDate().getTime()));
		        
		        preparedStatement.setDate(8, new java.sql.Date(user.getCreateDate().getTime()));

		        // If rows were affected, return true
		        
		        if (user.getLastLoginDate() != null) {
		            preparedStatement.setDate(9, new java.sql.Date(user.getLastLoginDate().getTime()));
		        } else {
		            preparedStatement.setNull(9, java.sql.Types.DATE); // If null, set SQL NULL
		        }
		        int rowsAffected = preparedStatement.executeUpdate();
		        return rowsAffected > 0;
		        
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return false; // Return false if an error occurs
		    }
		}

	    @Override
	    public void updateUser(User user) {
	        String update = "UPDATE user SET name=?, userName=?, password=?, email=?, phone=?, address=?, role=?, lastLoginDate=? WHERE userId=?";

	        try (Connection connection = DBConnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(update)) {
	            preparedStatement.setString(1, user.getName());
	            preparedStatement.setString(2, user.getUserName());
	            preparedStatement.setString(3, user.getPassword());
	            preparedStatement.setString(4, user.getEmail());
	            preparedStatement.setString(5, user.getPhone());
	            preparedStatement.setString(6, user.getAddress());
	            preparedStatement.setString(7, user.getRole());
	          //  preparedStatement.setDate(8, new java.sql.Date(user.getLastLoginDate().getTime()));
	           // preparedStatement.setInt(9, user.getUserId());
	            if (user.getLastLoginDate() != null) {
	                preparedStatement.setDate(8, new java.sql.Date(user.getLastLoginDate().getTime()));
	            } else {
	                preparedStatement.setNull(8, java.sql.Types.DATE);  // Set SQL NULL for lastLoginDate
	            }
	            
	            preparedStatement.setInt(9, user.getUserId());

	           // preparedStatement.executeUpdate();

	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void deleteUser(int userId) {
	        String deleteQuery = "DELETE FROM user WHERE userId=?";

	        try (Connection connection = DBConnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
	            preparedStatement.setInt(1, userId);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public User getUser(int userId) {
	        String selectQuery = "SELECT * FROM user WHERE userId=?";
	        User user = null;

	        try (Connection connection = DBConnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
	            preparedStatement.setInt(1, userId);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                user = new User(
	                    resultSet.getInt("userId"),
	                    resultSet.getString("name"),
	                    resultSet.getString("userName"),
	                    resultSet.getString("password"),
	                    resultSet.getString("email"),
	                    resultSet.getString("phone"),
	                    resultSet.getString("address"),
	                    resultSet.getString("role"),
	                    resultSet.getDate("createDate"),
	                    resultSet.getDate("lastLoginDate")
	                );
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return user;
	    }

	    @Override
	    public List<User> getAllUsers() {
	        String selectAllQuery = "SELECT * FROM user";
	        List<User> users = new ArrayList<>();

	        try (Connection connection = DBConnection.getConnection();
	             Statement statement = connection.createStatement();
	             ResultSet resultSet = statement.executeQuery(selectAllQuery)) {

	            while (resultSet.next()) {
	                User user = new User(
	                    resultSet.getInt("userId"),
	                    resultSet.getString("name"),
	                    resultSet.getString("userName"),
	                    resultSet.getString("password"),
	                    resultSet.getString("email"),
	                    resultSet.getString("phone"),
	                    resultSet.getString("address"),
	                    resultSet.getString("role"),
	                    resultSet.getDate("createDate"),
	                    resultSet.getDate("lastLoginDate")
	                );
	                users.add(user);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return users;
	    }
	    
	   private Connection getConnection() throws SQLException {
	        // Assuming you're using JDBC to connect to the database
	        String url = "jdbc:mysql://localhost:3306/restaurant_management_system";
	        String username = "root";
	        String password = "password"; // Update this with your DB credentials
	        return DriverManager.getConnection(url, username, password);
	    }

	   @Override
	    public User authenticateUser(String username, String password) {
	        User user = null;
	        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
	        
	        try (Connection connection = getConnection();
	             PreparedStatement stmt = connection.prepareStatement(query)) {
	             
	            stmt.setString(1, username);
	            stmt.setString(2, password);

	            ResultSet resultSet = stmt.executeQuery();

	            if (resultSet.next()) {
	                // Create a User object with the fetched data
	               
	                		user = new User(
	        	                    resultSet.getInt("userId"),
	        	                    resultSet.getString("name"),
	        	                    resultSet.getString("userName"),
	        	                    resultSet.getString("password"),
	        	                    resultSet.getString("email"),
	        	                    resultSet.getString("phone"),
	        	                    resultSet.getString("address"),
	        	                    resultSet.getString("role"),
	        	                    resultSet.getDate("createDate"),
	        	                    resultSet.getDate("lastLoginDate")
	        	                );
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return user; // Returns null if no match is found
	    }
	


}
