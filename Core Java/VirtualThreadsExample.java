import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VirtualThreadsExample {
    private static final int NUM_THREADS = 100_000;
    private static final int NUM_ITERATIONS = 10;
    
    public static void main(String[] args) {
        // Run both tests multiple times for better accuracy
        for (int i = 0; i < NUM_ITERATIONS; i++) {
            System.out.println("\nIteration " + (i + 1) + "/" + NUM_ITERATIONS);
            
            // Test traditional threads
            long traditionalTime = testTraditionalThreads();
            System.out.println("Traditional Threads Time: " + traditionalTime + " ms");
            
            // Test virtual threads
            long virtualTime = testVirtualThreads();
            System.out.println("Virtual Threads Time: " + virtualTime + " ms");
            
            // Calculate speedup
            double speedup = ((double) traditionalTime / virtualTime);
            System.out.printf("Speedup (Traditional/Virtual): %.2fx\n", speedup);
            
            // Small delay between iterations
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    private static long testTraditionalThreads() {
        long startTime = System.currentTimeMillis();
        
        // Use a cached thread pool for traditional threads
        try (ExecutorService executor = Executors.newCachedThreadPool()) {
            for (int i = 0; i < NUM_THREADS; i++) {
                executor.submit(() -> {
                    // Simulate some work
                    Thread.sleep(1);
                    System.out.println(Thread.currentThread().getName() + " is running");
                });
            }
        } catch (Exception e) {
            System.err.println("Error in traditional threads: " + e.getMessage());
        }
        
        return System.currentTimeMillis() - startTime;
    }
    
    private static long testVirtualThreads() {
        long startTime = System.currentTimeMillis();
        
        // Use virtual threads
        for (int i = 0; i < NUM_THREADS; i++) {
            Thread.startVirtualThread(() -> {
                // Simulate some work
                Thread.sleep(1);
                System.out.println(Thread.currentThread().getName() + " is running");
            });
        }
        
        return System.currentTimeMillis() - startTime;
    }
}
