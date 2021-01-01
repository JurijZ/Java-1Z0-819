class Scratch {
    public static void main(String[] args) {
        A a = new A();
        a.Do();
        a.M();
    }
}

class A implements DoableFirst{
    // This example shows that it is possible to access a public static method of the interface
    public void M(){
        // The public static method was not inherited by the class A, but can be accessed via the interface name.
        DoableFirst.PublicStaticInterfaceMethod();
    }
}

interface DoableFirst{

    // Java interface can have static methods
    public static void PublicStaticInterfaceMethod(){
        System.out.println("PublicStaticInterfaceMethod method");
    }
    private static void PrivateStaticInterfaceMethod(){
        System.out.println("PrivateStaticInterfaceMethod method");
    }

    default void Do(){
        // Static methods are available in the none static interface methods
        PublicStaticInterfaceMethod();
        PrivateStaticInterfaceMethod();
    };
}