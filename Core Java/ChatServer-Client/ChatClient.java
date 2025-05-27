import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 12345;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        String clientName = scanner.nextLine();
        
        try (Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            
            // Send client name to server
            writer.println(clientName);
            
            // Start thread to read messages from server
            Thread readThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = reader.readLine()) != null) {
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    System.err.println("Error reading from server: " + e.getMessage());
                }
            });
            readThread.start();
            
            // Read messages from user and send to server
            System.out.println("Type /quit to exit");
            System.out.print("Message: ");
            
            while (scanner.hasNextLine()) {
                String message = scanner.nextLine();
                writer.println(message);
                
                if (message.equalsIgnoreCase("/quit")) {
                    break;
                }
                System.out.print("Message: ");
            }
            
        } catch (IOException e) {
            System.err.println("Connection error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
