import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) {
        String fileName = "output.txt";
        
        try {
            // Create BufferedReader with FileReader
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                
                // Read and display each line
                String line;
                int lineNumber = 1;
                
                while ((line = reader.readLine()) != null) {
                    System.out.println("Line " + lineNumber + ": " + line);
                    lineNumber++;
                }
                
                if (lineNumber == 1) {
                    System.out.println("The file is empty.");
                } else {
                    System.out.println("\nFile reading completed successfully!");
                }
            }
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
