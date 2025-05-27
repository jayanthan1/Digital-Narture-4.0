import java.util.ArrayList;
import java.util.List;

public class DecompilationExample {
    private static final String GREETING = "Hello";
    private int count;
    private List<String> messages;

    // Constructor
    public DecompilationExample() {
        this.count = 0;
        this.messages = new ArrayList<>();
    }

    // Method with try-catch
    public void addMessage(String message) {
        try {
            messages.add(message);
            count++;
        } catch (Exception e) {
            System.err.println("Error adding message: " + e.getMessage());
        }
    }

    // Static method
    public static String getGreeting() {
        return GREETING;
    }

    // Method with lambda
    public void processMessages() {
        messages.forEach(msg -> System.out.println(msg));
    }

    // Method with enhanced for loop
    public void printMessages() {
        for (String msg : messages) {
            System.out.println("Message: " + msg);
        }
    }

    public static void main(String[] args) {
        DecompilationExample example = new DecompilationExample();
        example.addMessage("First message");
        example.addMessage("Second message");
        example.processMessages();
        example.printMessages();
    }
}
