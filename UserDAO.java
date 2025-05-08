package com.Tap.DAO;
import com.Tap.Model.User;
import java.util.List;

public interface UserDAO {
	
	    boolean addUser(User user);
	    User getUser(int userId);
	    void updateUser(User user);
	    void deleteUser(int userId);
	    List<User> getAllUsers();
		User authenticateUser(String username, String password);
	


}
