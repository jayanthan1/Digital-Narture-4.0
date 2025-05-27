/**
 * A demonstration of implementing and using the Playable interface with Guitar and Piano classes.
 */
public class InterfaceDemo {
    public static void main(String[] args) {
        System.out.println("Interface Implementation Demonstration");
        System.out.println("--------------------------------------");
        
        // Instantiate Guitar and Piano
        Playable guitar = new Guitar();
        Playable piano = new Piano();
        
        // Call the play() method on each
        System.out.print("Guitar: ");
        guitar.play();
        
        System.out.print("Piano: ");
        piano.play();
        
        // Demonstrate polymorphism with an array of Playable
        System.out.println("\nPolymorphism with Playable array:");
        Playable[] instruments = {guitar, piano};
        for (Playable instrument : instruments) {
            instrument.play();
        }
    }
}
