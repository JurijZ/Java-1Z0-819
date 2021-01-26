import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class C {
    public String P1;
    C(String p){ this.P1 = p ;}

    public static void main(String[] args) {

        // sorted() on streams - simple example
        List<String> initialData = List.<String>of("One", "Two", "Three", "Four", "Five");
        System.out.println("\n---- Using sorted operation on Stream");
        initialData.stream()
                // Uses Natural Order, alphabetical
                .sorted()
                .forEach((s) -> System.out.print(s + " "));

        System.out.println("\n---- Using sorted with builtin Comparator methods, like reverseOrder");
        initialData.stream()
                .sorted(Comparator.reverseOrder())
                .forEach((s) -> System.out.print(s + " "));

        // Note - into sorted() we pass a method that returns a Comparator object:
        var c = Comparator.reverseOrder();
        // Passing a method reference will create a Compile time error:
        //initialData.stream().sorted(Comparator::reverseOrder)
        // It's because method reference references to a method without executing it, it's essentially lambda
        // all methods refs can be expressed as lambdas

        // sorted() with C objects will throw exception hence C does not implement Comparable interface
        // ClassCastException will be thrown at runtime
        //Stream.of(new C("Carol"), new C("Ann")).sorted().forEach((s) -> System.out.print(s + " "));

        // We can solve this by passing a lambda into sorted()
        System.out.println("\n---- Using sorted with inline lambda on objects that do not implement Comparable");
        Stream.of(new C("Carol"), new C("Ann"))
                .sorted((s, t) -> s.P1.compareToIgnoreCase(t.P1))
                .forEach((s) -> System.out.print(s.P1 + " "));

        // sorted() with on stream of Guest objects that implements Comparable
        System.out.println("\n---- Using sorted with Stream of Guest");
        Stream.of(new Guest("Carol", "Green"), new Guest("Ann", "Jones"), new Guest("Bob", "Smith") )
                .sorted(Guest::sortByFirst) // sortByFirst matches Comparator functional interface - compare() method
                .forEach((s) -> System.out.println(s.first + " " + s.last));

    }
}

// Note that comparable is of type Guest
class Guest implements Comparable<Guest>{
    protected String first;
    protected String last;

    // Constructor
    Guest(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public String toString() {
        return this.last + ", " + this.first;
    }

    // Abstract method of the Comparable interface is compareTo()
    public int compareTo(Guest o) {
        return last.compareToIgnoreCase(o.last);
    }

    // Matches Comparator interface - int compare(Object obj1, Object obj2)
    public static int sortByFirst(Guest g1, Guest g2) {
        return g1.first.compareToIgnoreCase(g2.first);
    }
}
