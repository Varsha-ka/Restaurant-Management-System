package com.Tap.DAOImp;


import com.Tap.DAO.MenuDAO;
import com.Tap.Model.Menu;
import com.Tap.Utility.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

public class MenuDAOImpl implements MenuDAO {

    @Override
    public void addMenuItem(Menu menu) {
        String insertQuery = "INSERT INTO menu(restaurantId, itemName, description, price, isAvailable, ratings, imagePath) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setInt(1, menu.getRestaurantId());
            preparedStatement.setString(2, menu.getItemName());
            preparedStatement.setString(3, menu.getDescription());
            preparedStatement.setDouble(4, menu.getPrice());
            preparedStatement.setBoolean(5, menu.isAvailable());
            preparedStatement.setDouble(6, menu.getRatings());
            preparedStatement.setString(7, menu.getImagePath());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Menu getMenuItem(int menuId) {
        String selectQuery = "SELECT * FROM menu WHERE menuId=?";
        Menu menu = null;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setInt(1, menuId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                menu = new Menu(
                    resultSet.getInt("menuId"),
                    resultSet.getInt("restaurantId"),
                    resultSet.getString("itemName"),
                    resultSet.getString("description"),
                    resultSet.getDouble("price"),
                    resultSet.getBoolean("isAvailable"),
                    resultSet.getDouble("ratings"),
                    resultSet.getString("imagePath")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menu;
    }

    @Override
    public void updateMenuItem(Menu menu) {
        String updateQuery = "UPDATE menu SET restaurantId=?, itemName=?, description=?, price=?, isAvailable=?, ratings=?, imagePath=? WHERE menuId=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setInt(1, menu.getRestaurantId());
            preparedStatement.setString(2, menu.getItemName());
            preparedStatement.setString(3, menu.getDescription());
            preparedStatement.setDouble(4, menu.getPrice());
            preparedStatement.setBoolean(5, menu.isAvailable());
            preparedStatement.setDouble(6, menu.getRatings());
            preparedStatement.setString(7, menu.getImagePath());
            preparedStatement.setInt(8, menu.getMenuId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMenuItem(int menuId) {
        String deleteQuery = "DELETE FROM menu WHERE menuId=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, menuId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Menu> getMenuByRestaurant(int restaurantId) {
        String selectQuery = "SELECT * FROM menu WHERE restaurantId=?";
        List<Menu> menuList = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setInt(1, restaurantId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Menu menu = new Menu(
                    resultSet.getInt("menuId"),
                    resultSet.getInt("restaurantId"),
                    resultSet.getString("itemName"),
                    resultSet.getString("description"),
                    resultSet.getDouble("price"),
                    resultSet.getBoolean("isAvailable"),
                    resultSet.getDouble("ratings"),
                    resultSet.getString("imagePath")
                );
                menuList.add(menu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuList;
    }
}

