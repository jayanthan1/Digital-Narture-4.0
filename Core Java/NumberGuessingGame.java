import java.util.Scanner;
import java.util.Random;

/**
 * A number guessing game where the user tries to guess a randomly generated number.
 */
public class NumberGuessingGame {
    public static void main(String[] args) {
        // Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        // Create Random object to generate random numbers
        Random random = new Random();
        
        // Generate a random number between 1 and 100
        int randomNumber = random.nextInt(100) + 1;
        
        // Variables to track game progress
        int userGuess = 0;
        int attempts = 0;
        boolean hasGuessedCorrectly = false;
        
        // Welcome message
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("Try to guess it!");
        
        // Game loop - continues until the user guesses correctly
        while (!hasGuessedCorrectly) {
            System.out.print("\nEnter your guess: ");
            
            // Input validation
            if (scanner.hasNextInt()) {
                userGuess = scanner.nextInt();
                attempts++;
                
                // Check if the guess is correct, too high, or too low
                if (userGuess == randomNumber) {
                    hasGuessedCorrectly = true;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try a higher number.");
                } else {
                    System.out.println("Too high! Try a lower number.");
                }
            } else {
                // Handle invalid input
                System.out.println("Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }
        
        // Game over - display results
        System.out.println("\nCongratulations! You've guessed the number correctly!");
        System.out.println("The number was: " + randomNumber);
        System.out.println("It took you " + attempts + " attempts to guess correctly.");
        
        // Rate the performance based on number of attempts
        if (attempts <= 3) {
            System.out.println("Amazing! You're a mind reader!");
        } else if (attempts <= 7) {
            System.out.println("Good job! You're a skilled guesser.");
        } else if (attempts <= 10) {
            System.out.println("Not bad! You've got some guessing skills.");
        } else {
            System.out.println("Keep practicing to improve your guessing strategy!");
        }
        
        // Close the scanner to prevent resource leak
        scanner.close();
    }
}
