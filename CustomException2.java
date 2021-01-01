class Scratch {
    public static void main(String[] args) {
        A a = new A();

        // I can call this method without using try/catch even though it was not handled in the method.
        // This is because method throws an unchecked exception (Error)
        a.testNotHandledException();
    }
}

class A {
    public void testNotHandledException() throws CustomError {
        //Lets generate an exception
        throw new CustomError("Custom Error");
    }
}

// Deriving from Error makes it a Unchecked exception, therefore try/catch is not mandatory.
class CustomError extends Error {
    //Add an error_code for our own purposes, perhaps logging
    private static final int ERROR_CODE = 9876;

    CustomError(String message) {
        //Call the constructor of a super class, that is Error
        super(message + " (" + ERROR_CODE + ")");
    }
}