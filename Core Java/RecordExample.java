import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// Define a record for Person
record Person(String name, int age) {
    // Record automatically generates:
    // - Constructor
    // - Getters (name(), age())
    // - toString()
    // - equals()
    // - hashCode()
    // - All fields are final
}

public class RecordExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        
        System.out.println("Enter people information (type 'done' to finish): ");
        
        while (true) {
            System.out.print("\nEnter name (or 'done' to finish): ");
            String name = scanner.nextLine();
            
            if (name.equalsIgnoreCase("done")) {
                break;
            }
            
            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            // Create a Person record
            Person person = new Person(name, age);
            people.add(person);
            
            System.out.println("Person added: " + person);
        }
        
        System.out.println("\nAll People:");
        displayPeople(people);
        
        // Filter people using Stream API
        System.out.print("\nEnter minimum age to filter: ");
        int minAge = scanner.nextInt();
        
        List<Person> filteredPeople = people.stream()
            .filter(p -> p.age() >= minAge)
            .sorted((p1, p2) -> p1.age() - p2.age())
            .collect(Collectors.toList());
        
        System.out.println("\nPeople older than " + minAge + ":");
        displayPeople(filteredPeople);
        
        scanner.close();
    }
    
    private static void displayPeople(List<Person> people) {
        if (people.isEmpty()) {
            System.out.println("(No people found)");
            return;
        }
        
        System.out.println("[" + people.size() + " people]");
        for (int i = 0; i < people.size(); i++) {
            Person person = people.get(i);
            System.out.println((i + 1) + ". " + person);
        }
    }
}
