public class InvalidAgeException extends Exception {
    public InvalidAgeException() {
        super("Age must be at least 18");
    }
    
    public InvalidAgeException(String message) {
        super(message);
    }
}
