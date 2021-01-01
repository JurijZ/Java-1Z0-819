class LambdaExample3 {
    public static void main(String[] args) {
        // These examples show how lambda wrapping into another function
        int j = 20;
        doSomething("Example 1", j++);
        doSomething("Example 2", j++);
    }

    // Executes and prints Runnable.
    private static void doSomething(String s, Runnable r, int a) {
        System.out.println(s + " : r.run(a) = " + r.run(a));
    }

    // Runnable created in the method uses parameter value in its lambda expression
    private static void doSomething(String s, int b) {
        // Lambda expression uses method parameter of enclosing method in its expression
        Runnable r = (a) -> a + b + 1;
        doSomething(s, r, 5);
    }
}

interface Runnable {
    public int run(int a);
}