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
        int fruitId = Validation.getAndValidQuantityFruitId();
        // Check if fruit ID exists:
        if (!fruitManager.search(fruit -> fruit.getFruitId() == fruitId).isEmpty()) {
            System.err.println("Fruit ID already exists!");
            return;
        }
        
        // Enter fruit name:
        System.out.println("Enter fruit name: ");
        String fruitName = Validation.getAndValidName();
        
        // Enter fruit price:
        System.out.println("Enter price: ");
        double price = Double.parseDouble(Validation.getAndValidMoney());
        
        // Enter quantity:
        System.out.println("Enter quantity: ");
        int quantity = Validation.getAndValidQuantityFruitId();
        
        // Enter the origin:
        System.out.println("Enter the origin: ");
        String origin = Validation.getAndValidName();

        
        // Confirming creation:
        System.out.println("Do you want to create the fruit? (Y/N): ");
        String confirm = Validation.getAndValidName();
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
            String fruitId = Validation.getAndValidName();

            // Check if fruit ID exists:
            if (fruitManager.search(fruit -> String.valueOf(fruit.getFruitId()).equals(fruitId)).isEmpty()) {
                System.err.println("Fruit ID not found!");
                return;
            } else {
                System.out.println(fruitManager.search(fruit -> String.valueOf(fruit.getFruitId()).equals(fruitId)).get(0));
            }
            
            System.out.println("Enter the quantity you want to buy: ");
            int quantity = Validation.getAndValidQuantityFruitId();

            // Confirming order:
            System.out.println("Do you want to order now? (Y/N): ");
            String confirm = Validation.getAndValidName();

            if (Validation.continueConfirm(confirm)) {
                System.out.println("Enter your name: ");
                String customer = Validation.getAndValidName();
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
