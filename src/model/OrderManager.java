package model;
import java.util.Hashtable;

import view.Validation;

public class OrderManager {
    private Hashtable<Integer, Order> listOrder;

    FruitManager product;
    Validation val;
    
    public OrderManager() {}

    public OrderManager(FruitManager product) {
        this.product = product;
    }
    
    // Add orders:
    public void addOrder() {
        
    }
    
    //Show all orders:
    public void showAllOrder() {
        
    }

    // Check if the product is available:
    public boolean isEnoughQuantity(FruitManager product, int id, int quantity) {
        return true;
    }
}
