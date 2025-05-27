/**
 * A program that demonstrates method overloading in Java.
 * Method overloading allows multiple methods to have the same name
 * but different parameters (different number or types of parameters).
 */
public class MethodOverloading {
    
    // Method that adds two integers
    public static int add(int a, int b) {
        System.out.println("Calling add(int, int)");
        return a + b;
    }
    
    // Method that adds two doubles
    public static double add(double a, double b) {
        System.out.println("Calling add(double, double)");
        return a + b;
    }
    
    // Method that adds three integers
    public static int add(int a, int b, int c) {
        System.out.println("Calling add(int, int, int)");
        return a + b + c;
    }
    
    public static void main(String[] args) {
        System.out.println("Method Overloading Demonstration");
        System.out.println("-------------------------------");
        
        // Call the method with two integers
        int sum1 = add(5, 10);
        System.out.println("Sum of 5 and 10: " + sum1);
        
        // Call the method with two doubles
        double sum2 = add(3.5, 7.2);
        System.out.println("Sum of 3.5 and 7.2: " + sum2);
        
        // Call the method with three integers
        int sum3 = add(2, 4, 6);
        System.out.println("Sum of 2, 4, and 6: " + sum3);
        
        // Demonstrate how Java determines which method to call
        System.out.println("\nAdditional Examples:");
        
        // Java automatically converts int to double when necessary
        double sum4 = add(10, 20.5); // Calls add(double, double)
        System.out.println("Sum of 10 and 20.5: " + sum4);
        
        // Java chooses the most specific method that matches the arguments
        int sum5 = add(1, 2); // Calls add(int, int)
        System.out.println("Sum of 1 and 2: " + sum5);
        
        System.out.println("\nKey Points about Method Overloading:");
        System.out.println("1. Methods must have the same name");
        System.out.println("2. Methods must have different parameter lists");
        System.out.println("3. Return type alone is not sufficient for overloading");
        System.out.println("4. Java determines which method to call based on the arguments provided");
    }
}
