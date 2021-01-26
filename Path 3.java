import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.URI;

class Scratch {
    public static void main(String[] args) {
        // Demonstrates Resolve method which simply joins two paths
        // It has two signatures:
        // 1. Path resolve(string other)
        // 2. Path resolve(Path other)

        Path basePath = Paths.get("C:\\Exams\\Java"); // base location
        System.out.println("Base Path:" + basePath);

        // 1. example with string (simple adds a string to the basePath)
        String s = "Screenshots";
        Path resolvedPath = basePath.resolve(s);
        System.out.println("Resolved Path:" + resolvedPath);

        // 2. example with Path object (joins path to the base path)
        Path path = Paths.get("Java\\Screenshots");
        Path resolvedPath1 = basePath.resolve(path);
        System.out.println("Resolved Path:" + resolvedPath1);

        //-------------------------------------------
        // Demonstrates resolveSibling() method
        // 1. example with string (simply replaces last part of the base path with the provided string)
        String s1 = "Screenshots";
        Path resolvedSiblingPath = basePath.resolveSibling(s1);
        System.out.println("Resolved Sibling Path:" + resolvedSiblingPath);

        // 2. example with Path object (replaces last part of the base path with the provided relative path)
        Path path1 = Paths.get("Java2\\Screenshots");
        Path resolvedSiblingPath1 = basePath.resolveSibling(path1);
        System.out.println("Resolved Sibling Path:" + resolvedSiblingPath1);

        //-------------------------------------------
        // If the path has invalid characters then an InvalidPathException will be thrown
        Path path2 = Paths.get("Java\\Screenshots *"); // There are many invalid characters that OS defines
        Path resolvedPath2 = basePath.resolve(path2);
        System.out.println("Resolved Path:" + resolvedPath2);


    }
}
