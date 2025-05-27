/**
 * Subclass representing a Dog that inherits from Animal.
 */
public class Dog extends Animal {
    // Additional attributes specific to Dog
    private String breed;
    
    /**
     * Default constructor
     */
    public Dog() {
        // Calls the parent class's default constructor
        super();
        this.breed = "Unknown";
    }
    
    /**
     * Parameterized constructor
     * 
     * @param name The name of the dog
     * @param age The age of the dog
     * @param breed The breed of the dog
     */
    public Dog(String name, int age, String breed) {
        // Calls the parent class's parameterized constructor
        super(name, age);
        this.breed = breed;
    }
    
    /**
     * Getter for breed
     * 
     * @return The breed of the dog
     */
    public String getBreed() {
        return breed;
    }
    
    /**
     * Setter for breed
     * 
     * @param breed The breed to set
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }
    
    /**
     * Override the makeSound method from the parent class
     */
    @Override
    public void makeSound() {
        System.out.println("Bark!");
    }
    
    /**
     * Override the displayDetails method to include dog-specific information
     */
    @Override
    public void displayDetails() {
        // Call the parent class's displayDetails method
        super.displayDetails();
        // Add dog-specific details
        System.out.println("Breed: " + breed);
    }
    
    /**
     * Dog-specific method
     */
    public void wagTail() {
        System.out.println(name + " wags tail happily!");
    }
}
