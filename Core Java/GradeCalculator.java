import java.util.Scanner;

/**
 * A program that assigns grades based on marks entered by the user.
 */
public class GradeCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for marks
        System.out.println("Grade Calculator");
        System.out.println("---------------");
        System.out.print("Enter marks (out of 100): ");
        
        // Read the marks
        double marks = scanner.nextDouble();
        
        // Variable to store the grade
        String grade;
        
        // Input validation
        if (marks < 0 || marks > 100) {
            System.out.println("Error: Marks must be between 0 and 100.");
            scanner.close();
            return; // Exit the program
        }
        
        // Determine the grade using if-else statements
        if (marks >= 90 && marks <= 100) {
            grade = "A";
        } else if (marks >= 80 && marks < 90) {
            grade = "B";
        } else if (marks >= 70 && marks < 80) {
            grade = "C";
        } else if (marks >= 60 && marks < 70) {
            grade = "D";
        } else {
            grade = "F";
        }
        
        // Display the assigned grade
        System.out.println("Grade: " + grade);
        
        // Additional feedback based on the grade
        if (grade.equals("A")) {
            System.out.println("Excellent performance!");
        } else if (grade.equals("B")) {
            System.out.println("Good job!");
        } else if (grade.equals("C")) {
            System.out.println("Satisfactory performance.");
        } else if (grade.equals("D")) {
            System.out.println("You passed, but need improvement.");
        } else {
            System.out.println("Failed. Please study harder and try again.");
        }
        
        // Close the scanner to prevent resource leak
        scanner.close();
    }
}
