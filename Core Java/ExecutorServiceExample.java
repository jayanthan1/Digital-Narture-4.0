import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExample {
    private static final int POOL_SIZE = 4;
    private static final int NUM_TASKS = 10;
    
    public static void main(String[] args) {
        // Create a fixed thread pool
        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
        
        try {
            // Create a list to hold our Future objects
            List<Future<Integer>> futures = new ArrayList<>();
            
            // Submit tasks and collect Futures
            for (int i = 0; i < NUM_TASKS; i++) {
                int taskNumber = i + 1;
                Future<Integer> future = executor.submit(new Task(taskNumber));
                futures.add(future);
            }
            
            // Process results as they become available
            System.out.println("\nProcessing results:");
            for (Future<Integer> future : futures) {
                try {
                    // Get result (blocks until result is available)
                    int result = future.get();
                    System.out.println("Task completed with result: " + result);
                } catch (ExecutionException e) {
                    System.err.println("Task failed: " + e.getCause().getMessage());
                }
            }
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread interrupted: " + e.getMessage());
        } finally {
            // Shutdown the executor
            executor.shutdown();
            try {
                // Wait for all tasks to complete
                if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }
}

// Implement Callable to return a result
class Task implements Callable<Integer> {
    private final int taskNumber;
    
    public Task(int taskNumber) {
        this.taskNumber = taskNumber;
    }
    
    @Override
    public Integer call() throws Exception {
        // Simulate some work
        int result = taskNumber * 10;
        
        // Print task info
        System.out.println("Task " + taskNumber + " is running on thread " + Thread.currentThread().getName());
        
        // Simulate processing time
        Thread.sleep(1000);
        
        return result;
    }
}
