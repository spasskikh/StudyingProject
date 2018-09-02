package javaio;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public static void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    public static List<Student> readObjects(String fileName) {

        List<Student> students = new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {

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
}