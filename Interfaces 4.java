class Scratch {
    public static void main(String[] args) {
        C c = new C();
        c.method1();
        c.method2();

        I1 c1 = new C();
        c1.method1();
        //c1.method2(); //method2() is not visible
    }
}

interface I1{
    public void method1();
}
interface I2{
    public void method2();
}
class C implements I1, I2{
    public void method1(){System.out.println("Executed method1()");}
    public void method2(){System.out.println("Executed method2()");}
}