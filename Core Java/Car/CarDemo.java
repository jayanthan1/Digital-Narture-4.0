/**
 * A demonstration of creating and using Car objects.
 */
public class CarDemo {
    public static void main(String[] args) {
        System.out.println("Car Class Demonstration");
        System.out.println("----------------------");
        
        // Create car objects using different constructors
        
        // Using parameterized constructor
        Car car1 = new Car("Toyota", "Camry", 2022);
        
        // Using default constructor and then setters
        Car car2 = new Car();
        car2.setMake("Honda");
        car2.setModel("Civic");
        car2.setYear(2023);
        
        // Create another car with the parameterized constructor
        Car car3 = new Car("Tesla", "Model 3", 2021);
        
        // Display details of each car
        System.out.println("\nCar 1:");
        car1.displayDetails();
        
        System.out.println("\nCar 2:");
        car2.displayDetails();
        
        System.out.println("\nCar 3:");
        car3.displayDetails();
        
        // Demonstrate using getters
        System.out.println("\nUsing getters for Car 1:");
        System.out.println("Make: " + car1.getMake());
        System.out.println("Model: " + car1.getModel());
        System.out.println("Year: " + car1.getYear());
        
        // Demonstrate toString method
        System.out.println("\nUsing toString method:");
        System.out.println("Car 1: " + car1);
        System.out.println("Car 2: " + car2);
        System.out.println("Car 3: " + car3);
        
        // Modify a car and display the updated details
        System.out.println("\nModifying Car 3:");
        car3.setYear(2024);
        car3.setModel("Model Y");
        car3.displayDetails();
    }
}
