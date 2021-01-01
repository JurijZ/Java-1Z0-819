import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Scratch {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("Force Awakens");
        myList.add("Star Wars");
        myList.add("Empire Strikes Back");


        // There are some built in Comarator's (we don't necessary have to implement one ourself)
        System.out.println("---------------Reverse----------------");
        myList.sort(Comparator.reverseOrder());
        myList.forEach(System.out::println);

        System.out.println("---------------Natural----------------");
        myList.sort(Comparator.naturalOrder());
        myList.forEach(System.out::println);


        // Adding null to the list of strings will fire up a NullPointerException if use the built in Comparator
        System.out.println("---------------Sort with Null----------------");
        myList.add(null);
        myList.add(null);
        //myList.sort(Comparator.reverseOrder()); //NullPointerException

        // To support a null value we can implement our own Comparator that handles null comparison or use this notation
        // Comparator.nullsFirst() and Comparator.nullsLast()
        Comparator.nullsLast(Comparator.nullsLast(Comparator.naturalOrder()));
        myList.forEach(System.out::println);
    }
}
