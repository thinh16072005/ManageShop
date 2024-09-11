package view;

import java.util.Scanner;

public class Validation {

    private static final Scanner sc = new Scanner(System.in);

    // Enter value method:
    public static String getAndValidName() {
        while (true) {
            String msg = sc.nextLine().trim();
            if (msg.isEmpty()) {
                System.err.println("Input must not be empty!");
            } else {
                if (msg.matches("[a-zA-Z ]+")) {
                    return msg;
                } else {
                    System.err.println("Input must be a string. Please input again!");
                }
            }
        }
    }

    public static String getAndValidMoney() {
        // loop until user input correct
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine().trim());
                if (result <= 0) {
                    System.err.println("Number must be larger than zero!");
                } else {
                    return String.valueOf(result);
                }
            } catch (NumberFormatException e) {
                System.err.println("Must be input double.");
                System.out.print("Enter again: ");
            }
        }
    }

    public static int getAndValidQuantityFruitId() {
        // loop until user input correct
        while (true) {
            while (true) {
                try {
                    int result = Integer.parseInt(sc.nextLine().trim());
                    if (result <= 0) {
                        System.err.println("Number must be larger than zero!");
                    } else {
                        return result;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Must be input integer.");
                    System.out.print("Enter again: ");
                }
            }
        }
    }

    public static String getAndValidateOrigin() {
        while (true) {
            try {
                String result = sc.nextLine().trim();
                if (result.isEmpty()) {
                    System.err.println("Input must not be empty!");
                }
            } catch (Exception e) {
                System.err.println("Input must be String. Please input again!");
            }
        }
    }

    // public static boolean checkID(ArrayList<Fruit> fr, String id) {
    // for (Fruit fruit : fr) {
    // if (id.equalsIgnoreCase(fruit.getFruitId())) {
    // return false;
    // }
    // }
    // return true;
    // }

   

    public static boolean continueConfirm(String msg) {
        while (true) {
            //return true if user input y/Y
            if (msg.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (msg.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }
}