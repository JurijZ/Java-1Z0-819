class Scratch {
    public static void main(String[] args) {
        A a = new A();

        // I cannot simply call this method because it throws a checked exception, therefore I must wrap it into a try/catch
        //a.testNotHandledException();

        try{
            a.testNotHandledException();
        } catch(CustomException ce) {
            System.out.println("Handled in the main. " + ce.getMessage());
        }

        // I cannot call this method without try/catch because it was already handled in the method
        a.testHandledException();
    }
}

class A {
    public void testNotHandledException() throws CustomException {
        // Lets generate an exception
        throw new CustomException("Custom Exception");
    }

    public void testHandledException(){
        try {
            // Lets generate an exception
            throw new CustomException("Custom Exception");
        } catch(CustomException ce){
            System.out.println("Handled in the method. " + ce.getMessage());
        }
    }
}

// Deriving from Exception makes it a Checked exception, therefore a catch block will be needed.
// We could inherit from Throwable and it would have the same behaviour as Exception
class CustomException extends Exception {
    // Add an error_code for our own purposes, perhaps logging
    private static final int ERROR_CODE = 9876;

    CustomException(String message) {
        //Call the constructor of a super class, that is Exception
        super(message + " (" + ERROR_CODE + ")");
    }
}

