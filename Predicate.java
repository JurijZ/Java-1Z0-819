import java.util.function.Predicate;

class Scratch {
    public static void main(String[] args) {
        // A usage of BuiltIn language functional interface - Predicate

        // Long notation
        Predicate<String> p1 = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.equals("Test");
            }
        };
        boolean b1 = p1.test("Test1"); // predicate usage
        System.out.println(b1);

        // Lambda notation
        Predicate<String> p11 = s -> s.equals("Test"); //Implements functional interface method - test()
        System.out.println(p11.test("Test1"));

    }
}
