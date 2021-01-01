class Scratch {
    public static void main(String[] args) {

        var c = new MyClass();

        // Here I can still change the property value even though the prop2 is final
        c.prop2.prop = "text3";

        System.out.println(c.prop1);
        System.out.println(c.prop2.prop);
    }
}

class MyClass{
    final public int prop1;
    final public MyClass2 prop2;

    MyClass()
    {
        prop1 = 1;
        prop2 = new MyClass2();
    }
}

class MyClass2{
    public String prop;

    MyClass2()
    {
        prop = "text2";
    }
}