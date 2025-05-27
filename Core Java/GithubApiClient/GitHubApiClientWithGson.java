import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * Demonstrates the use of Java 11+ HTTP Client API with Gson JSON parsing
 * This example fetches and parses data from GitHub API
 */
public class GitHubApiClientWithGson {
    
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
            // Fetch and display user information with JSON parsing
            fetchAndDisplayUserInfo(client, username);
            
            // Fetch and display repository information with JSON parsing
            fetchAndDisplayRepositories(client, username);
            
        } catch (IOException | InterruptedException e) {
            System.err.println("Error occurred during API request: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Fetches and displays user information with JSON parsing
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
        
        // Send the request and get the response as a string
        HttpResponse<String> response = client.send(request, 
                HttpResponse.BodyHandlers.ofString());
        
        // Print response status code
        System.out.println("Response Status Code: " + response.statusCode());
        
        if (response.statusCode() == 200) {
            // Parse JSON response using Gson
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonElement jsonElement = JsonParser.parseString(response.body());
            String prettyJson = gson.toJson(jsonElement);
            
            // Create a User object from the JSON
            User user = gson.fromJson(response.body(), User.class);
            
            // Display user information
            System.out.println("\nUser Information:");
            System.out.println("Login: " + user.login);
            System.out.println("Name: " + user.name);
            System.out.println("Company: " + user.company);
            System.out.println("Location: " + user.location);
            System.out.println("Public Repos: " + user.public_repos);
            System.out.println("Followers: " + user.followers);
            System.out.println("Following: " + user.following);
            
            // Display pretty-printed JSON
            System.out.println("\nFull JSON Response (Pretty Printed):");
            System.out.println(prettyJson);
        } else {
            System.out.println("Error: " + response.body());
        }
    }
    
    /**
     * Fetches and displays repository information with JSON parsing
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
        
        // Send the request and get the response as a string
        HttpResponse<String> response = client.send(request, 
                HttpResponse.BodyHandlers.ofString());
        
        // Print response status code
        System.out.println("Response Status Code: " + response.statusCode());
        
        if (response.statusCode() == 200) {
            // Parse JSON response using Gson
            Gson gson = new Gson();
            Repository[] repositories = gson.fromJson(response.body(), Repository[].class);
            
            // Display repository information
            System.out.println("\nRepositories (" + repositories.length + " total):");
            
            for (int i = 0; i < Math.min(5, repositories.length); i++) {
                Repository repo = repositories[i];
                System.out.println("\n" + (i + 1) + ". " + repo.name);
                System.out.println("   Description: " + (repo.description != null ? repo.description : "N/A"));
                System.out.println("   Language: " + (repo.language != null ? repo.language : "N/A"));
                System.out.println("   Stars: " + repo.stargazers_count);
                System.out.println("   Forks: " + repo.forks_count);
                System.out.println("   URL: " + repo.html_url);
            }
            
            if (repositories.length > 5) {
                System.out.println("\n... and " + (repositories.length - 5) + " more repositories");
            }
        } else {
            System.out.println("Error: " + response.body());
        }
    }
    
    /**
     * Class representing a GitHub user
     */
    static class User {
        String login;
        String name;
        String company;
        String location;
        String bio;
        String blog;
        int public_repos;
        int followers;
        int following;
    }
    
    /**
     * Class representing a GitHub repository
     */
    static class Repository {
        String name;
        String full_name;
        String description;
        String language;
        String html_url;
        int stargazers_count;
        int forks_count;
        boolean fork;
    }
}
