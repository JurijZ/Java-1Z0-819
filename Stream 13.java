import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Random;

class Pet{
    public String Name;
    public String getName() {return Name;};
    public int Age;
    public int getAge() {return Age;};

    Pet (){
        this.Name = "Dog" + (new Random().nextInt(5) + 1);
        this.Age = new Random().nextInt(5) + 1;
    }

    public static void main(String[] args) {
        // PARTITIONING examples
        // partitioningBy will always return a map with two entries,
        // one for where the predicate is true and one for where it is false.

        // Create a randomly generated list of 5000 pets.
        List<Pet> petPopulation = Stream.generate(Pet::new)
                .limit(5000)
                .collect(Collectors.toList());

        // Here we split the original dataset into two groups, one false and the other true based on the predicate
        var petMaps = petPopulation.stream()
                .collect(Collectors.partitioningBy(s -> s.Name.equals("Dog3")));

        // There are only 2 entries in the petMaps, true=List<Pet> and false=List<Pet>
        // Lets take only the group where key is true
        petMaps.entrySet().stream()
                .filter(s -> s.getKey() == true) // take only where key is true
                // we use flatMap() instead of map(), because we don't want to have a Stream of Stream<Pet>
                .flatMap(s-> s.getValue().stream()) // we take only value, that is List<Pet>
                .limit(5)
                .forEach(s -> System.out.println(s.Name + " " + s.Age));
    }
}
