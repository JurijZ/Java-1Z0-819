class LambdaExample3 {
    // static field
    private static int staticInt = 50;

    // instance field
    private int instanceInt;

    LambdaExample3(int instanceInt) {
        this.instanceInt = instanceInt;
    }

    public static void main(String[] args) {
        // These examples show how lambda interacts with the external variables
        LambdaExample3 lambdaExample = new LambdaExample3(100);

        // Lambda expression uses static field in expression
        Runnable r2 = (a) -> a + LambdaExample3.staticInt++; // Lambda changes the state of the staticInt
        lambdaExample.doSomething("Example 2", r2, 5);
        lambdaExample.doSomething("Example 3", r2, 5);

        // Lambda expression uses instance field in expression
        Runnable r3 = (a) -> a + lambdaExample.instanceInt++;
        lambdaExample.doSomething("Example 4", r3, 5);
        lambdaExample.doSomething("Example 5", r3, 5);

        // Lambda expression uses local variable in expression
        int i = 10;
        Runnable r4 = (a) -> a + i;
        lambdaExample.doSomething("Example 6", r4, 5);

        int k = 0;
        int j = 20;
        Runnable r5 = (instanceInt) -> instanceInt + k + 1;
        lambdaExample.doSomething("Example 7", r5, j);
    }

    // Executes and prints Runnable.
    private void doSomething(String s, Runnable r, int a) {
        System.out.println(s + " : r.run(a) = " + r.run(a));
    }
}

interface Runnable {
    public int run(int a);
}