/**
 * A demonstration of inheritance between Animal and Dog classes.
 */
public class InheritanceDemo {
    public static void main(String[] args) {
        System.out.println("Inheritance Demonstration");
        System.out.println("------------------------");
        
        // Create an Animal object
        System.out.println("Creating an Animal:");
        Animal animal = new Animal("Generic Animal", 5);
        
        // Display animal details
        animal.displayDetails();
        
        // Make the animal sound
        System.out.print("Animal sound: ");
        animal.makeSound();
        
        System.out.println("\n------------------------");
        
        // Create a Dog object
        System.out.println("Creating a Dog:");
        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
        
        // Display dog details (inherited and extended method)
        dog.displayDetails();
        
        // Make the dog sound (overridden method)
        System.out.print("Dog sound: ");
        dog.makeSound();
        
        // Call dog-specific method
        dog.wagTail();
        
        System.out.println("\n------------------------");
        
        // Demonstrate polymorphism
        System.out.println("Demonstrating Polymorphism:");
        
        // An Animal reference can point to a Dog object
        Animal polymorphicDog = new Dog("Rex", 2, "German Shepherd");
        
        // The method called depends on the actual object type, not the reference type
        System.out.print("Polymorphic dog sound: ");
        polymorphicDog.makeSound(); // This will call Dog's makeSound() method
        
        // Display details using the polymorphic reference
        polymorphicDog.displayDetails(); // This will call Dog's displayDetails() method
        
        // Note: We cannot call dog-specific methods through an Animal reference
        // polymorphicDog.wagTail(); // This would cause a compilation error
    }
}
