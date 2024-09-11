package controller;

import java.util.Map;

import model.Fruit;
import model.FruitManager;
import model.Order;
import model.OrderManager;
import view.Menu;
import view.Validation;

public class ShopManager extends Menu {
    // Create objects from FruitManager and OrderManager class:
    private final FruitManager fruitManager = new FruitManager();
    private final OrderManager orderManager = new OrderManager();

    static String[] menuOptions = {
        "Create Fruit",
        "View Orders",
        "Shopping (for buyers)",
        "Exit"
    };

    public ShopManager(String title, String[] mchon) {
        super(title, mchon);
    }
    
    
    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1 -> createFruit();
            case 2 -> displayListOrder();
            case 3 -> shopping();
            case 4 -> System.exit(0);
            default -> {
            }
        }
    }

    private void createFruit() {
        // Enter fruit ID
        System.out.println("Enter fruit ID");
        int fruitId = Integer.parseInt(Validation.getAndValidInt());
        if (fruitId <= 0) System.err.println("fruitID must be larger than zero!");
        
        // Enter fruit name:
        System.out.println("Enter fruit name: ");
        String fruitName = Validation.getAndValidValue();
        
        // Enter fruit price:
        System.out.println("Enter price: ");
        double price = Double.parseDouble(Validation.getAndValidMoney());
        if (price <= 0) System.err.println("Price must be larger than zero!");
        
        // Enter quantity:
        System.out.println("Enter quantity: ");
        int quantity = Integer.parseInt(Validation.getAndValidInt());
        if (quantity <= 0) System.err.println("Price must be larger than zero!");
        
        // Enter the origin:
        System.out.println("Enter the origin: ");
        String origin = Validation.getAndValidValue();

        
        // Confirming creation:
        System.out.println("Do you want to create the fruit? (Y/N): ");
        String confirm = Validation.getAndValidValue();

        if (Validation.continueConfirm(confirm)) {
            fruitManager.addFruit(new Fruit(fruitId, fruitName, price, quantity, origin));
        }

        else return;

        System.out.println("Fruit created successfully!");
    }


    private void displayListOrder() {
        orderManager.showAllOrder();
    }

    private void shopping() {
        if (fruitManager.getFruitList() == null) {
            System.out.println("Fruit list is empty!");
        }
        else {
            fruitManager.showFruit();

            System.out.println("Enter the fruit ID you want to buy: ");
            String fruitId = Validation.getAndValidValue();

//            System.out.println("You chose: " + fruitManager.search(fruit -> fruit.getFruitId().equals(fruitId)).get(0));
            System.out.println("Enter the quantity you want to buy: ");
            int quantity = Integer.parseInt(Validation.getAndValidMoney());

            // Confirming order:
            System.out.println("Do you want to order now? (Y/N): ");
            String confirm = Validation.getAndValidValue();

            if (Validation.continueConfirm(confirm)) {
                System.out.println("Enter your name: ");
                String customer = Validation.getAndValidValue();
//                orderManager.addOrder(new Order(customer, Map.of(fruitManager.search(fruit -> fruit.getFruitId().equals(fruitId)).get(0), quantity)));
                System.out.println("Ordered successfully!");
            }
            else { shopping(); }
        }
    }
    
    public static void main(String[] args) {
        ShopManager sm = new ShopManager("FRUIT SHOP SYSTEM", menuOptions);
        sm.run();
    }
}
