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
        // GROUPING examples

        // Create a randomly generated list of 5000 pets.
        List<Pet> petPopulation = Stream.generate(Pet::new)
                .limit(5000)
                .collect(Collectors.toList());

        System.out.println("-----Group objects by Name-------");
        // Group objects by Name
        var groupPets = petPopulation.stream()
                .collect(Collectors.groupingBy(s -> s.Name));

        System.out.println(groupPets);

        System.out.println("-----Count by Name-------");
        // Count objects in each group
        Map<String, Long> petCounts = petPopulation.stream()
                .collect(Collectors.groupingBy(s -> s.Name,
                                                Collectors.counting()));

        System.out.println(petCounts);

        System.out.println("-----Count by Name v2-------");
        //  Using .groupingBy with 3 arguments - groupBy(Classifier, mapFactory, DownStream)
        // TreeMap is natively sorted, therefore there is not need to sort in the stream additionally
        Map<String, Long> petCounts2 = petPopulation.stream()
                .collect(Collectors.groupingBy(s -> s.Name, // Grouping by Name
                                                TreeMap::new, // Specify Sorted Map
                                                Collectors.counting()));

        System.out.println(petCounts2);

        System.out.println("\n-----Average age by Name-------");
        // Lets get an average age of a Pet type
        Map<String, Double> petMaps = petPopulation.stream()
                .collect(Collectors.groupingBy(s -> s.Name,
                                                Collectors.averagingInt(Pet::getAge)));

        System.out.println(petMaps);
        petMaps.entrySet().stream().forEach(System.out::println);
    }
}
