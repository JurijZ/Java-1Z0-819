import java.util.*;

class Scratch {
    public static void main(String[] args) {
        // Immutable
        Map<String, Integer> immutableMap = Map.of("Mary",30,"John",35,"Ralph",23);
        //m.put("Tom", 30); // UnsupportedOperationException
        System.out.println(immutableMap);

        // Lets make it mutable (Order created)
        Map<String, Integer> treeMapMutable = new TreeMap<>( immutableMap );
        treeMapMutable.put("Tom", 30);
        System.out.println(treeMapMutable);

        // Lets make it immutable again
        Map<String, Integer> immutableMap2 = Map.copyOf(treeMapMutable);
        //m1.put("George",15); // UnsupportedOperationException
        System.out.println(immutableMap2);

        // Lets make it mutable again (Order created)
        Map<String, Integer> treeMapMutable2 = new TreeMap<>( immutableMap2 );
        treeMapMutable2.put("George",15);
        System.out.println(treeMapMutable2);
    }
}
