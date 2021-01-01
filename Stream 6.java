import java.util.*;
import java.util.stream.Stream;

class TestPerson {
    public static void main(String[] args) {
        // Stream.concat
        System.out.println("\n---- concatenated streams");
        Stream<String> stringStream1 = Stream.of("First", "Second", "Third");
        Stream<String> stringStream2 = Stream.of("Forth", "Fifth");
        stringStream1 = Stream.concat(stringStream1, stringStream2);
        stringStream1.forEach(System.out::println);

        System.out.println("\n---- Remove duplicate elements in concat");
        var set1 = Set.<String>of("AAA", "BBB", "CCC");
        var set2 = Set.<String>of("CCC", "DDD");
        Stream s = Stream.concat(set1.stream(), set2.stream()).distinct();
        s.forEach(System.out::println);

        // It's important to understand the sequence of the intermediate operations
        System.out.println("\n---- Stream processes elements one by one");
        var set3 = Set.<String>of("AAA", "BBB", "CCC");
        // peek is used to look at the intermediate results in the middle of the steam transformations
        // peek exiss mainly to support debugging, to see elements as athey flow the pipeline
        Stream s3 = set3.stream().peek(p -> System.out.println("peeking at: " + p));
        var set4 = Set.<String>of("DDD", "EEE");
        Stream s4 = Stream.concat(s3, set4.stream());
        s4.forEach(System.out::println);

        // Check this intermediate behaviour
        System.out.println("\n---- Notice that last 3 is gone because of the distinct(), but peek of 3 did not -----");
        Stream<Integer> s5 = Stream.of(1, 2, 3);
        s5 = s5.peek(p -> System.out.println("peeking at: " + p));
        Stream<Integer> s6 = Stream.of(5, 4, 3);
        s6 = s6.peek(p -> System.out.println("peeking at: " + p));
        Stream concatStream = Stream.concat(s5, s6).distinct(); //
        concatStream.forEach(System.out::println);

        // Also notice that closing concat stream also closes source streams
        //s5.forEach(System.out::println); // At runtime throws IllegalStateException, stream has already been operated upon or closed

        // Changing the source after we created a stream and defined intermediate operations will be visible hence it's lazy
        // but after the termial operation is done the stream is gone and therefore changes will not be visible
        System.out.println("\n---- Adding element to the source after the stream is created is allowed hence the stream is lazy");
        Set set5 = new HashSet<>(List.of("AAA", "BBB", "CCC"));
        Stream s9 = set5.stream();
        set5.add("ZZZ");
        s9.forEach(System.out::println);
        set5.add("XXX");
    }
}
