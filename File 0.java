import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.URI;

class Scratch {
    public static void main(String[] args) throws IOException {
        // Demonstrates File class methods

        // Relative paths are resolved relative to where your JVM was started.
        File f1 = new File("File 0.java"); // Assumes that the file is in the current working directory
        Path path = Path.of("");
        System.out.println("Working directory: " + path.toAbsolutePath());
        System.out.println("___________________________________________");

        System.out.println("Shows what was passed to the File class constructor: " + f1.getPath());
        System.out.println("getAbsolutePath: " + f1.getAbsolutePath());
        System.out.println("getCanonicalPath: " + f1.getCanonicalPath());
        System.out.println("Get file details : " + f1.getAbsolutePath().length());
        System.out.println("___________________________________________");

        // Here I imagine that I need to read a file one folder up by using back reference
        File f2 = new File("..\\File 0.java");
        System.out.println("Shows what was passed to the File class constructor: " + f2.getPath());
        System.out.println("getAbsolutePath returns incorrect path: " + f2.getAbsolutePath());
        System.out.println("getCanonicalPath works correctly: " + f2.getCanonicalPath());
    }
}
