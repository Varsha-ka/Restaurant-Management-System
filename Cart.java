package com.Tap.Model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Integer, CartItem> items;

    public Cart() {
        items = new HashMap<>();
    }

    // Method to retrieve cart items
    public Map<Integer, CartItem> getItems() {
        return items;
    }

    // Add item to the cart, or update the quantity if it already exists
    public void addItem(CartItem item) {
        int itemId = item.getItemId();

        if (items.containsKey(itemId)) {
            CartItem existingCartItem = items.get(itemId);
            existingCartItem.setQuantity(existingCartItem.getQuantity() + 1);
        } else {
            items.put(itemId, item);
        }
    }

    // Update item quantity in the cart
    public void updateItem(int itemId, int quantity) {
        if (items.containsKey(itemId)) {
            if (quantity <= 0) {
                items.remove(itemId);
            } else {
                CartItem exCartItem = items.get(itemId);
                exCartItem.setQuantity(quantity);
            }
        }
    }

    // Remove an item from the cart
    public void removeItem(int itemId) {
        items.remove(itemId);
    }

    // Calculate the total price of all items in the cart
    public double getTotalPrice() {
        double total = 0.0;
        for (CartItem item : items.values()) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
}
