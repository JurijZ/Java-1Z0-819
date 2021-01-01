class Scratch {
    public static void main(String[] args) {
        // These examples show how Method References work

        // Create local variable, assign lambda expression to it
        // Executing operation passing Interface parameter
        MyInterface i = (s) -> "1.  variable " + s;
        executeInterface(i);

        // Executing operation passing method reference
        executeInterface(new MyClass()::doSomething);

        // Executing operation passing return value (functional interface) of another method
        var v = Scratch.returnInterface();
        executeInterface(Scratch.returnInterface());

        // This is very interesting - if we use :: notation then we make a pointer to the method and not to the return of this method.
        // The method we point at has a completely different signature - "MyInterface returnInterface()"
        // Whereis parameter needs to match the abstract method of the Interface - "String doSomething(String s)"
        // when we are using a method reference – the target reference is placed before the delimiter :: and the name of the method is provided after it.
        var c = Scratch::returnInterface;
        executeInterface(Scratch::returnInterface);
    }

    // Example operation that accepts functional interface as argument
    private static void executeInterface(MyInterface i) {
        System.out.println(i.doSomething("hello"));
    }

    // Returns an interface.
    private static MyInterface returnInterface() {
        MyInterface i = (s) -> "3.  method " + s;
        return i;
    }
}

// Simple Functional Interface
interface MyInterface {
    String doSomething(String s);
}

// It's not mandatory to implement the Functional Interface just the signature must match,
// but it's a very good thing to have it hence this ensures no runtime exceptions
class MyClass implements MyInterface {
    public String doSomething(String s) { return "2.  MyClass " + s; }
}