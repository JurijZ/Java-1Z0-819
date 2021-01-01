import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Scratch {
    public static void main(String[] args) {
        // Initialize some data
        List<Integer> initialData = List.of(1, 10, 20, 50, 51);

        // Create a Set from this list, best practice to declare variables to the interface type as shown here.
        Set<Integer> t = new TreeSet<>(initialData);

        // Cast t to a TreeSet variable to invoke TreeSet methods
        TreeSet<Integer> treeSet = (TreeSet<Integer>) t;

        // lower returns the greatest element < (less than) the parameter
        // value or null if no smaller element exists
        System.out.println("Using lower with values (1, 10, 20, 50, 51): "
                + treeSet.lower(1) + " of 1, "
                + treeSet.lower(10) + " of 10, "
                + treeSet.lower(20) + " of 20, "
                + treeSet.lower(50) + " of 50, "
                + treeSet.lower(51) + " of 51 ");

        // higher returns the least element > (greater than) the parameter
        // value or null if no greater element exists
        System.out.println("Using higher with values (1, 10, 20, 50, 51): "
                + treeSet.higher(1) + " of 1, "
                + treeSet.higher(10) + " of 10, "
                + treeSet.higher(25) + " of 25, "
                + treeSet.higher(50) + " of 50, "
                + treeSet.higher(51) + " of 51 ");

        // floor returns the greatest element <= (less than or equal to) the
        // parameter value or null if no smaller element exists
        System.out.println("Using floor with values (1, 10, 20, 50, 51): "
                + treeSet.floor(1) + " of 1, "
                + treeSet.floor(10) + " of 10, "
                + treeSet.floor(25) + " of 25, "
                + treeSet.floor(50) + " of 50, "
                + treeSet.floor(51) + " of 51 ");

        // ceiling returns the least element >= (greater than or equal to)
        // the parameter value or null if no greater element exists
        System.out.println("Using ceiling with values (1, 10, 20, 50, 51) : "
                + treeSet.ceiling(1) + " of 1, "
                + treeSet.ceiling(10) + " of 10, "
                + treeSet.ceiling(25) + " of 25, "
                + treeSet.ceiling(50) + " of 50, "
                + treeSet.ceiling(51) + " of 51 ");

    }
}