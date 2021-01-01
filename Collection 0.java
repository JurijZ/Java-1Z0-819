import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Scratch {
    public static void main(String[] args) {
        // Create an ArrayList
        List<String> list = new ArrayList<>(
                List.of("Anne", "Barry", "Charles", "David", "Edward")
        );

        System.out.println("Original list: " + list);

        // You'll note that add does not return a boolean.
        list.add(0, "Arnold");

        System.out.println("After adding Arnold at index 0 :" +
                " : " + list);

        System.out.println("After adding another list of 2 elements at index 0 : " +
                list.addAll(0, List.of("Aaron", "Able")) + " : " + list);

        System.out.println("Setting name at index 2 : " +
                list.set(2, "Annette") + " : " + list);

        System.out.println("Arnold can not be found at : " +
                list.indexOf("Arnold"));

        System.out.println("Annette can be found at : " +
                list.indexOf("Annette"));

        list.add(0, "David");
        System.out.println("After adding David at index 0 :" +
                " : " + list);

        System.out.println("The last David can be found at index : " +
                list.lastIndexOf("David"));
    }
}
