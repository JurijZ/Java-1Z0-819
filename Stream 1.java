import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class S{
    public static void main(String[] args) {

        // 1. Stream builder
        // This allows the creation of a Stream by generating elements individually and adding them to the Builder
        // (without the copying overhead that comes from using an ArrayList as a temporary buffer.)
        System.out.println("\n---- Stream of words using Stream.Builder");
        Stream.Builder<String> wordStreamBuilder = Stream.<String>builder();
        String s = "My text is very long.";
        for (String word : s.split("\\s")) {
            wordStreamBuilder.accept(word); // Adds an element to the stream being built
        }
        Stream<String> wordStream = wordStreamBuilder.build();
        wordStream.forEach(System.out::println);

        // A stream builder has a lifecycle, which starts in a building phase, during which elements can be added,
        // and then transitions to a built phase, after which elements may not be added.
        // The built phase begins when the build() method is called, which creates an ordered Stream whose elements are the elements
        // that were added to the stream builder, in the order they were added

        // 2. Strongly typed Stream builder.
        Stream.Builder<Integer> sb = Stream.<Integer>builder();
        sb.add(1);
        sb.add(2);
        Stream<Integer> stream = sb.build();
        //sb.add(4); // This is not a compile time error. But at the runtime it will throw an IllegalStateException

        // 3. Mixed type Stream builder
        Stream.Builder sb5 = Stream.<Integer>builder(); // We assign a strongly typed builder to a raw builder
        sb5.add(1); // Because we have a row builder variable we can assign other types without compile time error
        sb5.add(new Object()); // Because we have a row builder variable we can assign other types without compile time error
        //Stream<Integer> stream5 = sb5.build(); // But at Runtime it will throw a ClassCastException

        // 4. Raw Stream builder.
        Stream.Builder sb2 = Stream.builder();
        sb2.add("A");
        sb2.add("B");
        sb2.add(new Object()); // This is not a compile time error
        //Stream stream2 = sb2.build(); // This will work hence the builder is raw
        Stream<String> stream2 = sb2.build(); // This will make a strongly typed stream which will lead to runtime exception when used
        //stream2.forEach(System.out::println); // ClassCastExcecption

        // Raw builder with cChained methods
        Stream.builder().add(5).add(7).add("text").build().forEach(System.out::println); // this works
        Stream.<Object>builder().add(5).add(7).add("text").build().forEach(System.out::println); // this works
        //Stream.<Integer>builder().add(5).add(7).add("text").build().forEach(System.out::println); // Compile error



    }
}
