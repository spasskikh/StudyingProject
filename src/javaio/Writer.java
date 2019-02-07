package javaio;

import collections.map.treemap.AvgStudentGrade;
import collections.map.treemap.SubjectGrade;
import javaio.entity.Student;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.nio.file.StandardOpenOption.*;

public class Writer {

    public static void bufferedWriter(String fileName, SortedMap<AvgStudentGrade, Set<SubjectGrade>> grades) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (AvgStudentGrade gradeKey : grades.keySet()) {
                writer.write("========================\n");
                writer.write("Student: " + gradeKey.getName() + "\n");
                writer.write("Average grade: " + gradeKey.getAvgGrade() + "\n");

                for (SubjectGrade grade : grades.get(gradeKey)) {
                    writer.write("Subject: " + grade.getSubject() + ", Grade: " + grade.getGrade() + "\n");
                }
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    public static void objectOutputStream(List<Student> students, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            for (Student student : students) {
                out.writeObject(student);
            }
            out.writeObject(new Student(null, -1, null));
        } catch (IOException exc) {
            exc.printStackTrace();

        }

    }

    public static void nioBufferedWriter(String fileName) {
        Charset charset = Charset.forName("UTF-8");
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName), charset)) {
            writer.write(fileName, 0, fileName.length());
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    public static void nioOutputStream(String fileName) {
        String str = "File cannot be found.";
        byte[] bytes = str.getBytes();
        try (OutputStream out = Files.newOutputStream(Paths.get(fileName), CREATE, APPEND)) {
            out.write(bytes, 0, bytes.length);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
