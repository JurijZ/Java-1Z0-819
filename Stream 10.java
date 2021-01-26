import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class S{
    public int Age;

    S (int age){
        this.Age = age;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(5, 10, 20);
        System.out.println(list);

        // IntStream is a sequence of primitive int-valued elements supporting sequential and parallel aggregate operations.

        // sum using intStream
        var sum = list.stream()
                .mapToInt(s -> s)
                .sum(); // Note that sum() returns a primitive int, not Optional or object Integer

        System.out.println("sum using intStream: " + sum);

        // sum using intStream with objects
        List<S> list2 = List.of(new S(5), new S(10), new S(15));
        var sum2 = list2.stream()
                .mapToInt(s -> s.Age)
                .sum();
        System.out.println("sum using intStream of objects: " + sum2);

        // An alternative way of sum() is via a reduce operation
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        var sum3 = integers.stream().reduce(0, (total, currentElement) -> total + currentElement);
        System.out.println("sum using reduce: " + sum3);
        // total is stored in memory as an accumulator

        // There is a built in adder, so we can rewrite like this
        Integer sum4 = integers.stream().reduce(0, Integer::sum);
        System.out.println("sum using reduce: " + sum4);

        // average - always returns Optional of Double
        var average = integers.stream()
                .mapToInt(s -> s) // Note you need this to use average
                .average();
        System.out.println("average: " + average.getAsDouble());
    }
}
