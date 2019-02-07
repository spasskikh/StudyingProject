package javaio.nio;

import java.io.IOException;
import java.nio.file.*;

public class Directories {

    public void processDirectory(String dirName) throws IOException {
        Path path = Paths.get(dirName);
        if (Files.notExists(path)) {
            Files.createDirectory(path);
        }
        Files.createDirectories(Paths.get(dirName + "/a/b/c"));

        Path tmp = Files.createTempDirectory(path, "tmp");

        Iterable<Path> rootDirectories = FileSystems.getDefault().getRootDirectories();
        for (Path rootDir : rootDirectories) {
            System.out.println(rootDir);
        }

        try (DirectoryStream<Path> paths = Files.newDirectoryStream(path, "*.{txt,bin}")) {
            for (Path p : paths) {
                System.out.println("txt or bin: " + p);
            }
        }

        try (DirectoryStream<Path> paths =
                     Files.newDirectoryStream(path, p -> Files.isDirectory(p))) {
            for (Path p : paths) {
                System.out.println("dir: " + p);
            }
        }


        Files.delete(tmp);
    }
}
