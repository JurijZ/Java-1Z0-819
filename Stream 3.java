import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class S{
    public static void main(String[] args) {
        // reduce - is a terminal operation
        // Identity – an element that is the initial value of the reduction operation and the default result if the stream is empty
        // Accumulator – a function that takes two parameters: a partial result of the reduction operation and the next element of the stream

        // reduction stream operations allow us to produce one single result from a sequence of elements,
        // by applying repeatedly a combining operation to the elements in the sequence.
        var stream = Stream.iterate(5, t -> t <= 100, t -> t + 5);
        var r = stream.reduce(0, (accumulator, nextElement) -> accumulator + nextElement);
        System.out.println("Reduce result: " + r);

        List<String> list = List.of("First", "Second", "Third", "Forth", "Fifth");
        var st = list.stream().reduce("", (accumulator, nextElement) -> accumulator + nextElement);
        System.out.println("Reduce result: " + st);

        // We can pass a method instead of a lambda
        var st2 = list.stream().reduce("", S::JoinStrings);
        System.out.println("Reduce result: " + st2);

        //Combiner – a function used to combine the partial result of the reduction operation when the reduction is parallelized,
        // or when there's a mismatch between the types of the accumulator arguments and the types of the accumulator implementation
        // Three argument reduce
        int result = List.of("AAA", "BBB", "CCC")
                .parallelStream()
                .reduce( 0,
                            (accumulatedInt, str) -> accumulatedInt + str.length(),                 //accumulator
                            (accumulatedInt, accumulatedInt2) -> accumulatedInt + accumulatedInt2   //combiner
                );
        System.out.println("Reduce result: " + result);
        // if we use sequential streams and the types of the accumulator arguments and the types of its implementation match,
        // we don't need to use a combiner.
    }

    // This method must match the functional interface of the BinaryOperator - T method(T, T)
    // two input parameters of the same type and also match the return type
    public static String JoinStrings(String s, String s2){
        return s + s2;
    }
}
