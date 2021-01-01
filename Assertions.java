class ScratchAssert {
    public static void main(String[] args) {

        // Note - this scratch file is assotiated with the special config called "ScratchAssert".
        // In this config a VM option is set "-enableassertions".

        // This will stop the execution with the Exception of type Error
        // and also show the message in the exception
        //assert 5 < 1: "------------STATEMENT IS INCORRECT----------------";

        // Second part can be a method that must return something (void is not allowed, will not compile)
        assert 5 < 1: Message();


        // This will stop the execution with the Exception of type Error
        //assert 5 < 1;
    }

    public static String Message(){
        return "-----------Message------------";
    }
}