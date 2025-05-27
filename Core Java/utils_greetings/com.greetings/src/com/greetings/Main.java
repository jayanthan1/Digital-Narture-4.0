package com.greetings;

import com.utils.StringUtils;

/**
 * Main class that demonstrates the use of the StringUtils class from com.utils module
 */
public class Main {
    
    public static void main(String[] args) {
        // Test the StringUtils.capitalize method
        String message = "hello from java modules";
        String capitalizedMessage = StringUtils.capitalize(message);
        
        System.out.println("Original message: " + message);
        System.out.println("Capitalized message: " + capitalizedMessage);
        
        // Test the StringUtils.reverse method
        String greeting = "Hello World";
        String reversedGreeting = StringUtils.reverse(greeting);
        
        System.out.println("\nOriginal greeting: " + greeting);
        System.out.println("Reversed greeting: " + reversedGreeting);
        
        // Display module information
        System.out.println("\n--- Module Information ---");
        System.out.println("Current module: " + Main.class.getModule().getName());
        System.out.println("StringUtils module: " + StringUtils.class.getModule().getName());
    }
}
