import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class S{

    public static void main(String[] args) {
        List<String> list1 = List.of();
        List<String> list2 = List.of("AAA", "BBB", "CCC");

        // findAny on empty stream will return Optional.Empty
        var x1 = list1.stream().peek(s -> System.out.println("peek: " + s)).findAny();
        System.out.println("findAny when empty stream: " + x1);

        // findAny on the stream with elements will end immediatelly after finding one element.
        // it will return the first element in a non-parallel pipeline.
        var x2 = list2.stream().peek(s -> System.out.println("peek: " + s)).findAny();
        System.out.println("findAny when stream with elements: " + x2);

        // However, in a parallel pipeline can return any element
        System.out.println("findAny on parallel steam: " + IntStream.range(0, 100).parallel().findAny().getAsInt());

        // findFirst on empty stream will return Optional.Empty
        var x3 = list1.stream().peek(s -> System.out.println("peek: " + s)).findFirst();
        System.out.println("findFirst when empty stream: " + x3);

        // findAny on the stream with elements ends after finding first
        var x4 = list2.stream().peek(s -> System.out.println("peek: " + s)).findFirst();
        System.out.println("findFirst when stream with elements: " + x4);
    }
}
