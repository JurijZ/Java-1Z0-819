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
        List<String> list = List.of("First", "Second", "Third", "Forth", "Fifth");

        // filter
        var c = list.stream().filter(s -> s.startsWith("F")).count();
        System.out.println("Starts with F count: " + c);

        // anyMatch - useful if you need to find if there is at least one match.
        // It will stop as soon as match is detected - this is a short-circuiting
        var b = list.stream().anyMatch(s -> s.startsWith("F"));
        System.out.println("Is there a word that starts with F: " + b);

        // dropWhile - removes the elements from the stream until the predicate is true
        var list1 = list.stream().dropWhile(s -> s.startsWith("F")).collect(Collectors.toList());
        System.out.println("Drops until starts with F: " + list1);

        // takeWhile - takes the elements from the stream until the predicate is true
        var list2 = list.stream().takeWhile(s -> s.startsWith("F")).collect(Collectors.toList());
        System.out.println("Takes until words start with F: " + list2);
    }
}
