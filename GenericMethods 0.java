class Scratch {
    public static void main(String[] args) {
        C c = new C();
        c.Method("text");
        c.Method(5);
        c.Method('t');

        var a1 = c.<Integer>MyEqualsGenericMethod(5, 7);
        System.out.println(a1);
        var a2 = c.<Double>MyEqualsGenericMethod(5.34, 5.34);
        System.out.println(a2);

        var a3 = c.<String>MyEqualsGenericMethod2("5.34", "5.34");
        System.out.println(a3);
    }
}

// A non-generic class with generic method
class C{
    public <U> void Method(U u){
        // Shows the data type of the supplied u
        System.out.println(u.getClass().toString());
    }

//    public <T> T Method2(){
//        T t = new T(); // You cannot instantiate a generic type parameter
//        return t;
//    }

    // Bounded type parameters are key to the implementation of generic algorithms.
    // Generic methods can return non-generic values
    public <T extends Number> boolean MyEqualsGenericMethod(T t1, T t2){
        return t1.equals(t2);
    }

    public <T extends Comparable<T>> int MyEqualsGenericMethod2(T t1, T t2){
        return t1.compareTo(t2); // We can use the methods that are inherited from the parent class
    }
}