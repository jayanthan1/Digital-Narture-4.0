import java.util.Scanner;

/**
 * A program that reverses a string entered by the user.
 * Demonstrates string manipulation in Java.
 */
public class StringReversal {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for a string
        System.out.println("String Reversal Program");
        System.out.println("----------------------");
        System.out.print("Enter a string to reverse: ");
        
        // Read the input string
        String input = scanner.nextLine();
        
        // Method 1: Using StringBuilder (most efficient way)
        StringBuilder sb = new StringBuilder(input);
        String reversed1 = sb.reverse().toString();
        
        // Method 2: Using a character array and loop
        char[] charArray = input.toCharArray();
        String reversed2 = "";
        for (int i = charArray.length - 1; i >= 0; i--) {
            reversed2 += charArray[i];
        }
        
        // Method 3: Using a for loop directly on the string
        String reversed3 = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed3 += input.charAt(i);
        }
        
        // Display the reversed string (using the StringBuilder method)
        System.out.println("\nReversed string: " + reversed1);
        
        // Display information about the different methods
        System.out.println("\nDifferent ways to reverse a string in Java:");
        System.out.println("1. Using StringBuilder (most efficient): " + reversed1);
        System.out.println("2. Using a character array and loop: " + reversed2);
        System.out.println("3. Using a for loop directly on the string: " + reversed3);
        
        // Note about efficiency
        System.out.println("\nNote: StringBuilder is more efficient for string manipulation");
        System.out.println("because it modifies a single string buffer rather than creating");
        System.out.println("new String objects for each concatenation operation.");
        
        // Close the scanner to prevent resource leak
        scanner.close();
    }
}
