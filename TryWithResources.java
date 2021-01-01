class Scratch {
    public static void main(String[] args) {

        //Closing will be happening in the reverse order. First B then A.
        try (A a = new A(); B b = new B()){
            System.out.println("Try block");
        }
    }
}

class A implements AutoCloseable{
    public void close(){
        System.out.println("Executing in the Finally block for class A");
    }
}

class B implements AutoCloseable{
    @Override
    public void close(){
        System.out.println("Executing in the Finally block for class B");
    }
}