import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

class TestPerson {
    public static void main(String[] args) {

        System.out.println("This works");
        Stream s = Stream.of(1, 2, 3, 4, 5);
        s = s.limit(2);
        s.forEach(System.out::println);

        System.out.println("This does not work");
        Stream s1 = Stream.of(1, 2, 3, 4, 5);
        s1.limit(2);
        s1.forEach(System.out::println); // At runtime will throw an IllegalStateException - stream has already been operated upon or closed

    }
}
