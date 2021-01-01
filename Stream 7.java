import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class S{
    public String name;

    S(String name){
        this.name = name;
    }

    public String toString(){
        return this.name;
    }

    public static void main(String[] args) {
        List<String> list = List.of("AAA", "BBB", "CCC", "DDD", "EEE");

        // map - is used to transform data in the stream
        var list1 = list.stream().map(s -> s + "-1").collect(Collectors.toList());
        System.out.println("Transform elements with map: " + list1);

        // map - the return type can be different.
        // Here the input is list of strings and output is a list of objects
        var list2 = list.stream()
                .map(s -> new S(s + "-map"))
                .collect(Collectors.toList());
        System.out.println("Transform list of strings into list of objects: " + list2);

        // flatMap - joins stream of lists/arrays/etc into a single stream
        List<String> list4 = List.of("AAA BBB CCC", "BBB DDD EEE", "CCC GGG KKK");
        var list41 = list4.stream()
                .map(s -> s.split("\\s+"))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        System.out.println("Transform list of strings into list of objects: " + list41);
    }
}
