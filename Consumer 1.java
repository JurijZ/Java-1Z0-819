import java.util.function.Consumer;
import java.util.function.Predicate;

class Scratch {
    int id;

    Scratch(int id) {
        this.id = id;
    }

    public String toString() {
        return "Product " + id;
    }

    public static void main(String[] args) {
        // This example shows that lambda expression has access to the scope variables
        // and retains reference created at the tie of declaration (it's like a closure)
        Scratch scratch = new Scratch(1);

        Consumer<Scratch> consumer = s -> System.out.println(scratch.id);
        consumer.accept(new Scratch(2)); // this new object is not being used in the lambda
    }
}
