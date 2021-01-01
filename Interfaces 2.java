class Scratch {
    public static void main(String[] args) {
        A a = new A();
        a.Do();
        a.DoFromFirst();
        a.DoFromSecond();
    }
}

class A implements DoableFirst, DoableSecond{
    // When there is a clash of default methods then compiler does not know which one to use.
    // In this case we must override the method, and it must be public
    public void Do(){
        System.out.println("Implementation of Do() in A");
    }

    // If we want to use the default implementations then we must use "DoableFirst.super.Do()" notation
    public void DoFromFirst() { DoableFirst.super.Do();}
    public void DoFromSecond() { DoableSecond.super.Do();}
}

interface DoableSecond{
    default void Do(){
        System.out.println("Implementation of Do() in DoableSecond");
    };
}

interface DoableFirst{
    default void Do(){ Print();};

    // Java interface allows to have private methods
    private void Print(){
        System.out.println("Implementation of Do() in DoableFirst");
    }
}