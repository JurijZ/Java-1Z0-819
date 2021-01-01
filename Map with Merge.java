import java.util.LinkedHashMap;
import java.util.Map;

class Test {
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Ralph", 55);

        // merge(key, value, BiFunction),
        // where function having two arguments: old value and given value
        map.merge("Ralph", 1, Test::mergeFunction);
        map.merge("Ros", 56, Test::mergeFunction);
        System.out.println(map);
    }

    static Integer mergeFunction(Integer i1, Integer i2) {
        if (i2 < 55) return null; // returning null as a value will remove the key
        return i1 + i2;
    }
}