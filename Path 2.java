import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.URI;

class Scratch {
    public static void main(String[] args) {
        // Demonstrates Relativize method

        Path currentPath = Paths.get("C:\\Exams\\Java\\Screenshots"); // location where I'm now
        Path destinationPath = Paths.get("C:\\Exams\\code\\test"); // I want to find a relative path to this location, so that I could run it in a single cd operation.

        // print paths
        System.out.println("This Path:"
                + currentPath);
        System.out.println("Given Path:"
                + destinationPath);

        // call relativize() to create a relative path
        Path relativize = currentPath.relativize(destinationPath);

        // print result
        System.out.println("Relative Path: " + relativize);

        // Note that you need to operate with Absolute paths.
        // If you supply a relative path it will throw an IllegalArgumentException
        Path relativePath = Paths.get("\\code\\test");
        Path error = currentPath.relativize(relativePath);
        //Path error2 = relativePath.relativize(currentPath);
    }
}
