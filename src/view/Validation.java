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

    public static boolean continueConfirm(String msg) {
        while (true) {
            if (msg.equalsIgnoreCase("Y")) {
                return true;
            } else if (msg.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.err.println("Please input Y/y or N/n.");
                System.out.print("Enter again: ");
                msg = sc.nextLine().trim();
            }
        }
    }
    
}