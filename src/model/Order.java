package model;
import java.util.Map;

public class Order {
    private String customer;
    private Map<Fruit, Integer> order;
    
    public Order() {}

    public Order(String customer, Map<Fruit, Integer> order) {
        this.customer = customer;
        this.order = order;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Map<Fruit, Integer> getOrder() {
        return order;
    }

    public void setOrder(Map<Fruit, Integer> order) {
        this.order = order;
    }

    public void displayOrder() {
        System.out.println("Customer: " + customer);
        System.out.println("Product | Quantity | Price | Amount");
        int totalAmount = 0;
        int index = 1;
        for (Map.Entry<Fruit, Integer> entry : order.entrySet()) {
            Fruit fruit = entry.getKey();
            int quantity = entry.getValue();
            double price = fruit.getPrice();
            double amount = quantity * price;
            totalAmount += amount;
            System.out.printf("%d. %s       %d           %d$ %d$\n", index++, fruit.getFruitName(), quantity, price, amount);
        }
        System.out.println("Total: " + totalAmount + "$");
    }
}
