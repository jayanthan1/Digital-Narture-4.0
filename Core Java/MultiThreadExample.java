public class MultiThreadExample {
    public static void main(String[] args) {
        // Thread implementation using Runnable interface
        Runnable helloRunnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Hello Thread: " + i);
                    try {
                        Thread.sleep(1000); // Sleep for 1 second
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("Hello thread interrupted!");
                    }
                }
            }
        };
        
        // Thread implementation by extending Thread class
        Thread goodbyeThread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Goodbye Thread: " + i);
                    try {
                        Thread.sleep(1500); // Sleep for 1.5 seconds
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("Goodbye thread interrupted!");
                    }
                }
            }
        };
        
        // Create and start threads
        Thread helloThread = new Thread(helloRunnable, "HelloThread");
        helloThread.start();
        goodbyeThread.start();
        
        // Wait for both threads to complete
        try {
            helloThread.join();
            goodbyeThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted!");
        }
        
        System.out.println("\nBoth threads have completed execution.");
    }
}
