import java.util.ArrayList;
import java.util.List;

class A {}
class B extends A {}
class C extends B {}
class D extends C {}
class Scratch {
    public static void main(String[] args) {
        System.out.println("test");

        // COVARIANCE - you can safely READ items from a structure,
        // but you cannot write anything into it, hence type safety would not be ensured by the compiler/runtime
        List<C> l0 = new ArrayList<C>();
        //l0.add(new A()); //error
        //l0.add(new B()); //error
        l0.add(new C());
        l0.add(new D());

        List<? extends B> l2 = l0;
        //l2.add(new B()); //error, you are not allowed to write into the list anymore
        A a = l2.get(0);
        B b = l2.get(0);
        //C c = l2.get(0); //incompatible type error
        //D d = l2.get(0); //incompatible type error

        List<? extends A> l3 = l0;
        A a2 = l2.get(0);
        B b2 = l2.get(0);

        //List<? extends C> l4 = l0; //incompatible type error


        // CONTRAVARIANCE - you allow to WRITE anything into a generic structure,
        // but as a result you cannot safely read from it hence the compiler does not know what type may come out.
        List<? super B> l5 = new ArrayList<A>();
        //l5.add(new A()); //error
        l5.add(new B());

        List<? super B> l1 = new ArrayList<B>();
        //l1.add(new A()); //error
        l1.add(new B());
        l1.add(new C());
        l1.add(new D());

        //List<? super B> l6 = new ArrayList<C>(); // error incompatible types

        Object o = l1.get(0);
        //A b4 = l1.get(0); //incompatible types error
        //B b = l1.get(0); //incompatible types error
        //C c = l1.get(0); //incompatible types error
        //D d = l1.get(0); //incompatible types error
        B b1 = (B)l1.get(0);
        //C c1 = (C)l1.get(0); //Exception - class B cannot be cast to class C
        //D d1 = (D)l1.get(0); //Exception - class B cannot be cast to class D
    }
}

