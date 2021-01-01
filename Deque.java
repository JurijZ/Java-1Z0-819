import java.util.ArrayDeque;
import java.util.Deque;

class Scratch {
    public static void main(String[] args) {
        // Double-ended queue (https://www.softwaretestinghelp.com/deque-in-java/)
        Deque<String> deque = new ArrayDeque<>();
        deque.addLast("last");
        deque.addFirst("first");

        System.out.println(deque.element());   // Returns the first element or head of the deque. Note that it does not delete the element.
        System.out.println(deque.pop());   // Pop the element from the head (means it will be removed).
        System.out.println(deque);
        System.out.println(deque.poll());  // Deletes and returns the head of the deque. Returns null if the deque is empty.
        System.out.println(deque.peek());  // Returns head of the deque (first element) or null if a queue is empty. Does not delete the head
        //System.out.println(deque.element()); // NoSuchElementException
        //System.out.println(deque.pop()); // NoSuchElementException
    }
}