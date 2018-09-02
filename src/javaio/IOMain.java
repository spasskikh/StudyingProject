package javaio;

import collections.map.treemap.AvgStudentGrade;
import collections.map.treemap.SubjectGrade;
import collections.map.treemap.TreeMapMain;

import java.util.*;

public class IOMain {

    private static final String GRADE_BOOK = "GradeBook.txt";
    private static final String STUDENTS_BOOK = "StudentsBook.bin";

    /*characters stream
     * bytes stream*/

    public static void main(String[] args) {

        SortedMap<AvgStudentGrade, Set<SubjectGrade>> grades = TreeMapMain.createGrades();

        Writer.writeFile(GRADE_BOOK, grades);
        Reader.readFile(GRADE_BOOK);

        ByteStream.byteStream(GRADE_BOOK);

//        Writer.writeWithFormatter();

        processGrades(grades, STUDENTS_BOOK);
        outputStudents(Reader.readObjects(STUDENTS_BOOK));

    }

    private static void processGrades(SortedMap<AvgStudentGrade, Set<SubjectGrade>> grades, String fileName) {
        List<Student> students = new ArrayList<>();

        for (AvgStudentGrade gradeKey : grades.keySet()) {
            students.add(new Student(gradeKey.getName(), gradeKey.getAvgGrade(), grades.get(gradeKey)));
        }

        Writer.writeObjects(students, fileName);

    }

    private static void outputStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student.getName() +": avg grade - "+ student.getAvgGrade());
            for (SubjectGrade grade : student.getGrades())
                System.out.println("\t" + grade.getSubject() + ": " + grade.getGrade());
        }
    }


}
