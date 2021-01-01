import java.util.ArrayList;
import java.util.List;

class Scratch {
    public static void main(String[] args) {
        // https://www.youtube.com/watch?v=KpxOKRV3ycs

        List<Number> l = new ArrayList<Number>();
        //List<?> l = new ArrayList<Number>(); // You will not be able both write and ready type safely
        //List<? extends Number> l = new ArrayList<Number>(); // Compiler will not allow tp write into the list anymore, but we can always take Number out
        //List<? super Number> l = new ArrayList<Number>(); // You will not be able to read type safely without casting, but you can put whatever you want into it

        l.add(5);
        Number n = l.get(0);
        System.out.println(n);

        // Question - If you can't write into a list defined as List<? extends Number> then what is the point?
        // Answer - This notation can be used to restrict writing into a list after it was populated
        methodThatOnlyAllowsToRead(l);

    }

    static void methodThatOnlyAllowsToRead(List<? extends Number> numbers) {
        System.out.println(numbers.get(0));
        //numbers.add(5); // Adding is not allowed
    }

    void methodThatOnlyAllowsToAdd(List<? super Number> numbers) {
        numbers.add(5);
        //Number c = numbers.get(0); // Safe reading is not allowed
        Number c = (Number)numbers.get(0); // but you can still cast by force
    }
}
