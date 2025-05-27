import java.util.HashMap;
import java.util.Scanner;

public class StudentMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> studentMap = new HashMap<>();
        boolean continueProgram = true;
        
        System.out.println("Student ID Management System");
        System.out.println("===========================");
        
        while (continueProgram) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Find Student");
            System.out.println("3. Exit");
            System.out.print("\nEnter your choice (1-3): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    addStudent(scanner, studentMap);
                    break;
                case 2:
                    findStudent(scanner, studentMap);
                    break;
                case 3:
                    continueProgram = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
    }
    
    private static void addStudent(Scanner scanner, HashMap<Integer, String> studentMap) {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        
        studentMap.put(id, name);
        System.out.println("Student added successfully!");
    }
    
    private static void findStudent(Scanner scanner, HashMap<Integer, String> studentMap) {
        System.out.print("Enter student ID to find: ");
        int id = scanner.nextInt();
        
        String name = studentMap.get(id);
        if (name != null) {
            System.out.println("Student found! Name: " + name);
        } else {
            System.out.println("No student found with ID: " + id);
        }
    }
}
