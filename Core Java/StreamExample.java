import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        
        System.out.println("Enter numbers (type 'done' to finish): ");
        
        // Get numbers from user
        while (true) {
            System.out.print("Enter a number: ");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            
            try {
                int number = Integer.parseInt(input);
                numbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        
        System.out.println("\nOriginal List:");
        displayNumbers(numbers);
        
        // Use Stream API to filter even numbers
        List<Integer> evenNumbers = numbers.stream()
            .filter(n -> n % 2 == 0)  // Filter even numbers
            .sorted()                 // Sort the numbers
            .collect(Collectors.toList()); // Collect results
        
        System.out.println("\nEven Numbers (Sorted): ");
        displayNumbers(evenNumbers);
        
        // Additional Stream operations demonstration
        System.out.println("\nAdditional Stream Operations:");
        System.out.println("Total even numbers: " + evenNumbers.size());
        System.out.println("Sum of even numbers: " + evenNumbers.stream().mapToInt(Integer::intValue).sum());
        System.out.println("Average of even numbers: " + evenNumbers.stream().mapToInt(Integer::intValue).average().orElse(0.0));
        
        scanner.close();
    }
    
    private static void displayNumbers(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            System.out.println("(No numbers)");
            return;
        }
        
        System.out.print("[");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            if (i < numbers.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
