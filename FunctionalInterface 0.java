class Scratch {
    public static void main(String[] args) {
        // Anonymous class implements Doable interface
        Doable d = new Doable() {
            public void doIt() {
                System.out.println("Anonymous class invoking doIt()");
            }
        };

        // Lambda Expression is assigned to a ExtendedDoable local variable
        ExtendedDoable1 d1 = () -> System.out.println("Executed by the inherited DoIt()");

        // Lambda Expression is assigned to a ExtendedDoable local variable
        ExtendedDoable2 d2 = () -> System.out.println("Executed by extendedDoIt()");

        d.doIt(); // This invokes functional interface method defined in the Doable interface
        d1.doIt(); // This invokes inherited functional interface method defined in the Doable interface
        d2.doIt(); // This invokes default method defined inside ExtendedDoable2 interface
        d2.extendedDoIt(); // This invokes functional interface method
    }
}

// package-private functional interface with Single-Abstract-Method
interface Doable {
    void doIt();
}

// Extends interface (not implements the interface). ExtendedDoable1 is still a functional interface
interface ExtendedDoable1 extends Doable {
}

// Extending interfaces with its own implementations
interface ExtendedDoable2 extends Doable {
    // I'm overwriting inherited method, but because it's marked as default it's no longer a functional interface method
    default void doIt() {
        System.out.println("Executed by the default doIt()");
    }

    // Now this method turns into a functional interface method
    void extendedDoIt();
}