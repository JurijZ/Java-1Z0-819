class Scratch {
    public static void main(String[] args) {
        A a = new A();
        a.Do(); // A more specific implementation will be chosen
        a.Method();
    }
}

// We both extend a base class and implement an interface
class A implements DoableFirst, DoableSecond{
    // If we still want to call the first doable then we can do this.
    // Here we are creating an anonymous class of type DoableFirst and calling it's default method
    public void Method(){
        new DoableFirst(){}.Do();
    }
}

interface DoableSecond extends DoableFirst{
    default void Do(){
        System.out.println("Implementation of Do() in DoableSecond");
    };
}

interface DoableFirst{
    default void Do(){ System.out.println("Implementation of Do() in DoableFirst"); };
}