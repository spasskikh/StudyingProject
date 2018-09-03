package javaio;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class FileUtils {

    public static void printIOFileDetails(String path) throws IOException {

        File file = new File(path);

//        Get path details
        System.out.println("Absolute path " + file.getAbsolutePath());
        System.out.println("Relative path " + file.getPath());
        System.out.println("Free space in MBytes " + file.getFreeSpace() / 1_000_000);
        System.out.println("Parent directory " + file.getParent());
        System.out.println("Is absolute path " + file.isAbsolute());

        System.out.println("Current directory is: " + System.getProperty("user.dir"));

        if (file.isDirectory()) {
            System.out.println("It is a directory. Printing content:");
            String[] list = file.list();
            if (list != null) {
                for (String str : list) {
                    System.out.println(str);
                }
            }
        } else {
            System.out.println("It is a file.");
            System.out.println("Creating a new file " + file.createNewFile());

//            permissions
            System.out.println("Can read - " + file.canRead());
            System.out.println("Can write - " + file.canWrite());
            System.out.println("Can execute - " + file.canExecute());
            System.out.println("File is hidden - " + file.isHidden());
            System.out.println("Last modified - " + file.lastModified());
            System.out.println("Deleting a file - " + file.delete());

        }
    }

    public static void printNioFileDetails(String fileName) throws IOException {

        Path path = Paths.get(fileName);
        Path path1 = FileSystems.getDefault().getPath(fileName);
//        Path path2 = Paths.get(System.getProperty("user.dir"), fileName);

        System.out.println("File name: " + path.getFileName());
        Path absPath = path.toAbsolutePath();
        System.out.println("Root dir: " + absPath.getRoot());
        System.out.println("Absolute path: " + absPath);
        System.out.println("Parent dir: " + absPath.getParent());
        System.out.println("Name count: " + absPath.getNameCount());
        System.out.println("Sub-path: " + absPath.subpath(0, 3));

        Path path3 = Paths.get("../../");
        System.out.println("Real path: " + path3.toRealPath());

        System.out.println("File exists - " + Files.exists(path));
        System.out.println("File does not exist - " + Files.notExists(path));
        System.out.println("Is readable - " + Files.isReadable(path));
        System.out.println("Is writable - " + Files.isWritable(path));
        System.out.println("Is executable - " + Files.isExecutable(path));

        System.out.println("Is the same file - " + Files.isSameFile(path, path1));

        Path parentPath = absPath.getParent();
        Path filesPath = parentPath.resolve("files");
        if (Files.notExists(filesPath)) {
            Files.createDirectory(filesPath);
        }
        Files.copy(absPath, filesPath.resolve(path), StandardCopyOption.REPLACE_EXISTING);
        Files.delete(filesPath.resolve(path));
        Files.delete(filesPath);


    }
}



