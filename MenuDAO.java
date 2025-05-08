package com.Tap.DAO;
import com.Tap.Model.Menu;
import java.util.List;


public interface MenuDAO {
	
	
		    void addMenuItem(Menu menu);
		    Menu getMenuItem(int menuId);
		    void updateMenuItem(Menu menu);
		    void deleteMenuItem(int menuId);
		    List<Menu> getMenuByRestaurant(int restaurantId);
		


	


}
