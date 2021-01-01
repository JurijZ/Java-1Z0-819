class Scratch {
    public static void main(String[] args) {
        var c = new OuterClass();
        System.out.println(c.NormalMethod());
    }
}

abstract class C1{
    int x;
}

// Abstract class can have a constructor
abstract class C2 extends C1{
    C2(int x){
        this.x = x;
    }
}

class OuterClass {
    public int NormalMethod(){
        // We initialize an anonymous class using an abstract class with constructor
        // This way we can pass parameters to the anonymous class
        C1 c = new C2(10){
            // Anonymous class itself cannot have a constructor, but it can have an instance initializer
            // this notation is called 'instance initializer'
            {
                x = this.x + 10;
            }
        };
        return c.x;
    }
}