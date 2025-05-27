import java.util.Scanner;

/**
 * A program that checks if a number is even or odd.
 */
public class EvenOddChecker {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter an integer
        System.out.print("Enter an integer: ");
        
        // Read the integer input from the user
        int number = scanner.nextInt();
        
        // Check if the number is even or odd using the modulus operator
        // If number % 2 equals 0, then the number is even, otherwise it's odd
        if (number % 2 == 0) {
            System.out.println(number + " is an even number.");
        } else {
            System.out.println(number + " is an odd number.");
        }
        
        // Close the scanner to prevent resource leak
        scanner.close();
    }
}
