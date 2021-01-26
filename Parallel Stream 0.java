import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Scratch {
    public static void main(String[] args) {
        // Create a list of integers, from 1 to 20
        List<Integer> integerList = Stream.iterate(1, (t) -> t <= 20, (t) -> t + 1)
                .collect(Collectors.toList());

        System.out.println("----- Using stateful lambda expression with simple List -----");
        //  Create parallel stream from integerList using parallelStream() method
        // Modifying unsynchronized list from the parallel operation leads to unpredictable results
        List<Integer> list = new ArrayList<>();

        list.clear();
        integerList
                .parallelStream()
                // we are changing the state of something outside - this is called a "stateful lambda expression"
                .forEach((s) -> {
                    list.add(0, s);
                });
        System.out.println(list);


        System.out.println("----- Using stateful lambda expression with synchronizedList -----");
        //  Create parallel stream from integerList using parallelStream() method
        List<Integer> synchList = Collections.synchronizedList(new ArrayList<>());

        synchList.clear();
        integerList.parallelStream()
                // we are changing the state of something outside - this is called a "stateful lambda expression"
                .forEach((s) -> {
                    synchList.add(0, s);
                });
        System.out.println(synchList);


        System.out.println("----- Tries to modify the source list -----");
        // Changing source while the stream is in parallelStream is not allowed - ConcurrentModificationException
        //integerList.parallelStream()
        //        .map((s) -> integerList.add(s))
        //        .forEachOrdered((s) -> System.out.print(s + " "));


        System.out.println("----- Tries to modify the source list, Example 2 -----");
        // subList is a view of the source list, therefore also throws a ConcurrentModificationException
        List<Integer> synchList2 = Collections.synchronizedList(integerList.subList(0, 10));
        integerList.parallelStream()
                .map((s) -> synchList2.add(s))
                .forEachOrdered((s) -> System.out.print(s + " "));
    }
}

