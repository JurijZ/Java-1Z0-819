class Scratch {
    boolean instance_b; // default value is false
    Boolean instance_B; // default value is null

    public static void main(String[] args) {

        Scratch s = new Scratch();

        //Boolean B; // Assignment is required when used in the method
        //boolean b; // Assignment is required when used in the method

        Boxingboolean(s.instance_b); // Shows that instance_b is false by default

        UnboxingBoolean(s.instance_B); // Shows that instance_B is null by default
    }

    public static void Boxingboolean(boolean b){
        Boolean B = b; // Boxing
        System.out.println(B);
    }

    public static void UnboxingBoolean(Boolean B){
        boolean b = B; // Unboxing generates a NullPointerException if B is null
    }
}

