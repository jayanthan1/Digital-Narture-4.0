import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.Map;

/**
 * Demonstrates the use of Java 11+ HTTP Client API to fetch data from GitHub API
 * This example fetches repository information for a given username
 */
public class GitHubApiClient {
    
    // Constants
    private static final String GITHUB_API_URL = "https://api.github.com";
    private static final int TIMEOUT_SECONDS = 10;
    
    public static void main(String[] args) {
        // Create an HTTP client with default settings
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)  // Use HTTP/2 if available
                .connectTimeout(Duration.ofSeconds(TIMEOUT_SECONDS))
                .build();
        
        // Username to fetch repositories for
        String username = "octocat"; // Example GitHub username
        
        try {
            // Fetch and display user information
            fetchAndDisplayUserInfo(client, username);
            
            // Fetch and display repository information
            fetchAndDisplayRepositories(client, username);
            
        } catch (IOException | InterruptedException e) {
            System.err.println("Error occurred during API request: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Fetches and displays basic user information from GitHub API
     */
    private static void fetchAndDisplayUserInfo(HttpClient client, String username) 
            throws IOException, InterruptedException {
        
        // Build the request to get user information
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(GITHUB_API_URL + "/users/" + username))
                .header("Accept", "application/vnd.github.v3+json")
                .GET()
                .build();
        
        System.out.println("Fetching user information for: " + username);
        System.out.println("Request URL: " + request.uri());
        
        // Send the request and get the response as a string
        HttpResponse<String> response = client.send(request, 
                HttpResponse.BodyHandlers.ofString());
        
        // Print response status code
        System.out.println("Response Status Code: " + response.statusCode());
        
        // Print response headers
        System.out.println("\nResponse Headers:");
        response.headers().map().forEach((key, values) -> {
            System.out.println(key + ": " + String.join(", ", values));
        });
        
        // Print raw response body
        System.out.println("\nResponse Body (raw JSON):");
        System.out.println(response.body());
        
        // Parse and display JSON in a more readable format
        // For simplicity, we're just printing the raw JSON here
        // In a real application, you would use Jackson or Gson to parse this
    }
    
    /**
     * Fetches and displays repository information from GitHub API
     */
    private static void fetchAndDisplayRepositories(HttpClient client, String username) 
            throws IOException, InterruptedException {
        
        // Build the request to get repositories
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(GITHUB_API_URL + "/users/" + username + "/repos"))
                .header("Accept", "application/vnd.github.v3+json")
                .GET()
                .build();
        
        System.out.println("\n\n-------------------------------------------");
        System.out.println("Fetching repositories for: " + username);
        System.out.println("Request URL: " + request.uri());
        
        // Send the request and get the response as a string
        HttpResponse<String> response = client.send(request, 
                HttpResponse.BodyHandlers.ofString());
        
        // Print response status code
        System.out.println("Response Status Code: " + response.statusCode());
        
        // Print response body length
        System.out.println("Response Body Length: " + response.body().length() + " characters");
        
        // Print first 500 characters of the response body
        String preview = response.body().length() > 500 
                ? response.body().substring(0, 500) + "..." 
                : response.body();
        System.out.println("\nResponse Body Preview:");
        System.out.println(preview);
        
        System.out.println("\nNote: To properly parse this JSON response, you would typically use a library like Gson or Jackson.");
    }
}
