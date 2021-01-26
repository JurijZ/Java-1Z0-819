import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.URI;

class Scratch {
    public static void main(String[] args) {
        // Demonstrates Path class methods

        // Path object to current working directory
        Path p1 = Paths.get("").toAbsolutePath();
        System.out.println("Get current working directory path: " + p1);

        // Normalize - uses .. and . to navigate directories
        // Here we start with working directory (C:\Exams\Java\JavaScratches), then we go one up (C:\Exams\Java),
        // and then enter JavaScratches again (C:\Exams\Java\JavaScratches).
        Path p2 = Paths.get("..\\JavaScratches");
        System.out.println("Original path: " + p2.toAbsolutePath() + ", Normalized path: " + p2.toAbsolutePath().normalize());

        // Use toAbsolutePath method to get info
        System.out.println("Getting parent: " + p1.toAbsolutePath().getParent());
        System.out.println("Number of Sub-Directories: " + p1.toAbsolutePath().getNameCount());
        System.out.println("Getting Root: " + p1.toAbsolutePath().getRoot());
        System.out.println("Getting subpath: " + p1.toAbsolutePath().subpath(0, 2));

        // Specifying a full path using windows back slashes
        Path p3 = Paths.get("\\Folder1\\Folder2");
        System.out.println(p3.toAbsolutePath());

        // Use Paths.get to get a file reference with a URI
        Path filePath1 = Paths.get(URI.create("file:///LearnProgrammingAcademy/IOProject/characterData.txt"));
        System.out.println(filePath1.toAbsolutePath());

        // FileSystems.getDefault() gives default file system object
        // which has a method getPath
        Path filePath2 = FileSystems.getDefault().getPath("C:",
                new String[]{
                        "LearnProgrammingAcademy",
                        "IOProject",
                        "characterData.txt"});
        System.out.println(filePath2.toAbsolutePath());
    }
}
