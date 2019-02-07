package javaio;

import javaio.entity.Student;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public static void bufferedReader(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    public static List<Student> objectInputStream(String fileName) {
        List<Student> students = new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            boolean keepReading = true;
            while (keepReading) {
                Student student = (Student) in.readObject();
                if (student.getAvgGrade() != -1) {
                    students.add(student);
                } else {
                    keepReading = false;
                }
            }
        } catch (IOException | ClassNotFoundException exc) {
            exc.printStackTrace();
        }
        return students;
    }

    public static void nioFileInFull(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        List<String> lines = Files.readAllLines(path);

        for (String str : lines) {
            System.out.println(str);
        }
    }

    public static void nioBufferedReader(String fileName) {
        Path path = Paths.get(fileName);
        Charset charset = Charset.forName("UTF-8");
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            String s;
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    public static void nioInputStream(String fileName) {
        Path path = Paths.get(fileName);
        try (InputStream in = Files.newInputStream(path)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String s;
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }


}