import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Scratch {
    public static void main(String[] args) {
        // Create an ArrayList
        List<String> originalList = new ArrayList<>(
                List.of("Anne", "Barry", "Charles", "David", "Edward")
        );
        // Note that List.of creates an immutable list, and that's why we need new ArrayList statement

        System.out.println("\n----- The subList View -----");

        // First index is inclusive, Last index is exclusive so 3 elements
        List<String> shortList = originalList.subList(1, 4);
        System.out.println("namesList: " + originalList);
        System.out.println("shortList: " + shortList);

        // Reverse the order of the A List
        shortList.sort(Comparator.reverseOrder());
        System.out.println("shortList: " + shortList);
        System.out.println("namesList: " + originalList);

        // What if we alter the view?
        System.out.println("\n----- Add element to subList View -----");
        shortList.add("Aryn");
        System.out.println("shortList: " + shortList);
        System.out.println("namesList: " + originalList);

        // This implements sort of subList, using method reference
        shortList.sort(String::compareTo);
        System.out.println("shortList: " + shortList);
        System.out.println("namesList: " + originalList);

        // What if we alter the original list?
        System.out.println("\n----- Added Brad to namesList -----");
        originalList.add("Brad");
        System.out.println(originalList);

        //System.out.println(shortList); // ConcurrentModificationException will be thrown
        // because the original list is changed and the view became invalid

        // copyOf method produces a list that cannot be changed (immutable)
        List copyList = List.copyOf(originalList);
        //copyList.add("Name"); // UnsupportedOperationException

        // But we can make it mutable again by doing this
        List mutableCopyList = new ArrayList(copyList);
        mutableCopyList.add("Name");
        System.out.println(mutableCopyList);
    }
}
