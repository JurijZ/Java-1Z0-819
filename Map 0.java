import java.util.*;

class Scratch {
    public static void main(String[] args) {
        // Create an ArrayList
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "T");
        map.put(2, "E");
        map.put(3, null);
        System.out.println("After put: " + map);

        // Lets compare put and compute
        map.put(1, "T1"); // Exact value
        System.out.println("After put overwrite: " + map);

        map.compute(1, (k, v) -> v.substring(0, 1)); // the BiFunction is used
        System.out.println("After compute: " + map);

        map.putIfAbsent(5, "5"); // the exact value is provided
        System.out.println("After putIfAbsent: " + map);

        map.computeIfAbsent(4, (k) -> "4"); // the Function is used, only one variable is here and it's a key
        System.out.println("After computeIfAbsent: " + map);

        map.computeIfPresent(5, (k, v) -> "K"); // only if the Key is present the lambda will be executed
        System.out.println("After computeIfPresent: " + map);

        //map.putIfPresent(5, "K"); // there is no such method
    }
}
