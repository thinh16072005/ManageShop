import java.util.ArrayList;
import java.util.Hashtable;
import model.Fruit;
import model.FruitManager;
import model.Order;
import model.OrderManager;
import view.Menu;
import view.Validation;

public class ShopManager extends Menu {
    private FruitManager fruitManager;
    private OrderManager orderManager;

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

    private Fruit createFruit() {
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
        
//        if (Validation.continueConfirm(confirm)) {
//            fruitManager.addFruit(new Fruit(fruitId, fruitName, price, quantity, origin));
//        }

        fruitManager.addFruit(new Fruit(fruitId, fruitName, price, quantity, origin));
        System.out.println("Fruit created successfully!");
        
        return fruitManager.getFruitList().getFirst();
    }

    private void viewOrders() {
        
    }

    private void shopping() {
        fruitManager.showFruit();
        int fruitId = Integer.parseInt(Validation.getAndValidInt());
        System.out.println("You chose: ");
        int quantity = Integer.parseInt(Validation.getAndValidMoney());
        
        // Confirming order:
        System.out.println("");
        String confirm = Validation.getAndValidValue();
        if (Validation.continueConfirm(confirm)) {
            orderManager.addOrder();
        }
        else { shopping(); }
    }
    
    public static void main(String[] args) {
        ShopManager sm = new ShopManager("FRUIT SHOP SYSTEM", menuOptions);
        sm.run();
    }
}
