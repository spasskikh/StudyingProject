package javaio.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FileTreeVisitor {

    public static void main(String[] args) throws IOException {
        Path temp = Paths.get("temp");
//        Files.walkFileTree(temp, new Visitor());

        Files.walkFileTree(temp, new CopyFileVisitor(temp, Paths.get("temp2")));

    }

    public static class Visitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            rename(file);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            System.out.println(dir);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            rename(dir);
            return FileVisitResult.CONTINUE;
        }

        private void rename(Path file) throws IOException {
            int nameCount = file.getNameCount();
            if (nameCount > 1) {
                Path startPath = file.subpath(0, nameCount - 1);
                Path endPath = file.subpath(nameCount - 1, nameCount);
                Files.move(file, Paths.get(
                        startPath + File.separator + LocalDate.now().format(DateTimeFormatter.ISO_DATE) + " - " + endPath));
            }
        }
    }

    public static class CopyFileVisitor extends SimpleFileVisitor<Path> {

        private Path source;
        private Path destination;

        CopyFileVisitor(Path source, Path destination) {
            this.source = source;
            this.destination = destination;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes attrs) {
            try {
                copy(path);
            } catch (IOException e) {
                System.err.println("Copy directory error");
                e.printStackTrace();
                return FileVisitResult.SKIP_SUBTREE;
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
            try {
                copy(path);
            } catch (IOException e) {
                System.err.println("Copy directory error");
            }
            return FileVisitResult.CONTINUE;
        }

        private void copy(Path path) throws IOException {
            Path relativePath = source.relativize(path);
            Path destinationPath = destination.resolve(relativePath);
            System.out.println("Relative path " + relativePath);
            System.out.println("Destination path " + destinationPath);

            Files.copy(path, destinationPath);
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            System.err.println("Copy file failed.");
            return super.visitFileFailed(file, exc);
        }
    }
}
