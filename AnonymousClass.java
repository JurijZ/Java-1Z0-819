class Scratch {
    public static void main(String[] args) {
        var c = new OuterClass();
        System.out.println(c.NormalMethod());
        System.out.println(c.NormalMethod2());
    }
}

// Anonymous class still needs a class to be modeled on, It can be an Abstract class or an Interface
abstract class AbstractClass{
    public abstract int MyMethod();
}

class OuterClass {
    int a = 5;
    public int NormalMethod(){
        // Define anonymous class (it combines declaration and initialization)
        // It actually looks like we are instantiating an abstract class that we know we cannot do.
        AbstractClass c = new AbstractClass(){
            //Class body
            int x = 1;

            public int MyMethod(){ return x; }
            // We can declare methods that are not part of the Abstract or Interface definition but they are not visible from outside
            public int MyMethod2(){ return x; }
        }; // Semicolon is needed here

        //return c.MyMethod(); // Only declared type methods can be used from outside
        return c.MyMethod();
    }

    public String NormalMethod2(){
        // Here we can see that anonymous class can extend any class. We simply need to have some methods in the base class to override.
        Object c = new Object(){
            public String toString(){ return "text"; }
        };

        return c.toString();
    }
}