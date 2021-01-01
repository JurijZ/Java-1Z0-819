import java.util.ArrayList;
import java.util.List;

class Scratch {
    public static void main(String[] args) {
        // This is a dangerous notation because the variable is a raw List
        // so it can take any data type. Compiler type check is not performed
        List numberList = new ArrayList<Integer>();
        numberList.add(2);
        numberList.add("string");
        numberList.add(4.6f);
        numberList.add(List.of('a','b'));


        // List<?> - the ?, or unbounded wildcard, means that the type of the object is not specified
        List<?> numberList2 = new ArrayList<Integer>(); // No compiler error here, but
        //numberList2.add(5); // Compiler error - incompatible types: int cannot be converted to capture#1 of ?

        List<? extends Number> numberList3 = new ArrayList<Integer>(); // No compiler error here, but
        //numberList3.add(5); // Compiler error - incompatible types: int cannot be converted to capture#1 of ? extends java.lang.Number

        List<? super Integer> numberList4 = new ArrayList<Integer>();
        numberList4.add(5);
        numberList4.add((int) 10L);
        //numberList4.add((Integer) 10L); //incompatible types: long cannot be converted to java.lang.Integer
    }
}