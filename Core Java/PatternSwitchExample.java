import java.util.Scanner;

public class PatternSwitchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Pattern Matching Switch Example");
        System.out.println("=============================");
        
        while (true) {
            System.out.print("\nEnter a value (or type 'exit' to quit): ");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            
            // Try to parse different types
            Object value = parseValue(input);
            
            // Use pattern matching switch expression
            String result = switch (value) {
                case Integer i -> "You entered an Integer: " + i;
                case Double d -> "You entered a Double: " + d;
                case String s -> "You entered a String: '" + s + "'";
                case null -> "You entered an empty value";
                default -> "You entered something else: " + value;
            };
            
            System.out.println(result);
        }
        
        scanner.close();
    }
    
    private static Object parseValue(String input) {
        try {
            // Try to parse as Integer first
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            try {
                // Try to parse as Double
                return Double.parseDouble(input);
            } catch (NumberFormatException ex) {
                // Return as String if neither Integer nor Double
                return input.trim();
            }
        }
    }
}
