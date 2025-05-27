import java.util.Scanner;

/**
 * A simple calculator program that performs basic arithmetic operations.
 */
public class SimpleCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user to enter the first number
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        
        // Prompt user to enter the second number
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        
        // Prompt user to choose an operation
        System.out.println("Choose an operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.print("Enter your choice (1-4): ");
        
        int choice = scanner.nextInt();
        double result = 0;
        
        // Perform the selected operation
        switch (choice) {
            case 1:
                result = num1 + num2;
                System.out.println(num1 + " + " + num2 + " = " + result);
                break;
            case 2:
                result = num1 - num2;
                System.out.println(num1 + " - " + num2 + " = " + result);
                break;
            case 3:
                result = num1 * num2;
                System.out.println(num1 + " * " + num2 + " = " + result);
                break;
            case 4:
                // Check if division by zero
                if (num2 == 0) {
                    System.out.println("Error: Cannot divide by zero!");
                } else {
                    result = num1 / num2;
                    System.out.println(num1 + " / " + num2 + " = " + result);
                }
                break;
            default:
                System.out.println("Invalid choice! Please select a number between 1 and 4.");
        }
        
        // Close the scanner to prevent resource leak
        scanner.close();
    }
}
