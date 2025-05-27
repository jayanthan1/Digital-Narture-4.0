/**
 * A program that demonstrates Java's primitive data types.
 */
public class DataTypeDemo {
    public static void main(String[] args) {
        // Declare and initialize variables of different primitive types
        
        // Integer type - stores whole numbers without decimals
        int integerValue = 42;
        
        // Float type - stores floating point numbers (requires 'f' suffix)
        float floatValue = 3.14159f;
        
        // Double type - stores floating point numbers with higher precision
        double doubleValue = 2.71828182845904;
        
        // Character type - stores a single character (enclosed in single quotes)
        char charValue = 'A';
        
        // Boolean type - stores true or false values
        boolean booleanValue = true;
        
        // Display each variable with an appropriate description
        System.out.println("Java Primitive Data Types Demonstration:");
        System.out.println("--------------------------------------");
        System.out.println("int value: " + integerValue);
        System.out.println("float value: " + floatValue);
        System.out.println("double value: " + doubleValue);
        System.out.println("char value: " + charValue);
        System.out.println("boolean value: " + booleanValue);
        
        // Display additional information about each data type
        System.out.println("\nAdditional Information:");
        System.out.println("int range: -2,147,483,648 to 2,147,483,647 (4 bytes)");
        System.out.println("float precision: ~7 decimal digits (4 bytes)");
        System.out.println("double precision: ~15 decimal digits (8 bytes)");
        System.out.println("char range: Unicode characters (2 bytes)");
        System.out.println("boolean values: true or false (1 bit of information)");
    }
}
