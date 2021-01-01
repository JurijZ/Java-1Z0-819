class Scratch {
    public static void main(String[] args) {
        A a = new A();
        a.Do();

        // This example shows the case when the Super class method name matches the default interface method name
        a.Undo(); // Super class method is used. It takes precedence over the Interface
        a.CallUndoFromB(); // Same super class method call just via an internal function
        a.CallUndoFromDoable(); // Calling interfaces implementation of the Undo requires reference
    }
}

// We both extend a base class and implement an interface
class A extends B implements Doable{
    // We can override the default method if we wan to
    public void Do(){
        System.out.println("Implementation of Do() in A");
    }

    public void CallUndoFromB(){
        // To call a method from the super class you can use the keyword super
        super.Undo();
    }

    public void CallUndoFromDoable(){
        // If you want to make this with a super interface it's required to name it explicitly
        Doable.super.Undo();
    }
}

class B {
    public void Undo(){
        System.out.println("Implementation of Undo() in B");
    }
}

interface Doable{
    void Do();
    default void Undo(){
        System.out.println("Implementation of Undo() in Doable");
    };
}