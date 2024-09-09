package model;
import java.util.ArrayList;

import view.Validation;

public class OrderManager {
    private ArrayList<Order> listOrder = new ArrayList<>();

    FruitManager product;
    Validation val;
    
    public OrderManager() {}

    public OrderManager(FruitManager product) {
        this.product = product;
    }
    
    // Add orders:
    public void addOrder(Order order) {
        listOrder.add(order);
    }
    
    //Show all orders:
    public void showAllOrder() {
        for (Order order : listOrder) {
            order.displayOrder();
        }
    }

    // Check if the product is available:
    public boolean isEnoughQuantity(FruitManager product, int id, int quantity) {
        if (product.getFruitList().get(id).getQuantity() >= quantity) {
            return true;
        }
        return false;
    }
}