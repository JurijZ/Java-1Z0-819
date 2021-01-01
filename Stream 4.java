import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

class TestPerson {
    public static void main(String[] args) {
        System.out.println("------ Method References ------");
        System.out.println("\nInstance Method on an object: ");
        Arrays.stream(TestPerson.namesArray).forEach(new TestPerson()::printInstance);

        System.out.println("\n\nReference to Constructor: ");
        Stream.generate(TestPerson::new)  // Infinite stream of generated objects. Uses toString to get the value from the object
                .limit(15)                // Limit to 15
                .sorted((s, t) -> s.getName().compareToIgnoreCase(t.getName()))
                .forEach(System.out::print);
    }

    // Private attributes...
    public static String[] namesArray = {"Allen", "Bob", "Caleb", "Don", "Fred"};
    private String name;

    // initializer give name at random
    {
        int i = new Random().nextInt(5 );
        this.name = namesArray[i];
    }

    public String toString() {
        return this.name + " ";
    }

    public String getName() {
        return this.name;
    }

    // Will use this method in a method reference
    public void printInstance(String s) {
        System.out.print(s + ", ");
    }
}
