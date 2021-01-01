class Scratch {
    private static int method() {
        System.out.println("Method executing");
        return 1;
    }
    public static void main(String[] args) {
        //Note - none of the bellow valid declaration actually execute the code

        // Do not need to declare types of parameters
        Calculable c1 = (op1, op2) -> op1 + op2;

        // Can declare types of all parameters
        Calculable c2 = (float op1, float op2) -> op1 + op2;

        // Can use LVTI var for all parameters
        Calculable c3 = (var op1, var op2) -> op1 + op2;

        // Example of lambda expression in brackets {}
        Calculable c4 = (op1, op2) -> {
            float f1 = op1;
            float f2 = op2;
            return f1 / f2;  // return required..
        };
        // You can return a primitive data wrapper
        Calculable c5 = (var op1, var op2) -> (op1 + op2);

        // Can return a literal that widens to a float
        Calculable c6 = (op1, op2) -> 1;

        // Can return a primitive data wrapper
        Calculable c7 = (op1, op2) -> Float.valueOf("10");

        // Can return a literal
        Calculable c8 = (op1, op2) -> 10.0f;

        // Can return result from a method call. Note that method has no input parameters!!!
        Calculable c9 = (op1, op2) -> method();


        // All the stuff you can not do.....
        // Cannot autobox/unbox with parameters in a lambda expression
//        Calculable d1 = (Float op1, Float op2) -> op1 + op2;
//
//        // Cannot mix LVTI var with declared types
//        Calculable d2 = (var op1, float op2) -> op1 + op2;
//
//        // Have to either declare types for all parameters or none
//        Calculable d3 = (float op1, op2) -> op1 + op2;
//
//        // single expresson must evaluate to the return type of method,
//        // this returns void.
//        Calculable d4 = (var op1, var op2) -> System.out.println(op1 + op2);

        // No return type specified
//        Calculable d5 = (var op1, var op2) -> {
//            float f1 = op1;
//            float f2 = op2;
//            // return type is required
//        };
//
//        // Wrong amount of parameters
//        Calculable d6 = (var op1) -> 0;
//
//        // Wrong amount of parameters
//        Calculable d7 = () -> 0;
//
//        // Cannot use return statement in single expression, not in brackets {}
//        Calculable d8 = (op1, op2) -> return op1 / op2;
//
//        // Cannot pass constants in the parameter list
//        Calculable d9 = (1, op2) ->1 / op2;

    }

}

interface Calculable {
    float calculate(float operand1, float operand2);
}
