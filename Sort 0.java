import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class C implements Comparable<C>{
    public Integer P1;
    C(Integer p1){
        P1 = p1;
    }

    // Deep copy constructor
    C(C c){
        this(c.P1); // Using normal constructor
    }

    public static void main(String[] args) {
        // How to sort a list without modifying the original one?
        System.out.println("--------------------------------------------");

        // A list of primitives
        List<String> primitiveOriginal = new ArrayList<String>();
        primitiveOriginal.add("A"); primitiveOriginal.add("Z"); primitiveOriginal.add("C");
        System.out.println("primitiveOriginal: " + primitiveOriginal);

        var primitiveCopy = new ArrayList(primitiveOriginal);
        primitiveCopy.sort(Comparator.reverseOrder());
        System.out.println("primitiveCopy reverse: " + primitiveCopy);

        primitiveCopy.set(1, "K");
        primitiveCopy.remove(0);
        System.out.println("primitiveOriginal after copy modification: " + primitiveOriginal);
        System.out.println("primitiveCopy after copy modification: " + primitiveCopy);

        System.out.println("============================================");

        // A list of objects has a slightly different behaviour
        List<C> objectsOriginal = new ArrayList<C>();
        objectsOriginal.add(new C(1)); objectsOriginal.add(new C(7)); objectsOriginal.add(new C(3));
        System.out.println("objectsOriginal: " + objectsOriginal);

        var objectsCopy = new ArrayList<C>(objectsOriginal);
        objectsCopy.sort(Comparator.reverseOrder());
        System.out.println("objectsCopy reverse: " + objectsCopy);

        // But note a very interesting thing - elements of the copy list have the same reference as the elements in the the original list
        // This means that if we change the property inside the element then it will be seen in both lists
        objectsCopy.forEach(e -> e.P1 = 5);

        // But if we remove the element it will be removed only from one list, because it's really a reference
        objectsCopy.remove(0);
        System.out.println("objectsOriginal after copy modification: " + objectsOriginal);
        System.out.println("objectsCopy after copy modification: " + objectsCopy);


        System.out.println("============================================");
        List<C> objectsOriginal2 = new ArrayList<C>();
        objectsOriginal2.add(new C(1)); objectsOriginal2.add(new C(8)); objectsOriginal2.add(new C(3));
        System.out.println("objectsOriginal: " + objectsOriginal2);

        // To create a deep copy we need to create a fresh new object with its own memory space out of each source object
        // To create a new ordered list, totally detached from the original one we can use stream api
        // map is the place where new object creation happens
        // Notice that we need a deep copy constructor to do this
        List<C> objectSorted = objectsOriginal2.stream().map(C -> new C(C)).sorted().collect(Collectors.toList());
        System.out.println("objectSorted: " + objectSorted);

        // Modify copied list
        objectSorted.forEach(e -> e.P1++);
        System.out.println("objectsOriginal after copy modification: " + objectsOriginal2);
        System.out.println("objectSorted after copy modification: " + objectSorted);
    }

    @Override
    public String toString() {
        return P1.toString();
    }

    @Override
    public int compareTo(C c){
         int v = 0;
        v = this.P1 > c.P1 ? 1 : -1;
        return v;
    }
}
