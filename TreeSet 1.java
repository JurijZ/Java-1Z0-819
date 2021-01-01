import java.util.*;

class Scratch {
    public static void main(String[] args) {
        // Create a List of objects
        List<TreeElement> setTestData = List.of( new TreeElement(2, "Sam"), new TreeElement(5, "Carol"),
                new TreeElement(1, "Tim"),new TreeElement(10, "Marry"));

        // TreeSet is an ordered structure
        // Here a Comparable implementation is used under the hood, compareTo method which is by Id (ascending by id).
        TreeSet<TreeElement> treeSet0 = new TreeSet<>(setTestData);
        System.out.println("---- TreeSet ordered by Comparable implementation----");
        treeSet0.forEach(System.out::println);

        // But we can pass an object that implements Comparator and change the order, compare method (descending by name)
        // Here I'm passing an instance of a class. Internal values does not really matters, we only need the implementation of the compare method.
        TreeSet<TreeElement> treeSet1 = new TreeSet<>(new TreeElement(0, ""));
        treeSet1.addAll(setTestData);
        System.out.println("---- TreeSet ordered by Comparator implementation in the class ----");
        treeSet1.forEach(System.out::println);

        // Or we can pass a Comparator implementation based on the function (ascending by name)
        TreeSet<TreeElement> treeSet2 = new TreeSet<>(Comparator.comparing(TreeElement::getValue));
        treeSet2.addAll(setTestData);
        System.out.println("---- TreeSet ordered by Comparator.comparing() ----");
        treeSet2.forEach(System.out::println);
    }
}

class TreeElement implements Comparable<TreeElement>, Comparator<TreeElement> {

    private int id;
    private String value;

    // Constructor
    public TreeElement(int id, String value) {
        this.id = id;
        this.value = value;
    }

    // overriding Comparable.compareTo
    public int compareTo(TreeElement o) {
        // "Natural Order" = sorted by id ascending
        return this.id - o.id;
    }

    // overriding Comparator.compare
    public int compare(TreeElement o1, TreeElement o2) {
        // Order by value - descending, assume for now value is not null
        return o2.value.compareToIgnoreCase(o1.value);
    }

    public String toString() {
        return "{" +"id=" + id +", value='" + value + '\'' +'}';
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}