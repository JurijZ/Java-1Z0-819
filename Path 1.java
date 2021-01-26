import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.URI;

class Scratch {
    public static void main(String[] args) {
        // Demonstrates Normalized navigation

        // You will get an exam question like this, where you will have to guess the normalized path
        Path p1 = Path.of("a/../../../b/./../c");
        System.out.println("Path: " + p1.toAbsolutePath());
        System.out.println("Transformed path: " + p1.normalize());

        Path p2 = Path.of("/a/../../../b/./../c"); // first slash refers to the root
        System.out.println("Path: " + p2.toAbsolutePath());
        System.out.println("Transformed path: " + p2.normalize());

        Path p3 = Path.of("../../c");
        System.out.println("Path: " + p3.toAbsolutePath());
        System.out.println("Transformed path: " + p3.normalize());

    }
}
