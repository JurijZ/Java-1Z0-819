import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Scratch {
    public static void main(String[] args) throws InterruptedException {

        // This example demonstrates the Synchronized collection
        // Note - this is not the same as concurrent collections

        Collection<Integer> syncCollection = Collections.synchronizedCollection(new ArrayList<>());

        // Create runnable
        Runnable listOperations = () -> {
            syncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
        };

        Thread thread1 = new Thread(listOperations);
        Thread thread2 = new Thread(listOperations);
        thread1.start();
        thread2.start();
        thread1.join(); // InterruptedException may be thrown here therefore method shout implement it
        thread2.join();

        System.out.println("Number of added elements is 12 - " + syncCollection.size());
    }
}
