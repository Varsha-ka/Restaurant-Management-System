package com.Tap.Lauch;

import com.Tap.DAOImp.MenuDAOImpl;
import com.Tap.DAOImp.OrderDAOImpl;
import com.Tap.DAOImp.OrderItemDAOImpl;
import com.Tap.DAOImp.RestaurantDAOImpl;
import com.Tap.DAOImp.UserDAOImpl;
import com.Tap.Model.*;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Launch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserDAOImpl userDAO = new UserDAOImpl();
        RestaurantDAOImpl restaurantDAO = new RestaurantDAOImpl();
        MenuDAOImpl menuDAO = new MenuDAOImpl();
        OrderDAOImpl orderDAO = new OrderDAOImpl();
        OrderItemDAOImpl orderItemDAO = new OrderItemDAOImpl(); 

        while (true) {
            System.out.println("\n=== Restaurant Management System ===");
            System.out.println("1. Manage Users");
            System.out.println("2. Manage Restaurants");
            System.out.println("3. Manage Menu");
            System.out.println("4. Manage Orders");
            System.out.println("5. Manage Order Items");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manageUsers(scanner, userDAO);
                    break;
                case 2:
                    manageRestaurants(scanner, restaurantDAO);
                    break;
                case 3:
                    manageMenu(scanner, menuDAO);
                    break;
                case 4:
                    manageOrders(scanner, orderDAO);
                    break;
                case 5:
                    manageOrderItems(scanner, orderItemDAO);
                    break;
                case 6:
                    System.out.println("Exiting system... Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void manageUsers(Scanner scanner, UserDAOImpl userDAO) {
        while (true) {
            System.out.println("\n=== User Management ===");
            System.out.println("1. Add User");
            System.out.println("2. View User");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. List All Users");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Username: ");
                    String username = scanner.next();
                    System.out.print("Enter Password: ");
                    String password = scanner.next();
                    System.out.print("Enter Email: ");
                    String email = scanner.next();
                    System.out.print("Enter Phone: ");
                    String phone = scanner.next();
                    System.out.print("Enter Address: ");
                    String address = scanner.next();
                    System.out.print("Enter Role ENUM('Customer', 'DeliveryAgent', 'RestorantAdmin', 'SuperAdmin'): ");
                    String role = scanner.next();
                    Date createDate = new Date(System.currentTimeMillis());

                    User user = new User(0, name, username, password, email, phone, address, role, createDate, null);
                    userDAO.addUser(user);
                    System.out.println("User added successfully!");
                    break;
                case 2:
                    System.out.print("Enter User ID: ");
                    int userId = scanner.nextInt();
                    User retrievedUser = userDAO.getUser(userId);
                    System.out.println(retrievedUser != null ? retrievedUser : "User not found.");
                    break;
                case 3:
                    System.out.print("Enter User ID to update: ");
                    int updateUserId = scanner.nextInt();
                    System.out.print("Enter New Name: ");
                    String newName = scanner.next();
                    System.out.print("Enter New Email: ");
                    String newEmail = scanner.next();
                    System.out.print("Enter New Phone: ");
                    String newPhone = scanner.next();
                    System.out.print("Enter New Address: ");
                    String newAddress = scanner.next();

                    User updatedUser = new User(updateUserId, newName, "", "", newEmail, newPhone, newAddress, "", null, null);
                    userDAO.updateUser(updatedUser);
                    System.out.println("User updated successfully!");
                    break;
                case 4:
                    System.out.print("Enter User ID to delete: ");
                    int deleteUserId = scanner.nextInt();
                    userDAO.deleteUser(deleteUserId);
                    System.out.println("User deleted successfully!");
                    break;
                case 5:
                    List<User> userList = userDAO.getAllUsers();
                    for (User u : userList) {
                        System.out.println(u);
                    }
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice! Returning to menu.");
            }
        }
    }

    private static void manageRestaurants(Scanner scanner, RestaurantDAOImpl restaurantDAO) {
        while (true) {
            System.out.println("\n=== Restaurant Management ===");
            System.out.println("1. Add Restaurant");
            System.out.println("2. View Restaurant");
            System.out.println("3. Update Restaurant");
            System.out.println("4. Delete Restaurant");
            System.out.println("5. List All Restaurants");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Restaurant Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Address: ");
                    String address = scanner.next();
                    System.out.print("Enter Phone Number: ");
                    String phone = scanner.next();
                    System.out.print("Enter Cuisine Type: ");
                    String cuisine = scanner.next();
                    System.out.print("Enter Delivery Time (in mins): ");
                    int deliveryTime = scanner.nextInt();
                    System.out.print("Enter Admin User ID: ");
                    int adminUserId = scanner.nextInt();
                    System.out.print("Enter Rating: ");
                    double rating = scanner.nextDouble();
                    System.out.print("Is Active? (true/false): ");
                    boolean isActive = scanner.nextBoolean();
                    System.out.print("Enter Image Path: ");
                    String imagePath = scanner.next();

                    Restaurant restaurant = new Restaurant(0, name, address, phone, cuisine, deliveryTime, adminUserId, rating, isActive, imagePath);
                    restaurantDAO.addRestaurant(restaurant);
                    System.out.println("Restaurant added successfully!");
                    break;
                case 2:
                    System.out.print("Enter Restaurant ID: ");
                    int restaurantId = scanner.nextInt();
                    Restaurant retrievedRestaurant = restaurantDAO.getRestaurant(restaurantId);
                    System.out.println(retrievedRestaurant != null ? retrievedRestaurant : "Restaurant not found.");
                    break;
                case 3:
                    System.out.print("Enter Restaurant ID to update: ");
                    int updateRestaurantId = scanner.nextInt();
                    System.out.print("Enter New Name: ");
                    String newName = scanner.next();
                    System.out.print("Enter New Address: ");
                    String newAddress = scanner.next();
                    System.out.print("Enter New Phone Number: ");
                    String newPhone = scanner.next();

                    Restaurant updatedRestaurant = new Restaurant(updateRestaurantId, newName, newAddress, newPhone, "", 0, 0, 0.0, true, "");
                    restaurantDAO.updateRestaurant(updatedRestaurant);
                    System.out.println("Restaurant updated successfully!");
                    break;
                case 4:
                    System.out.print("Enter Restaurant ID to delete: ");
                    int deleteRestaurantId = scanner.nextInt();
                    restaurantDAO.deleteRestaurant(deleteRestaurantId);
                    System.out.println("Restaurant deleted successfully!");
                    break;
                case 5:
                    List<Restaurant> restaurantList = restaurantDAO.getAllRestaurants();
                    for (Restaurant r : restaurantList) {
                        System.out.println(r);
                    }
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice! Returning to menu.");
            }
        }
    }

    private static void manageMenu(Scanner scanner, MenuDAOImpl menuDAO) {
        while (true) {
            System.out.println("\n=== Menu Management ===");
            System.out.println("1. Add Menu Item");
            System.out.println("2. View Menu Item");
            System.out.println("3. Update Menu Item");
            System.out.println("4. Delete Menu Item");
            System.out.println("5. List Menu by Restaurant");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Restaurant ID: ");
                    int restaurantId = scanner.nextInt();
                    System.out.print("Enter Item Name: ");
                    String itemName = scanner.next();
                    System.out.print("Enter Description: ");
                    String description = scanner.next();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    
                    System.out.print("Is Available? (true/false): ");
                    boolean isAvailable = scanner.nextBoolean();
                    System.out.print("Enter Ratings: ");
                    double ratings = scanner.nextDouble();
                    System.out.print("Enter Image Path: ");
                    String imagePath = scanner.next();

                    Menu menu = new Menu(0, restaurantId, itemName, description, price, isAvailable, ratings, imagePath);
                    menuDAO.addMenuItem(menu);
                    System.out.println("Menu item added successfully!");
                    break;
                case 2:
                    System.out.print("Enter Menu ID: ");
                    int menuId = scanner.nextInt();
                    Menu retrievedMenu = menuDAO.getMenuItem(menuId);
                    System.out.println(retrievedMenu != null ? retrievedMenu : "Menu item not found.");
                    break;
                case 3:
                    System.out.print("Enter Menu ID to update: ");
                    int updateMenuId = scanner.nextInt();
                    System.out.print("Enter New Item Name: ");
                    String newItemName = scanner.next();
                    System.out.print("Enter New Description: ");
                    String newDescription = scanner.next();
                    System.out.print("Enter New Price: ");
                    double newPrice = scanner.nextDouble();

                    Menu updatedMenu = new Menu(updateMenuId, 0, newItemName, newDescription, newPrice, true, 0.0, "");
                    menuDAO.updateMenuItem(updatedMenu);
                    System.out.println("Menu item updated successfully!");
                    break;
                case 4:
                    System.out.print("Enter Menu ID to delete: ");
                    int deleteMenuId = scanner.nextInt();
                    menuDAO.deleteMenuItem(deleteMenuId);
                    System.out.println("Menu item deleted successfully!");
                    break;
                case 5:
                    System.out.print("Enter Restaurant ID: ");
                    int restaurantIdToList = scanner.nextInt();
                    List<Menu> menuList = menuDAO.getMenuByRestaurant(restaurantIdToList);
                    for (Menu m : menuList) {
                        System.out.println(m);
                    }
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice! Returning to menu.");
            }
        }
    }

    private static void manageOrders(Scanner scanner, OrderDAOImpl orderDAO) {
        while (true) {
            System.out.println("\n=== Order Management ===");
            System.out.println("1. Place Order");
            System.out.println("2. View Order");
            System.out.println("3. Update Order Status");
            System.out.println("4. Delete Order");
            System.out.println("5. List Orders by User");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Restaurant ID: ");
                    int restaurantId = scanner.nextInt();
                    System.out.print("Enter User ID: ");
                    int userId = scanner.nextInt();
                    System.out.print("Enter Total Amount: ");
                    double totalAmount = scanner.nextDouble();
                    System.out.print("Enter Payment Mode: ");
                    String paymentMode = scanner.next();

                    Date orderDate = new Date(System.currentTimeMillis());
                    Order order = new Order(0, restaurantId, userId, orderDate, totalAmount, "Placed", paymentMode);
                    orderDAO.placeOrder(order);
                    System.out.println("Order placed successfully!");
                    break;
                case 2:
                    System.out.print("Enter Order ID: ");
                    int orderId = scanner.nextInt();
                    Order retrievedOrder = orderDAO.getOrder(orderId);
                    System.out.println(retrievedOrder != null ? retrievedOrder : "Order not found.");
                    break;
                case 3:
                    System.out.print("Enter Order ID to update: ");
                    int updateOrderId = scanner.nextInt();
                    System.out.print("Enter New Status (Placed/Delivered/Cancelled): ");
                    String newStatus = scanner.next();

                    Order updatedOrder = new Order(updateOrderId, 0, 0, null, 0.0, newStatus, "");
                    orderDAO.updateOrderStatus(updateOrderId,newStatus) ;
                    System.out.println("Order status updated successfully!");
                    break;
                case 4:
                    System.out.print("Enter Order ID to delete: ");
                    int deleteOrderId = scanner.nextInt();
                    orderDAO.deleteOrder(deleteOrderId);
                    System.out.println("Order deleted successfully!");
                    break;
                case 5:
                    System.out.print("Enter User ID to list orders: ");
                    int userIdToList = scanner.nextInt();
                    List<Order> orderList = orderDAO.getAllOrdersByUser(userIdToList);
                    for (Order o : orderList) {
                        System.out.println(o);
                    }
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice! Returning to menu.");
            }
        }
    }

    private static void manageOrderItems(Scanner scanner, OrderItemDAOImpl orderItemDAO) {
        while (true) {
            System.out.println("\n=== Order Item Management ===");
            System.out.println("1. Add Order Item");
            System.out.println("2. View Order Item");
            System.out.println("3. Update Order Item");
            System.out.println("4. Delete Order Item");
            System.out.println("5. List Order Items by Order");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Order ID: ");
                    int orderId = scanner.nextInt();
                    System.out.print("Enter Menu Item ID: ");
                    int menuItemId = scanner.nextInt();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();

                    OrderItem orderItem = new OrderItem(0, orderId, menuItemId, quantity, orderId);
                    orderItemDAO.addOrderItem(orderItem);
                    System.out.println("Order item added successfully!");
                    break;
                case 2:
                    System.out.print("Enter Order Item ID: ");
                    int orderItemId = scanner.nextInt();
                    OrderItem retrievedOrderItem = orderItemDAO.getOrderItem(orderItemId);
                    System.out.println(retrievedOrderItem != null ? retrievedOrderItem : "Order item not found.");
                    break;
                case 3:
                    System.out.print("Enter Order Item ID to update: ");
                    int updateOrderItemId = scanner.nextInt();
                    System.out.print("Enter New Quantity: ");
                    int newQuantity = scanner.nextInt();

                    OrderItem updatedOrderItem = new OrderItem();
                    orderItemDAO.updateOrderItem(updatedOrderItem);
                    System.out.println("Order item updated successfully!");
                    break;
                case 4:
                    System.out.print("Enter Order Item ID to delete: ");
                    int deleteOrderItemId = scanner.nextInt();
                    orderItemDAO.deleteOrderItem(deleteOrderItemId);
                    System.out.println("Order item deleted successfully!");
                    break;
                case 5:
                    System.out.print("Enter Order ID to list order items: ");
                    int orderIdToList = scanner.nextInt();
                    List<OrderItem> orderItemList = orderItemDAO.getOrderItemsByOrder(orderIdToList);
                    for (OrderItem oi : orderItemList) {
                        System.out.println(oi);
                    }
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice! Returning to menu.");
            }
        }
    }
}
