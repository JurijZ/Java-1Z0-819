import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.URI;

class Scratch {
    public static void main(String[] args) throws IOException {
        // Demonstrates toRealPath() method

        // When the path really exist
        Path path = Paths.get("C:\\Exams\\Java");
        Path realPath = path.toRealPath();
        System.out.println("Real Path:" + realPath);

        // When we supply a relative path
        Path path1 = Paths.get("..\\..\\..\\Exams\\Java");
        Path realPath1 = path1.toRealPath();
        System.out.println("Real Path:" + realPath1);

        // When the path does not exist (throws NoSuchFileException)
        Path path2 = Paths.get("C:\\Exams\\Java\\NoneExistingFolder");
        Path realPath2 = path2.toRealPath();

    }
}
