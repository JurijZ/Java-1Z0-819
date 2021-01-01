import java.util.List;

class Scratch {
    public static void main(String[] args) {

        // We know that if the C2 is a child of C1 then it does not mean that List<C2> is a child of List<C1>
        // But we also know that raw List can take anything, therefore this works:
        List integerList1 = List.<Integer>of(5, 10, 15);
        printObjectList(integerList1);
        // Note - By using raw List we loose the compiler type check assistance

        // Note - you can always cast a generic type to a raw type!!!
        // We can rewrite the above like that:
        List<Integer> integerList2 = List.<Integer>of(5, 10, 15);
        List rawList = integerList2;
        printObjectList(rawList);

        // but this does not
        List<Integer> integerList3 = List.<Integer>of(5, 10, 15);
        //printObjectList(integerList3); // Incompatible types compile error. List<Integer> is not List<Number>

        //---------------------------------------
        // Now, although we can assign anything to the raw List and it will compile successfully,
        // it does not mean that it will always work in runtime
        List rawList2 = List.<Integer>of(5, 10, 15);
        printUpperList(rawList2); // There is no compilation error here, but there will be an error at runtime

        // Reminder - List is an interface, ArrayList is a class.
    }

    public static void printObjectList(List<Number> list) {
        System.out.println("----- List made up of numbers ------");
        list.forEach((s) -> System.out.println(s));
    }

    // Method prints elements in a list, restricted to Exception
    // elements and any of its subclasses
    public static void printUpperList(List<? extends Exception> list) {
        // when using an upper bound, able to use specific methods and
        // attributes on the specified type
        System.out.println("----- Using upper bound ------");
        list.forEach((s) -> System.out.println(s.getLocalizedMessage()));
    }
}