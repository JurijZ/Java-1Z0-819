import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Scratch {
    public static void main(String[] args) {
        // Create an ArrayList
        List<String> namesList = new ArrayList<>(List.of("Anne", "Barry", "Charles", "David", "Edward"));
        System.out.println(namesList);

        System.out.println("\n---- Swap two elements ----");
        Collections.swap(namesList, 1, 3);
        System.out.println(namesList);

        System.out.println("\n---- Max ----");
        System.out.println(Collections.max(namesList));

        System.out.println("\n---- Min ----");
        System.out.println(Collections.min(namesList));

        // The copy(List<? super T>, List<? extends T>) method is used to copy all of the elements from one list INTO another.
        List<String> namesList2 = new ArrayList<>(List.of("Gin", "Lorry"));
        Collections.copy(namesList, namesList2);
        System.out.println(namesList);
        System.out.println(namesList2);
        //Collections.copy(namesList2, namesList); IndexOutOfBoundsException − the destination list is too small to contain the entire source List.

        // The fill() is used to replace ALL of the elements of the specified list with the specified elements
        System.out.println("\n---- Fill the element ----");
        Collections.fill(namesList, "DefaultValue");
        System.out.println(namesList);

        // Initializes a List with default values
        System.out.println("\n---- Initialize with default values ----");
        List<String> immutableList = Collections.nCopies(3, "DefaultValue");
        System.out.println(immutableList);
    }
}
