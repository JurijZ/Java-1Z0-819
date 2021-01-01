class Scratch {
    public static void main(String[] args) {
        C c = new C();
        c.method1();
        c.method2();

        I2 c1 = new C();
        c1.method1();
        c1.method2();
    }
}

interface I1{
    public void method1();
}
// One interface inherites from another interface
interface I2 extends I1{
    public void method2();
}
// Class must implement both interfaces
class C implements I2{
    public void method1(){System.out.println("Executed method1()");}
    public void method2(){System.out.println("Executed method2()");}
}