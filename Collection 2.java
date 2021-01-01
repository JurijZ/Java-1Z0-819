import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Scratch {
    public static void main(String[] args) {
        // Create an ArrayList
        List<String> namesList = new ArrayList<>(
                List.of("Anne", "Barry", "Charles", "David", "Edward")
        );

        System.out.println("\n---- copyOf() method copy ----");
        List<String> copiedList = List.copyOf(namesList);
        System.out.println("copiedList: " + copiedList);

        // Copied list became unmodifiable, that is it has no add() method
        copiedList.add("Test"); // UnsupportedOperationException exception will be thrown

        // If we want to make the list modifiable again we need to convert into ArrayList
        List newList = new ArrayList(copiedList);
        newList.add("Ralph");
        System.out.println("newList: " + newList);
    }
}
