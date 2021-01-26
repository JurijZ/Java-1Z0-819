import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

class Scratch {
    public static void main(String[] args) {

        // Create a regular ArrayList and initialize with 5 values
        List<String> alist = new ArrayList<>(List.of("A", "B", "C", "D", "E"));

        // Create a CopyOnWriteArrayList using previous list
        List<String> concurrentList = new CopyOnWriteArrayList<>(alist);

        addToListWhileIterating(concurrentList); // with CopyOnWriteArrayList we can change the original list while iterating because
        //addToListWhileIterating(alist); // this will throw a ConcurrentModificationException, because it is not allowed to add to the list while iterating

        removeFromAListWhileIterating(concurrentList);
        //removeFromAListWhileIterating(alist); //throws a ConcurrentModificationException, regular list can not change the original list while iterating

        //removeFromIteratorWhileIterating(concurrentList); // CopyOnWriteArrayList cannot remove from the iterator, throws an UnsupportedOperationException
        removeFromIteratorWhileIterating(alist);
    }

    public static void addToListWhileIterating(List<String> list) {
        System.out.println("----------- Testing " + list.getClass().toGenericString());
        System.out.println("Original State: " + list);
        // Get Iterator
        Iterator<String> it = list.iterator();

        int i = 0;

        // Use iterator
        System.out.println("Print first three elements: ");
        while (it.hasNext()) {
            System.out.println(it.next());

            // Add some elements while iterating over elements.

            if (i++ == 0) {
                // We can change the original list because the iterator created out of the CopyOnWriteArrayList is a copy
                list.addAll(List.of("F", "J", "K")); // the current iterator will not see this additions, but the mutation did happened
            }
            // break after third element
            else if (i == 3) break;
        }

        // Print remaining elements on iterator
        System.out.println("Printing remaining elements");
        it.forEachRemaining(System.out::println);

        System.out.println("Values = " + list + "\n");
    }

    public static void removeFromAListWhileIterating(List<String> list) {
        System.out.println("----------- Testing " + list.getClass().toGenericString());
        System.out.println("Original State: " + list);

        // Get Iterator
        Iterator<String> it = list.iterator();
        int i = 0;

        // Use iterator
        while (it.hasNext()) {
            // Delete an element from the original list if index is 2
            if (i == 2) {
                // We can change the original list because the iterator created out of the CopyOnWriteArrayList is a copy
                list.remove(it.next());
                //it.remove();
            }
            else{
                it.next();
            }
            i++;
        }
        System.out.println("Values (C is deleted) = " + list + "\n");
    }

    public static void removeFromIteratorWhileIterating(List<String> list) {
        System.out.println("----------- Testing " + list.getClass().toGenericString());
        System.out.println("Original State: " + list);

        // Get Iterator
        Iterator<String> it = list.iterator();
        int i = 0;

        // Use iterator
        while (it.hasNext()) {
            // Delete an element from the iterator
            if (i == 2) {
                it.remove();
            }
            else{
                it.next();
            }
            i++;
        }
        System.out.println("Values (C is deleted) = " + list + "\n");
    }
}
