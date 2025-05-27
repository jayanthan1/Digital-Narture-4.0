/**
 * A program that demonstrates type casting between different data types in Java.
 */
public class TypeCastingExample {
    public static void main(String[] args) {
        System.out.println("Type Casting Demonstration in Java");
        System.out.println("----------------------------------");
        
        // 1. Casting from double to int (Narrowing Conversion)
        // Declare a double variable with a decimal value
        double doubleValue = 9.99;
        System.out.println("Original double value: " + doubleValue);
        
        // Cast the double to an int (this will truncate the decimal part)
        int intFromDouble = (int) doubleValue;
        System.out.println("After casting to int: " + intFromDouble);
        System.out.println("Note: The decimal part is truncated, not rounded");
        
        // 2. Casting from int to double (Widening Conversion)
        // Declare an int variable
        int intValue = 42;
        System.out.println("\nOriginal int value: " + intValue);
        
        // Cast the int to a double
        double doubleFromInt = (double) intValue;
        System.out.println("After casting to double: " + doubleFromInt);
        
        // 3. Additional example showing precision loss
        double piValue = 3.14159265359;
        int truncatedPi = (int) piValue;
        System.out.println("\nAdditional Example - Precision Loss:");
        System.out.println("Original PI value (double): " + piValue);
        System.out.println("After casting to int: " + truncatedPi);
        
        // 4. Implicit casting (widening conversion happens automatically)
        int smallNumber = 10;
        double implicitDouble = smallNumber; // No explicit cast needed
        System.out.println("\nImplicit Casting Example:");
        System.out.println("Original int value: " + smallNumber);
        System.out.println("After implicit casting to double: " + implicitDouble);
    }
}
