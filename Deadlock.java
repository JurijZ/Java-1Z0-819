import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class C {
    public static void main(String[] args) {
        // This code demonstrates a deadlock

        // Create two neighbors
        Neighbor dave = new Neighbor("Dave");
        Neighbor craig = new Neighbor("Craig");

        // Create and start two threads, where each neighbor greet the other and then respond.
        // N1.greet(N2).respond(N1) <-> N2.greet(N1).respond(N2)
        new Thread(() -> dave.greet(craig)).start();
        new Thread(() -> craig.greet(dave)).start();

        // Both greet() and respond() methods are synchronized therefore the threads will deadlock and program never finish.
        // If you remove the synchronized keyword from the respond() method all will work properly.
    }
}

class Neighbor {
    private final String name;

    // Constructor
    public Neighbor(String name) {
        this.name = name;
    }

    // synchronized method cannot execute if the instance is locked,
    // will lock instance when operation is invoked, and release lock
    // when operation completes
    public synchronized void greet(Neighbor neighbor) {
        System.out.println("Hi " + neighbor.name + ", how are you?");
        neighbor.respond(this);
    }

    // synchronized method cannot execute if the instance is locked,
    // Must wait for lock on instance to be released
    public synchronized void respond(Neighbor neighbor) {
        System.out.println("I am fine, " + neighbor.name +
                ", how are the kids? ");
    }
}