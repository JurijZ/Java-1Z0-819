import java.util.function.Predicate;

class Scratch {
    public static void main(String[] args) {
        // Regular predicate
        Predicate<String> p = s -> s.equals("Test"); //Implements functional interface method - test()
        System.out.println( p.test("Test1"));

        // Predicate comes with built in functions
        // NEGATE
        Predicate<String> p1 = p.negate();
        System.out.println( p1.test("Test1"));

        // OR
        Predicate<Integer> p21 = i -> i < 10;
        Predicate<Integer> p22 = i -> i > -10;
        Predicate<Integer> p2 = p21.or(p22);
        System.out.println( "Is Integer 5 between -10 and 10: " + p2.test(5));
        System.out.println( "Is Integer -15 between -10 and 10: " + p2.test(-15));

        // AND
        boolean b1 = p21.and(p22).test(5);
        System.out.println( "Is Integer 5 between -10 and 10: " + b1);

        // ISEQUAL and NOT (static methods)
        boolean b2 = Predicate.not(Predicate.isEqual("Hello")).test("Hello");
        System.out.println( "Negation of equality check: " + b2);
    }
}
