package controller;

import model.Fruit;
import model.FruitManager;
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
            case 2 -> viewOrders();
            case 3 -> shopping();
            case 4 -> System.exit(0);
            default -> {
            }
        }
    }

    private void createFruit() {
        // Enter fruit ID
        System.out.println("Enter fruit ID");
        String fruitId = Validation.getAndValidValue();
        
        // Enter fruit name:
        System.out.println("Enter fruit name: ");
        String fruitName = Validation.getAndValidValue();
        
        // Enter fruit price:
        System.out.println("Enter price: ");
        double price = Double.parseDouble(Validation.getAndValidMoney());
        
        // Enter quantity:
        System.out.println("Enter quantity: ");
        int quantity = Integer.parseInt(Validation.getAndValidInt());
        
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

    private void viewOrders() {
        
    }

    private void shopping() {
        if (fruitManager.getFruitList() == null) {
            System.out.println("Fruit list is empty!");
        }
        else {
            fruitManager.showFruit();
            int fruitId = Integer.parseInt(Validation.getAndValidInt());
            System.out.println("You chose: ");
            int quantity = Integer.parseInt(Validation.getAndValidMoney());

            // Confirming order:
            System.out.println("Do you want to order now? (Y/N): ");
            String confirm = Validation.getAndValidValue();
            if (Validation.continueConfirm(confirm)) {
                orderManager.addOrder();
            }
            else { shopping(); }
        }
    }
    
    public static void main(String[] args) {
        ShopManager sm = new ShopManager("FRUIT SHOP SYSTEM", menuOptions);
        sm.run();
    }
}
