package javaio;

import collections.map.treemap.AvgStudentGrade;
import collections.map.treemap.SubjectGrade;
import collections.map.treemap.TreeMapMain;
import javaio.entity.Student;

import java.io.IOException;
import java.util.*;

public class IOMain {

    private static final String GRADE_BOOK = "GradeBook.txt";
    private static final String STUDENTS_BOOK = "StudentsBook.bin";

    /*characters stream
     * bytes stream*/

    public static void main(String[] args) throws IOException {

        SortedMap<AvgStudentGrade, Set<SubjectGrade>> grades = TreeMapMain.createGrades();

        Writer.bufferedWriter(GRADE_BOOK, grades);
        Reader.bufferedReader(GRADE_BOOK);

        ByteStream.byteStream(GRADE_BOOK);

        processGrades(grades, STUDENTS_BOOK);
        outputStudents(Reader.objectInputStream(STUDENTS_BOOK));

        FileUtils.printNioFileDetails(GRADE_BOOK);

        Reader.nioFileInFull(GRADE_BOOK);

        Reader.nioBufferedReader(GRADE_BOOK);
        Writer.nioBufferedWriter("Buffered.txt");

        Reader.nioInputStream(GRADE_BOOK);
        Writer.nioOutputStream("Buffered.txt");



    }

    private static void processGrades(SortedMap<AvgStudentGrade, Set<SubjectGrade>> grades, String fileName) {
        List<Student> students = new ArrayList<>();

        for (AvgStudentGrade gradeKey : grades.keySet()) {
            students.add(new Student(gradeKey.getName(), gradeKey.getAvgGrade(), grades.get(gradeKey)));
        }

        Writer.objectOutputStream(students, fileName);

    }

    private static void outputStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student.getName() +": avg grade - "+ student.getAvgGrade());
            for (SubjectGrade grade : student.getGrades())
                System.out.println("\t" + grade.getSubject() + ": " + grade.getGrade());
        }
    }


}
