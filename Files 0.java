import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.URI;

class Scratch {
    public static void main(String[] args) throws IOException {
        // Files class provide many static methods. It mainly operates upon Path class (file or folder)

        Path path = Path.of("Java.iml");
        System.out.println("Java.iml file exists(): " + Files.exists(path));
        System.out.println("Java.iml file notExists(): " + Files.notExists(path));

        // Files class also works with directories
        Path path2 = Path.of("");
        System.out.println("Folder exists(): " + Files.exists(path2));
        System.out.println("Folder notExists(): " + Files.notExists(path2));

        // Lets get more metadata about the file
        System.out.println("Java.iml file getLastModifiedTime(): " + Files.getLastModifiedTime(path));
        System.out.println("Java.iml file getAttribute() lastAccessTime: " + Files.getAttribute(path, "lastAccessTime"));
        System.out.println("Java.iml file size(): " + Files.size(path) + " bytes");
        System.out.println("Java.iml file isRegularFile(): " + Files.isRegularFile(path));
        System.out.println("Java.iml file isDirectory(): " + Files.isDirectory(path));
        System.out.println("Java.iml file isReadable(): " + Files.isReadable(path));
        System.out.println("Java.iml file isWritable(): " + Files.isWritable(path));
        System.out.println("Java.iml file isExecutable(): " + Files.isExecutable(path));
    }
}
