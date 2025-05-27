/**
 * A class representing a Car with attributes and methods.
 */
public class Car {
    // Attributes (instance variables)
    private String make;
    private String model;
    private int year;
    
    /**
     * Default constructor
     */
    public Car() {
        this.make = "Unknown";
        this.model = "Unknown";
        this.year = 0;
    }
    
    /**
     * Parameterized constructor
     * 
     * @param make The make of the car
     * @param model The model of the car
     * @param year The year the car was manufactured
     */
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
    
    /**
     * Getter for make
     * 
     * @return The make of the car
     */
    public String getMake() {
        return make;
    }
    
    /**
     * Setter for make
     * 
     * @param make The make to set
     */
    public void setMake(String make) {
        this.make = make;
    }
    
    /**
     * Getter for model
     * 
     * @return The model of the car
     */
    public String getModel() {
        return model;
    }
    
    /**
     * Setter for model
     * 
     * @param model The model to set
     */
    public void setModel(String model) {
        this.model = model;
    }
    
    /**
     * Getter for year
     * 
     * @return The year of the car
     */
    public int getYear() {
        return year;
    }
    
    /**
     * Setter for year
     * 
     * @param year The year to set
     */
    public void setYear(int year) {
        this.year = year;
    }
    
    /**
     * Displays the details of the car
     */
    public void displayDetails() {
        System.out.println("Car Details:");
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }
    
    /**
     * Returns a string representation of the car
     * 
     * @return String representation
     */
    @Override
    public String toString() {
        return year + " " + make + " " + model;
    }
}
