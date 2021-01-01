import java.util.*;

class Scratch {
    public static void main(String[] args) {
        // Create an ArrayList
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "T");
        map.put(2, "E");
        map.put(3, null);
        System.out.println("After put: " + map);

        // compute and put do return. It's a Value that was added or existed
        var r = map.put(1, "T1"); // returns previous value
        System.out.println("put return: " + r);

        var r1 = map.compute(1, (k, v) -> v.substring(0, 1) + "3"); // returns new value
        System.out.println("compute return: " + r1);

        var r2 = map.putIfAbsent(5, "Value1"); // returns null if the key did not exist and creates a new key/value
        System.out.println("After putIfAbsent: " + map);
        System.out.println("putIfAbsent returns: " + r2);

        var r3 = map.putIfAbsent(5, "Value5"); // returns current value and does not overwrite with the new one
        System.out.println("After putIfAbsent: " + map);
        System.out.println("putIfAbsent returns: " + r3);

        var r4 = map.computeIfAbsent(6, (k) -> "6"); // returns new value and creates a new key/value
        System.out.println("After computeIfAbsent: " + map);
        System.out.println("After computeIfAbsent: " + r4);

        var r5 = map.computeIfAbsent(6, (k) -> "7"); // returns exiting value and does not overwrite wi the new one
        System.out.println("After computeIfAbsent: " + map);
        System.out.println("After computeIfAbsent: " + r5);

        //map.putIfPresent(5, "K"); // there is no such method

        var r6 = map.computeIfPresent(6, (k, v) -> "K"); // returns new value and overwrites the old one
        System.out.println("After computeIfPresent: " + map);
        System.out.println("After computeIfPresent: " + r6);

        var r7 = map.computeIfPresent(7, (k, v) -> "7"); // returns null and does not create a new key/value
        System.out.println("After computeIfPresent: " + map);
        System.out.println("After computeIfPresent: " + r7);
    }
}
