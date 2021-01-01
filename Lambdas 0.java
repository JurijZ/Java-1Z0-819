class Scratch {
    public static void main(String[] args) {
        // Several ways to invoke doIt() method from the functional interface Doable

        // First I implement Doable interface
        Doable d = new Doable() {
            public void doIt() {
                System.out.println("doIt() implementation by the Anonymous class");
            }
        };

        // And then I pass it to the execute method
        execute(d);

        // But with lambdas we can do it inline because Doable is a functional interface
        execute(() -> System.out.println("doIt() implementation by the Lambda"));
    }

    public static void execute(Doable d){
        d.doIt();
    }
}

// package-private functional interface with Single-Abstract-Method
interface Doable {
    void doIt();
}
