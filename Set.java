import java.util.LinkedHashSet;
import java.util.List;

class Scratch {
    public static void main(String[] args) {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.addAll(List.of("Dog", "Cat", "Gerbil", "Hamster"));

        // retainAll does not add anything to the set only retains what already exists
        set.retainAll(List.of("Goat", "Cat", "Hamster"));

        set.addAll(List.of("Cat", "Gerbil"));
        System.out.println(set);
    }
}