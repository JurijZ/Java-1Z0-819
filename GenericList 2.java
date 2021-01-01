import java.util.List;

class Scratch {
    public static void main(String[] args) {

        // Here we demonstrate that overloading of a generic Lists does not work
        // This is because of the ERASURE mechanics

        // The rule - Java compiler replaces all type parameters in generic types with their BOUNDS
        // or Object if the type parameters are unbounded.
        // The produced bytecode, therefore, contains only ordinary classes, interfaces, and methods.

        // Exception is the same bound in both methods
    }

    public static void printList(List<? extends Exception> list) {
        list.forEach((s) -> System.out.println(s));
    }

    public static void printList(List<? super Exception> list) {
        list.forEach((s) -> System.out.println(s));
    }
}