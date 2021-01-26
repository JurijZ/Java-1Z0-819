import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class S{
    public static void main(String[] args) {
        // The reduction is meant to combine two immutable values such as int, double, string, etc.
        // and produce a new one; It’s an immutable reduction.
        // The collect method is designed to mutate a container to accumulate the result it’s supposed to produce.

        // Create a List which will be used as source of stream pipelines
        List<String> originalList = new ArrayList<>(List.of("First", "Second", "Third"));

        // Using stream to add 'ish' to all elements,creating another list
        List<String> firstList = originalList.stream().map((s) -> s + "ish")
                .collect(Collectors.toList());

        // Add another element to list returned from collect - to prove it's a mutable list
        firstList.add("Fourthish");

        // Print both lists
        System.out.println("originalList = " + originalList); // First list is untouched
        System.out.println("firstList = " + firstList);

        System.out.println("---- .collect(Collectors.joining) examples ----");
        String joinedExample1 = originalList.stream().collect(Collectors.joining());  // Joins with no delimiters
        String joinedExample2 = originalList.stream().collect(Collectors.joining(", ")); // Joins Strings delimited by a comma
        String joinedExample3 = originalList.stream().collect(Collectors.joining(", ", "List [", "]"));         // Joins Strings delimited by a comma, prefixed/suffixed with beginning/ending bracket

        System.out.println("Collectors.joining - with no parameters: " + joinedExample1);
        System.out.println("Collectors.joining - with delimiter : " + joinedExample2);
        System.out.println("Collectors.joining - with delimiter," + " prefix and suffix : " + joinedExample3);

        System.out.println("---- .collect(Collectors.averaging) examples ----");
        double average = new Random().ints(1, 100_000)
                // Limit to 1000 random numbers
                .limit(1000)
                .boxed() // This is mandatory because we have primitives - transform to an Integer stream
                .collect(Collectors.averagingInt((s) -> s));

        // Note - To convert a stream of primitives, we must first box the elements in their wrapper classes
        // and then collect the wrapped objects in a collection

        System.out.println("average of random integers = " + average);

    }
}
