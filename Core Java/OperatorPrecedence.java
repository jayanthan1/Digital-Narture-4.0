/**
 * A program that demonstrates operator precedence in Java.
 */
public class OperatorPrecedence {
    public static void main(String[] args) {
        System.out.println("Operator Precedence in Java");
        System.out.println("---------------------------");
        
        // Example 1: Arithmetic operators
        int result1 = 10 + 5 * 2;
        System.out.println("Example 1: 10 + 5 * 2 = " + result1);
        System.out.println("Explanation: Multiplication (*) has higher precedence than addition (+)");
        System.out.println("            So the expression is evaluated as: 10 + (5 * 2) = 10 + 10 = 20");
        
        // Example 2: Parentheses override default precedence
        int result2 = (10 + 5) * 2;
        System.out.println("\nExample 2: (10 + 5) * 2 = " + result2);
        System.out.println("Explanation: Parentheses have the highest precedence");
        System.out.println("            So the expression is evaluated as: (15) * 2 = 30");
        
        // Example 3: Multiple arithmetic operators
        int result3 = 20 / 4 * 2 + 3;
        System.out.println("\nExample 3: 20 / 4 * 2 + 3 = " + result3);
        System.out.println("Explanation: Division (/) and multiplication (*) have equal precedence");
        System.out.println("            They are evaluated from left to right: (20 / 4) * 2 + 3 = 5 * 2 + 3 = 10 + 3 = 13");
        
        // Example 4: Assignment and arithmetic
        int x = 5;
        int result4 = x += 3 * 2;
        System.out.println("\nExample 4: x = 5; x += 3 * 2 (which means x = x + (3 * 2))");
        System.out.println("Result: x = " + x + ", result4 = " + result4);
        System.out.println("Explanation: The multiplication is performed before the addition assignment");
        
        // Example 5: Logical operators
        boolean result5 = true || false && false;
        System.out.println("\nExample 5: true || false && false = " + result5);
        System.out.println("Explanation: Logical AND (&&) has higher precedence than logical OR (||)");
        System.out.println("            So the expression is evaluated as: true || (false && false) = true || false = true");
        
        // Example 6: Complex expression
        int result6 = 4 + 6 % 3 * 2 - 1;
        System.out.println("\nExample 6: 4 + 6 % 3 * 2 - 1 = " + result6);
        System.out.println("Explanation: Evaluation order based on precedence:");
        System.out.println("            1. Modulus: 6 % 3 = 0");
        System.out.println("            2. Multiplication: 0 * 2 = 0");
        System.out.println("            3. Addition and subtraction (left to right): 4 + 0 - 1 = 3");
        
        // Summary of operator precedence
        System.out.println("\nOperator Precedence Summary (from highest to lowest):");
        System.out.println("1. Parentheses: ()");
        System.out.println("2. Unary operators: ++, --, !, ~");
        System.out.println("3. Multiplication, Division, Modulus: *, /, %");
        System.out.println("4. Addition, Subtraction: +, -");
        System.out.println("5. Shift operators: <<, >>, >>>");
        System.out.println("6. Relational operators: <, >, <=, >=, instanceof");
        System.out.println("7. Equality operators: ==, !=");
        System.out.println("8. Bitwise AND: &");
        System.out.println("9. Bitwise XOR: ^");
        System.out.println("10. Bitwise OR: |");
        System.out.println("11. Logical AND: &&");
        System.out.println("12. Logical OR: ||");
        System.out.println("13. Conditional (ternary): ? :");
        System.out.println("14. Assignment operators: =, +=, -=, etc.");
    }
}
