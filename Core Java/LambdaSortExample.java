import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LambdaSortExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words = new ArrayList<>();
        
        System.out.println("Enter words (type 'done' to finish): ");
        
        // Get words from user
        while (true) {
            System.out.print("Enter a word: ");
            String word = scanner.nextLine();
            
            if (word.equalsIgnoreCase("done")) {
                break;
            }
            
            words.add(word);
        }
        
        System.out.println("\nOriginal List:");
        displayList(words);
        
        // Sort using lambda expression
        Collections.sort(words, (s1, s2) -> s1.compareTo(s2));
        
        System.out.println("\nAlphabetically Sorted List:");
        displayList(words);
        
        // Sort by length using lambda
        Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        
        System.out.println("\nSorted by Length (Shortest to Longest):");
        displayList(words);
        
        scanner.close();
    }
    
    private static void displayList(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }
}
