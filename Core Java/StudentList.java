import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> studentNames = new ArrayList<>();
        
        System.out.println("Student Name Management System");
        System.out.println("=============================");
        
        while (true) {
            System.out.print("\nEnter a student name (or type 'done' to finish): ");
            String name = scanner.nextLine();
            
            if (name.equalsIgnoreCase("done")) {
                break;
            }
            
            studentNames.add(name);
            System.out.println("Student added successfully!");
        }
        
        // Display all names
        System.out.println("\nList of Students:");
        System.out.println("=================");
        
        if (studentNames.isEmpty()) {
            System.out.println("No students were added.");
        } else {
            for (int i = 0; i < studentNames.size(); i++) {
                System.out.println((i + 1) + ". " + studentNames.get(i));
            }
        }
        
        scanner.close();
    }
}
