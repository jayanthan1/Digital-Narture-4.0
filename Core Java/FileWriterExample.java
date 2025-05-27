import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "output.txt";
        
        try {
            // Prompt user for input
            System.out.print("Enter a string to write to file: ");
            String userInput = scanner.nextLine();
            
            // Create BufferedWriter with FileWriter
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                // Write the user input to file
                writer.write(userInput);
                writer.newLine(); // Add a new line for better readability
                
                // Confirm the write operation
                System.out.println("Data has been successfully written to " + fileName);
            }
            
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
