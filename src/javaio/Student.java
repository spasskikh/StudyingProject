package javaio;

import collections.map.treemap.SubjectGrade;

import java.io.Serializable;
import java.util.Set;

public class Student implements Serializable{

    private String name;
    private float avgGrade;
    private Set<SubjectGrade> grades;
//    private transient Set<SubjectGrade> grades;
//                              field will be ignored, while storing object, and will be NULL after deserializing

    public Student(String name, float avgGrade, Set<SubjectGrade> grades) {
        this.name = name;
        this.avgGrade = avgGrade;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public float getAvgGrade() {
        return avgGrade;
    }

    public Set<SubjectGrade> getGrades() {
        return grades;
    }
}
