class Scratch {
    public static void main(String[] args) {

        FirstCloseable first = new FirstCloseable();
        try (first; SecondCloseable second = new SecondCloseable()) {  // Line 3
            first.run();
            second.run();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class FirstCloseable implements AutoCloseable {
    public void close() {  //
        //System.out.println("111111");

        // Resources are closed before catch or finally, therefore this exception is suppressed and not visible
        throw new IllegalStateException("First could not close");
    }

    public void run() {
        System.out.println("Running First");
    }
}

class SecondCloseable implements AutoCloseable {
    public void close() throws Exception {  // Line 2
        // Resources are closed before catch or finally, therefore this exception is suppressed and not visible
        throw new IllegalStateException("Second could not close");
    }

    public void run() {
        throw new IllegalStateException("Second could not run");
    }
}
