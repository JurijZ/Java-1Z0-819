import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Scratch {
    public static void main(String[] args) {
        // Note that Person class does not implement Comparator or Comparable interfaces
        List<Person> people = new ArrayList<>(List.of(new Person("George", "Ball"),
                new Person("Cathy", "Hart"),
                new Person("Anne", "Ball"),
                new Person("Marty", "Hart")));

        // sort in a multi-dimensional way, using methods (getters here)
        // chaining the static methods on Comparator
        // here comparing static function accepts a SORT KEY
        people.sort(
                Comparator.comparing(Person::getLastName)
                          .thenComparing(Comparator.comparing(Person::getFirstName)));

        people.forEach(System.out::println);
    }
}

class Person {
    private String firstName;
    private String lastName;

    // Constructor takes both arguments
    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // toString method
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
