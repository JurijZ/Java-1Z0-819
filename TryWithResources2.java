class Scratch {
    public static void main(String[] args) {

        // First the finally code is executed and only then the catch to handle Exception
        try (A a = new A(); B b = new B()){
            System.out.println("Try block");
            a.MethodWithError();
        } catch (NullPointerException e){
            System.out.println("Exception handled: " + e.getMessage());
        }

        // In the background Java wraps try-with-resources in another normal try.
    }
}

class A implements AutoCloseable{
    public void close(){
        System.out.println("Executing close() in the Finally block for class A");
    }
    public void MethodWithError() throws RuntimeException { throw new RuntimeException("Exception"); }
}

class B implements AutoCloseable{
    @Override
    public void close(){
        System.out.println("Executing close() in the Finally block for class B");
    }
}