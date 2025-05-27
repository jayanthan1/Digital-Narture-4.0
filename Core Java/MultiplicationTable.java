import java.util.Scanner;

/**
 * A program that prints the multiplication table for a given number up to 10.
 */
public class MultiplicationTable {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter a number
        System.out.print("Enter a number to display its multiplication table: ");
        int number = scanner.nextInt();
        
        // Display header
        System.out.println("\nMultiplication Table for " + number + ":");
        System.out.println("-------------------------");
        
        // Use a for loop to iterate from 1 to 10
        for (int i = 1; i <= 10; i++) {
            // Calculate the product
            int result = number * i;
            
            // Display the multiplication expression and result
            System.out.println(number + " × " + i + " = " + result);
        }
        
        // Close the scanner to prevent resource leak
        scanner.close();
    }
}
