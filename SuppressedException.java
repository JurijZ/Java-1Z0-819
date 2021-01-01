import java.io.FileInputStream;

class Scratch {
    public static void main(String[] args) {
        try
        {
            // FileNotFoundException will be suppressed by the exception in the finally block which is NullReferenceException
            Method("None Existing path");
        }
        catch (Throwable e)
        {
            System.out.println("Suppressing Exception: " + e);
            for (Throwable t : e.getSuppressed()) {
                System.out.println("Suppressed Exception: " + t);
            }
        }
    }

    public static void Method(String filePath) throws Exception
    {
        // We are going to store the suppressed exception in this variable
        Throwable firstException = null;

        FileInputStream fileIn = null;
        try
        {
            fileIn = new FileInputStream(filePath);
        }
        catch (Exception e)
        {
            firstException = e;
        }
        finally
        {
            try{
                // This will throw one more exception on top of the First one
                fileIn.close();
            }
            catch(Exception e){
                e.addSuppressed(firstException);
                throw e;
            }
        }
    }
}