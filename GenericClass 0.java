class Scratch {
    public static void main(String[] args) {
        //https://www.youtube.com/watch?v=KpxOKRV3ycs

        C<String> c = new C<String>();
        c.setValue("text");
        String value = c.getValue();
        System.out.println(value);

        C<Integer> c1 = new C<Integer>();
        c1.setValue(5);
        Integer value1 = c1.getValue();
        System.out.println(value1);

        // Do not forget to specify the generic type on the left hand side even though it is defined on the right
        // If not defined then T inside c2 is considered of type Object
        C c2 = new C<Integer>();
        c2.setValue(5);
        Integer value2 = c2.getValue(); // getValue() returns a type of Object, not Integer.

        // Not defining on the right hand side is not a problem, it will be correctly inferred
        C<Integer> c3 = new C<>();
        c3.setValue(5);
        var value3 = c3.getValue(); // getValue() returns a type of Integer.
    }
}

class C<T>{
    T value;

    public T getValue(){
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}