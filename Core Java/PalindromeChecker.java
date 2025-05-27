import java.util.Scanner;

/**
 * A program that checks if a string is a palindrome.
 * A palindrome is a word, phrase, number, or other sequence of characters
 * that reads the same forward and backward (ignoring spaces, case, and punctuation).
 * Examples: "racecar", "A man, a plan, a canal, Panama!", "12321"
 */
public class PalindromeChecker {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for a string
        System.out.println("Palindrome Checker");
        System.out.println("-----------------");
        System.out.println("A palindrome reads the same forwards and backwards.");
        System.out.println("Examples: \"racecar\", \"A man, a plan, a canal, Panama!\", \"12321\"");
        System.out.print("\nEnter a string to check: ");
        
        // Read the input string
        String input = scanner.nextLine();
        
        // Process the string: remove non-alphanumeric characters and convert to lowercase
        String processed = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        // Check if the processed string is empty
        if (processed.isEmpty()) {
            System.out.println("\nThe string contains no alphanumeric characters to check.");
            scanner.close();
            return;
        }
        
        // Check if the string is a palindrome
        boolean isPalindrome = checkPalindrome(processed);
        
        // Display the result
        System.out.println("\nOriginal string: \"" + input + "\"");
        System.out.println("Processed string: \"" + processed + "\"");
        
        if (isPalindrome) {
            System.out.println("\nResult: This IS a palindrome!");
        } else {
            System.out.println("\nResult: This is NOT a palindrome.");
        }
        
        // Display the reversed string for reference
        String reversed = new StringBuilder(processed).reverse().toString();
        System.out.println("\nForward: " + processed);
        System.out.println("Backward: " + reversed);
        
        // Close the scanner to prevent resource leak
        scanner.close();
    }
    
    /**
     * Checks if a string is a palindrome.
     * 
     * @param str The string to check (already processed)
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean checkPalindrome(String str) {
        // Method 1: Using StringBuilder to reverse and compare
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
        
        // Method 2: Compare characters from both ends (alternative approach)
        /*
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
        */
    }
}
