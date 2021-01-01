import java.util.function.Consumer;
import java.util.function.Predicate;

class Scratch {
    public static void main(String[] args) {
        // Regular consumers
        Consumer<String> first = x -> System.out.println(x.toLowerCase());
        Consumer<String> second = y -> System.out.println("aaa " + y);

        first.accept("Java"); // java
        second.accept("Java"); // aaa Java

        // andThen default method
        Consumer<String> result = first.andThen(second);

        System.out.println("----andThen-----");
        result.accept("Java"); // java (followed by) aaa Java
    }
}
