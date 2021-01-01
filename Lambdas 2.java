class Scratch {
    private static void method() {
        System.out.println("First Method executing");
    }
    private static int method2() {
        System.out.println("Second Method executing");
        return 1;
    }
    public static void main(String[] args) {
        //Note - none of the bellow valid declaration actually execute the code

        // Void method, any statement will work
        Showable s1 = () -> System.out.println("Doing something");

        // Expanded body, enclosed in {}
        Showable s2 = () -> {
            String s = "Doing something";
            System.out.println(s);
            return;  // This return is ok because method is void
        };

        // You can call a method as long as return type matches abstract method.
        Showable s3 = () -> method();

        // You can execute a method with return type even with an abstract method that is declared void
        Showable s4 = () -> method2();

        // You can use a method reference in place of lambda expression
        Showable s5 = Scratch::method2;

        // Cannot omit parameter section altogether, () required if method
//        // has no parameters
//        Showable b1 = ->System.out.println("Do this");
//
//        // This expression 'returns a String' but method is void
//        Showable b2 = () ->  "hello";
    }
}

interface Showable {
    void showIt();
}