import java.util.Scanner;

/**
 * A program that calculates the factorial of a number entered by the user.
 * Factorial of n (n!) is the product of all positive integers less than or equal to n.
 * For example: 5! = 5 × 4 × 3 × 2 × 1 = 120
 */
public class FactorialCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for a non-negative integer
        System.out.println("Factorial Calculator");
        System.out.println("-------------------");
        System.out.print("Enter a non-negative integer: ");
        
        // Input validation
        if (!scanner.hasNextInt()) {
            System.out.println("Error: Please enter a valid integer.");
            scanner.close();
            return;
        }
        
        int number = scanner.nextInt();
        
        // Check if the number is negative
        if (number < 0) {
            System.out.println("Error: Factorial is not defined for negative numbers.");
            scanner.close();
            return;
        }
        
        // Special case for 0
        if (number == 0) {
            System.out.println("The factorial of 0 is: 1");
            scanner.close();
            return;
        }
        
        // Calculate factorial using a for loop
        long factorial = 1; // Use long to handle larger factorials
        
        for (int i = 1; i <= number; i++) {
            factorial *= i; // Multiply factorial by i
        }
        
        // Display the result
        System.out.println("The factorial of " + number + " is: " + factorial);
        
        // Note about limitations
        if (number > 20) {
            System.out.println("\nNote: Java's long data type can accurately represent factorials only up to 20!");
            System.out.println("For larger factorials, consider using BigInteger class.");
        }
        
        // Close the scanner to prevent resource leak
        scanner.close();
    }
}
