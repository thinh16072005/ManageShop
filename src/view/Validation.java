package view;
import java.util.ArrayList;
import java.util.Scanner;
import model.Fruit;

public class Validation {

    private static final Scanner sc = new Scanner(System.in);

    // Enter value method:
    public static String getAndValidValue() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Input must not be empty!");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
    
    public static String getAndValidMoney() {
        //loop until user input correct
        while (true) {
            try {
                String result = sc.nextLine().trim();
                if (result.isEmpty()) {
                    throw new Exception("Input must not be empty!");
                }
                if (!result.matches("\\d+")) {
                    throw new Exception("Please input a double number!");
                }
                return result;
            } catch (Exception e) {
                System.out.println("Input must be double. Please input again.");
            }
        }
    }

    public static String getAndValidInt() {
        //loop until user input correct
        while (true) {
            try {
                String result = sc.nextLine().trim();
                if (result.isEmpty()) {
                    throw new Exception("Input must not be empty!");
                }
                if (!result.matches("\\d+")) {
                    throw new Exception("Please input number!");
                }
                return result;
            } catch (Exception e) {
                System.out.println("Input must be integer. Please input again.");
            }
        }
    }
    
    public static boolean checkID(ArrayList<Fruit> fr, String id) {
        for (Fruit fruit : fr) {
            if (id.equalsIgnoreCase(fruit.getFruitId())) {
                return false;
            }
        }
        return true;
    }

    public static boolean continueConfirm(String msg) {
        while (true) {
            String result = getAndValidValue();
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }
}