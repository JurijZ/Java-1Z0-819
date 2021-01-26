import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Random;

class S{
    public static void main(String[] args) {
        // DISTINCT
        // Distinct is based on checking equality like this: Object.equals(Object) in the stream

        // When equals method is not implemented - distinct will see all objects as distinct
        System.out.println("--Distinct sees all objects as distinct--");
        Stream.generate(Pet::new)
                .distinct()
                .limit(5)
                .forEach(s -> System.out.println(s.Name));

        // When equals() and hashCode() methods are implemented - distinct will compare based on the logic inside equals()
        System.out.println("--Distinct uses Name to find distinct objects --");
        Stream.generate(Pet2::new)
                .distinct()
                .limit(5)
                .forEach(s -> System.out.println(s.Name));
    }
}

class Pet{
    public String Name;
    public String getName() {return Name;};
    public int Age;
    public int getAge() {return Age;};

    Pet (){
        this.Name = "Dog" + (new Random().nextInt(3) + 1);
        this.Age = new Random().nextInt(3) + 1;
    }
}

class Pet2{
    public String Name;
    public String getName() {return Name;};
    public int Age;
    public int getAge() {return Age;};

    Pet2 (){
        this.Name = "Dog" + (new Random().nextInt(3) + 1);
        this.Age = new Random().nextInt(3) + 1;
    }

    // override equals() and hashCode() of the Element class
    public boolean equals(Object p){
        return getName().equals(((Pet2)p).Name);
    }

    public int hashCode() {
        return Objects.hash(getName());
    }
}
