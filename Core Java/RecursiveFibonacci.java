import java.util.Scanner;

/**
 * A program that calculates the nth Fibonacci number using recursion.
 * The Fibonacci sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21, ...
 * Where each number is the sum of the two preceding ones, starting from 0 and 1.
 */
public class RecursiveFibonacci {
    
    /**
     * Recursive method to calculate the nth Fibonacci number.
     * 
     * @param n The position in the Fibonacci sequence (0-based index)
     * @return The nth Fibonacci number
     */
    public static int fibonacci(int n) {
        // Base cases
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        
        // Recursive case: F(n) = F(n-1) + F(n-2)
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for a positive integer
        System.out.println("Recursive Fibonacci Calculator");
        System.out.println("-----------------------------");
        System.out.print("Enter a positive integer n: ");
        
        // Input validation
        if (!scanner.hasNextInt()) {
            System.out.println("Error: Please enter a valid integer.");
            scanner.close();
            return;
        }
        
        int n = scanner.nextInt();
        
        // Check if the input is positive
        if (n < 0) {
            System.out.println("Error: Please enter a positive integer.");
            scanner.close();
            return;
        }
        
        // Calculate and display the nth Fibonacci number
        System.out.println("The " + n + "th Fibonacci number is: " + fibonacci(n));
        
        // Warning about performance for large values of n
        if (n > 40) {
            System.out.println("\nNote: Simple recursion is inefficient for large values of n.");
            System.out.println("For n > 40, consider using dynamic programming or memoization.");
        }
        
        // Display the first n+1 Fibonacci numbers for reference
        System.out.println("\nFirst " + (n + 1) + " Fibonacci numbers:");
        for (int i = 0; i <= n; i++) {
            System.out.print(fibonacci(i));
            if (i < n) {
                System.out.print(", ");
            }
        }
        System.out.println();
        
        // Close the scanner to prevent resource leak
        scanner.close();
    }
}
