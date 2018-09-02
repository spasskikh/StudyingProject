package javaio;

import collections.map.treemap.AvgStudentGrade;
import collections.map.treemap.SubjectGrade;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Writer {

    public static void writeFile(String fileName, SortedMap<AvgStudentGrade, Set<SubjectGrade>> grades) {
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

    public static void writeWithFormatter() {
        Formatter formatter = null;
        Scanner scanner = new Scanner(System.in);

        try {
            formatter = new Formatter("BankAccounts");
            int i = 0;
            while (i < 3) {

                try {
                    System.out.println("Please enter client ID, Name, Surname and Balance.");
                    formatter.format("%d, %s, %s, %.2f\n",
                            scanner.nextInt(), scanner.next(), scanner.next(), scanner.nextFloat());

                    i++;
                } catch (InputMismatchException exc) {
                    System.out.println("Input was incorrect. Please, try again.");
                    scanner.nextLine();
                }
            }
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        } finally {
            if (formatter != null)
                formatter.close();

        }

    }

    public static void writeObjects(List<Student> students, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {

            for (Student student : students) {
                out.writeObject(student);
            }
            out.writeObject(new Student(null,-1,null));

        } catch (IOException exc) {
            exc.printStackTrace();

        }

    }
}
