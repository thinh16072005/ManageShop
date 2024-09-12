package model;
import java.util.ArrayList;

public class OrderManager {
    private ArrayList<Order> listOrder = new ArrayList<>();

    FruitManager product;
    
    public OrderManager() {}

    public OrderManager(FruitManager product) {
        this.product = product;
    }
    
    public ArrayList<Order> getOrderList() {
        return listOrder;
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

    public void updateQuantity() {
        // Update the quantity of the product when the customer buys:
        for (Order order : listOrder) {
            for (Fruit fruit : order.getOrder().keySet()) {
                int quantity = order.getOrder().get(fruit);
                fruit.setQuantity(fruit.getQuantity() - quantity);
            }
        }
    }
}