package javaio;

import collections.map.treemap.AvgStudentGrade;
import collections.map.treemap.SubjectGrade;
import collections.map.treemap.TreeMapMain;

import java.io.FileWriter;
import java.io.IOException;
import java.util.NavigableMap;
import java.util.Set;

public class IOMain {

    public static void main(String[] args) {

        NavigableMap<AvgStudentGrade, Set<SubjectGrade>> grades = TreeMapMain.createGrades();

        try (FileWriter writer = new FileWriter("gradebook.txt")) {

            for (AvgStudentGrade gradeKey : grades.keySet()) {
                writer.write("-------------------\n");
                writer.write("Student: " + gradeKey.getName()+"\n");
                writer.write("Average grade: " + gradeKey.getAvgGrade() + "\n");

                for (SubjectGrade grade : grades.get(gradeKey)) {
                    writer.write("Subject: " + grade.getSubject() + ", Grade: " + grade.getGrade()+"\n");
                }
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }

    }


}
