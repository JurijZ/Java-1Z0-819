import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class S{
    public static void main(String[] args) {
        // Basic Examples for stream creation

        // Stream.empty() creates empty Stream
        Stream<String> emptyStream = Stream.empty(); // nothing to print

        // Stream.of() creates Stream of elements passed
        Stream<String> stringStream = Stream.of("First", "Second", "Third");
        stringStream.forEach( s -> System.out.println(s));

        // Stream.ofNullable (if value passed null, empty Stream, otherwise Stream of ONE element
        Stream<String> emptyStream2 = Stream.ofNullable(null);
        Stream<String> stringStream2 = Stream.ofNullable("Forth");
        stringStream2.forEach( s -> System.out.println(s));

        // Stream.generate takes a Supplier to generate a stream
        System.out.println("\n----Infinite Stream created by Supplier limited to 10 ");
        Stream<Double> infinitelyRandom = Stream.generate(Math::random);
        infinitelyRandom.limit(10).forEach((t) -> System.out.print(String.format("%.4f  ", t)));

        // Stream.generate takes a Supplier to generate a stream
        System.out.println("\n----Custom Supplier ");
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "Value";
            }
        };
        Stream<String> stringRandom = Stream.generate(supplier);
        stringRandom.limit(10).forEach((t) -> System.out.print(t + " "));

        // Stream.generate takes a Supplier to generate a stream
        System.out.println("\n----Custom Supplier implemented as lambda");
        var integers = Stream.<Integer>generate(() -> { return 5; }); // lazy
        integers.limit(10).forEach((t) -> System.out.print(t + " "));
        // limit is also lazy. only when foreach is called the execution starts

        // Collection interface has method stream() so List, Set, Queue all can produce a stream..
        System.out.println("\n----Streams can be created from Collection implementing types ");
        List<String> l = new ArrayList<>(List.of("First", "Second", "Third"));
        Stream<String> listStream = l.stream();
        listStream.forEach(System.out::println);

        // Create a stream with a UnaryOperator based lambda expression numbers 5, 10, 15, 20, infinite stream
        // UnaryOperator - Represents an operation on a single operand that produces a result of the same type as its operand
        System.out.println("\n----Infinite Stream created by UnaryOperator limited to 10 ");
        Stream<Integer> infiniteStream = Stream.iterate(5, (t) -> t + 5);
        infiniteStream.limit(10).forEach((t) -> System.out.print(t + " "));

        // The stream.iterate was enhanced in Java 9. It supports a predicate (condition) as second argument,
        // and the stream.iterate will stop if the predicate is false.
        System.out.println("\n---- Finite Stream created by UnaryOperator limited to <= 100  ");
        Stream<Integer> finiteStream = Stream.iterate(5, (t) -> t <= 100, (t) -> t + 5);
        finiteStream.forEach((t) -> System.out.print(t + " "));
    }
}
