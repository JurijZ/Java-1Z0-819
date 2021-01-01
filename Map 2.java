import java.util.*;

class Scratch {
    public static void main(String[] args) {
        // Create an ArrayList
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, null);
        System.out.println("After put:              " + map);

        map.replace(1, "C");
        System.out.println("After replace in key 1: " + map);

        map.replace(2, "B", "D"); // Changes the value because old value match
        System.out.println("After replace in key 2: " + map);

        map.replace(2, "G", "K"); // Does not change anything because the old value does not match
        System.out.println("After replace in key 2: " + map);

        map.remove(3); // Removes by key
        System.out.println("After replace in key 2: " + map);

        map.remove(2, "G"); // Does not removes because both key and value must match
        System.out.println("After replace in key 2: " + map);

        map.remove(2, "D"); // Removes successfully because both key and value match
        System.out.println("After replace in key 2: " + map);
    }
}
