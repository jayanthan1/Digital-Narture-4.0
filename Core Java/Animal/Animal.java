/**
 * Base class representing an Animal.
 */
public class Animal {
    // Attributes
    protected String name;
    protected int age;
    
    /**
     * Default constructor
     */
    public Animal() {
        this.name = "Unknown";
        this.age = 0;
    }
    
    /**
     * Parameterized constructor
     * 
     * @param name The name of the animal
     * @param age The age of the animal
     */
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    /**
     * Getter for name
     * 
     * @return The name of the animal
     */
    public String getName() {
        return name;
    }
    
    /**
     * Setter for name
     * 
     * @param name The name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Getter for age
     * 
     * @return The age of the animal
     */
    public int getAge() {
        return age;
    }
    
    /**
     * Setter for age
     * 
     * @param age The age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
    
    /**
     * Method to make a sound - will be overridden by subclasses
     */
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
    
    /**
     * Method to display animal details
     */
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
