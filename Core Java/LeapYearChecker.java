import java.util.Scanner;

/**
 * A program that checks if a given year is a leap year.
 */
public class LeapYearChecker {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter a year
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();
        
        // Apply leap year logic:
        // A year is a leap year if it's divisible by 4 but not by 100, unless it's also divisible by 400
        boolean isLeapYear = false;
        
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                // Divisible by 100, check if it's divisible by 400
                if (year % 400 == 0) {
                    isLeapYear = true; // Divisible by 400 is a leap year
                }
            } else {
                isLeapYear = true; // Divisible by 4 but not by 100 is a leap year
            }
        }
        
        // Display the result
        if (isLeapYear) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }
        
        // Close the scanner to prevent resource leak
        scanner.close();
    }
}
