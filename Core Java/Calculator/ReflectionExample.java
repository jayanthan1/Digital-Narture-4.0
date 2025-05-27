import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class ReflectionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Load the Calculator class using reflection
            Class<?> calculatorClass = Class.forName("Calculator");
            
            // Get the default constructor
            Constructor<?> constructor = calculatorClass.getConstructor();
            Object calculatorInstance = constructor.newInstance();
            
            // Get all declared methods
            Method[] methods = calculatorClass.getDeclaredMethods();
            
            System.out.println("Available methods:");
            for (Method method : methods) {
                // Skip constructor and private methods
                if (method.getName().equals("<init>") || method.getName().equals("reset")) continue;
                
                System.out.println("\nMethod: " + method.getName());
                System.out.println("Return Type: " + method.getReturnType().getSimpleName());
                
                Class<?>[] parameters = method.getParameterTypes();
                System.out.print("Parameters: ");
                for (int i = 0; i < parameters.length; i++) {
                    System.out.print(parameters[i].getSimpleName());
                    if (i < parameters.length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }
            
            // Interactive method invocation
            while (true) {
                System.out.print("\nEnter method name (or 'exit' to quit): ");
                String methodName = scanner.nextLine();
                
                if (methodName.equalsIgnoreCase("exit")) {
                    break;
                }
                
                try {
                    Method method = calculatorClass.getMethod(methodName, int.class, int.class);
                    
                    System.out.print("Enter first number: ");
                    int num1 = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    
                    System.out.print("Enter second number: ");
                    int num2 = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    
                    Object result = method.invoke(calculatorInstance, num1, num2);
                    System.out.println("Result: " + result);
                    
                } catch (NoSuchMethodException e) {
                    System.out.println("Error: Method not found");
                } catch (InvocationTargetException e) {
                    System.out.println("Error executing method: " + e.getCause().getMessage());
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Class not found");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
