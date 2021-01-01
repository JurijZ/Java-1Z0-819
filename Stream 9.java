import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class S{

    public static void main(String[] args) {
        List<String> list = List.of("AAA", "BBB", "CCCCCC");
        System.out.println(list);

        // All of these are terminal operations. And short circuiting is possible.
        // anyMatch takes a Predicate and return boolean
        var b1 = list.stream().anyMatch(s -> s.length() == 4);
        System.out.println("anyMatch of length 4: " + b1);

        // allMatch - all elements must match the condition
        var b2 = list.stream().allMatch(s -> s.length() < 4);
        System.out.println("allMatch with length less then 4: " + b2);

        // noneMatch - all elements must NOT match the condition
        var b3 = list.stream().noneMatch(s -> s.length() > 20);
        System.out.println("noneMatch length more then 20: " + b3);

        // max
        var max = list.stream().max(Comparator.naturalOrder()).get();
        System.out.println("max value based on the natural order: " + max);

        // min
        var min = list.stream().min(Comparator.naturalOrder()).get();
        System.out.println("min value based on the natural order: " + min);

        // Note - you have to be careful with getting result from the max/min
        // Hence it returns Optional the get() will throw exception if it's empty
        List<String> list2 = List.of();
        var max2optional = list2.stream().max(Comparator.naturalOrder());
        //var max2value = max2optional.get(); // NoSuchElementException
        // To fix this we can use orElse()
        var max2value = max2optional.orElse("EMPTY");
        System.out.println("max of empty list: " + max2value);

    }
}
