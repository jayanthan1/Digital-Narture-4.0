import java.util.Scanner;

/**
 * A program that calculates the sum and average of elements in an array.
 */
public class ArraySumAverage {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter the number of elements
        System.out.println("Array Sum and Average Calculator");
        System.out.println("-------------------------------");
        System.out.print("Enter the number of elements: ");
        
        // Input validation for number of elements
        if (!scanner.hasNextInt()) {
            System.out.println("Error: Please enter a valid integer.");
            scanner.close();
            return;
        }
        
        int size = scanner.nextInt();
        
        // Check if the size is positive
        if (size <= 0) {
            System.out.println("Error: Number of elements must be positive.");
            scanner.close();
            return;
        }
        
        // Create an array of the specified size
        double[] numbers = new double[size];
        
        // Read the elements into the array
        System.out.println("\nEnter " + size + " numbers:");
        
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            
            // Input validation for each element
            if (scanner.hasNextDouble()) {
                numbers[i] = scanner.nextDouble();
            } else {
                System.out.println("Error: Please enter a valid number.");
                scanner.next(); // Clear invalid input
                i--; // Retry the current index
            }
        }
        
        // Calculate the sum of the elements
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += numbers[i];
        }
        
        // Calculate the average
        double average = sum / size;
        
        // Display the results
        System.out.println("\nResults:");
        System.out.println("Sum of elements: " + sum);
        System.out.println("Average of elements: " + average);
        
        // Display the array elements for reference
        System.out.println("\nArray elements:");
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(numbers[i]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        
        // Close the scanner to prevent resource leak
        scanner.close();
    }
}
