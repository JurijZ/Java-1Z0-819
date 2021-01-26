import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Scratch {
    public static void main(String[] args) {
        // This is to demonstrate reduce on parallel stream

        // First lets use a simple sum() to have something to compare with
        long sum = Stream.iterate(0, i -> i <= 10000, i -> i + 1)
                .mapToInt(s -> s)
                .sum();
        System.out.println("serial sum using sum() = " + sum);

        // Now use the reduce() without parallelism
        sum = Stream.iterate(0, i -> i <= 10000, i -> i + 1)
                .reduce(0, Integer::sum);
        System.out.println("serial sum using method reference" +
                "(Integer::sum) as accumulator = " + sum);

        // Now use the reduce() on a parallel stream, but without combiner
        sum = Stream.iterate(0, i -> i <= 10000, i -> i + 1)
                .parallel()
                // single args reduce method, accumulator
                .reduce(Integer::sum).get();
        System.out.println("parallel sum using method reference" +
                "(Integer::sum) as accumulator = " + sum);

        // And Finally use the reduce terminal operation on a parallel stream with combiner
        sum = Stream.iterate(0, i -> i <= 10000, i -> i + 1)
                .parallel()
                // three args reduce method
                .reduce(0, (s1, s2) -> s1 + s2, (a, b) -> a + b);
        System.out.println("parallel sum using lambda expression " +
                "((s1, s2) -> s1 + s2) as accumulator\n\t" +
                "and ((s1,s2) -> s1) as combiner= " + sum);
    }
}

