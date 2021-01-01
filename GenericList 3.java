import java.util.ArrayList;
import java.util.List;

class Scratch {
    public static void main(String[] args) {

        ArrayList<Integer> intArray = new ArrayList<>();
        M1(intArray); // an argument of type List<Number> will not accept List<Integer>

        ArrayList<? extends Number> numArray = new ArrayList<>();
        M1(numArray); // an argument of type List<Number> will not accept List<? extends Number>

        ArrayList<Number> numArray2 = (ArrayList<Number>)numArray;
        M1(numArray2); // can still be solved with casting
    }

    public static void M1(ArrayList<Number> list) {
        list.forEach((s) -> System.out.println(s));
    }
}