package collections.map.treemap;

import javafx.beans.property.ObjectProperty;

import java.util.*;

public class TreeMapMain {

    public static void main(String[] args) {

        NavigableMap<AvgStudentGrade, Set<SubjectGrade>> grades = createGrades();

//        Iterator itr = grades.entrySet().iterator();
//        while (itr.hasNext()) {
//            Map.Entry e = (Map.Entry) itr.next();
//            System.out.println(e.getKey()+" Hash code: "+ e.getKey().hashCode()+ " --- " + e.getValue());
//        }

//        System.out.println(grades.get(new AvgStudentGrade("Alex", 82.8F)));

        printGrade(grades, false);


    }

    private static void printGrade(NavigableMap<AvgStudentGrade, Set<SubjectGrade>> grades, boolean printValue) {
        Set<AvgStudentGrade> avgGrades = grades.keySet();
        for(AvgStudentGrade grade : avgGrades) {
            System.out.println(grade);
            if (printValue) {
                System.out.println(grades.get(grade));
            }
        }
    }

    private static NavigableMap<AvgStudentGrade, Set<SubjectGrade>> createGrades() {

        Set<SubjectGrade> alexGrade = new HashSet<>();
        alexGrade.add(new SubjectGrade("Maths", 89));
        alexGrade.add(new SubjectGrade("Physics", 65));
        alexGrade.add(new SubjectGrade("History", 95));
        alexGrade.add(new SubjectGrade("Literature", 90));
        alexGrade.add(new SubjectGrade("Chemistry", 75));

        Set<SubjectGrade> jameGrade = new HashSet<>();
        jameGrade.add(new SubjectGrade("Maths", 75));
        jameGrade.add(new SubjectGrade("Physics", 80));
        jameGrade.add(new SubjectGrade("History", 55));
        jameGrade.add(new SubjectGrade("Literature", 70));
        jameGrade.add(new SubjectGrade("Chemistry", 80));

        Set<SubjectGrade> antonyGrade = new HashSet<>();
        antonyGrade.add(new SubjectGrade("Maths", 93));
        antonyGrade.add(new SubjectGrade("Physics", 91));
        antonyGrade.add(new SubjectGrade("History", 82));
        antonyGrade.add(new SubjectGrade("Literature", 78));
        antonyGrade.add(new SubjectGrade("Chemistry", 88));

        Set<SubjectGrade> victoriaGrade = new HashSet<>();
        victoriaGrade.add(new SubjectGrade("Maths", 73));
        victoriaGrade.add(new SubjectGrade("Physics", 65));
        victoriaGrade.add(new SubjectGrade("History", 75));
        victoriaGrade.add(new SubjectGrade("Literature", 66));
        victoriaGrade.add(new SubjectGrade("Chemistry", 50));

        Set<SubjectGrade> alinaGrade = new HashSet<>();
        alinaGrade.add(new SubjectGrade("Maths", 90));
        alinaGrade.add(new SubjectGrade("Physics", 70));
        alinaGrade.add(new SubjectGrade("History", 78));
        alinaGrade.add(new SubjectGrade("Literature", 88));
        alinaGrade.add(new SubjectGrade("Chemistry", 89));

        NavigableMap<AvgStudentGrade, Set<SubjectGrade>> map = new TreeMap<>();
        map.put(new AvgStudentGrade("Alex", calcAvg(alexGrade)), alexGrade);
        map.put(new AvgStudentGrade("James", calcAvg(jameGrade)), jameGrade);
        map.put(new AvgStudentGrade("Antony", calcAvg(antonyGrade)), antonyGrade);
        map.put(new AvgStudentGrade("Victoria", calcAvg(victoriaGrade)), victoriaGrade);
        map.put(new AvgStudentGrade("Alina", calcAvg(alinaGrade)), alinaGrade);

        return map;
    }

    private static float calcAvg(Set<SubjectGrade> grades) {
        float sum = 0f;
        for (SubjectGrade grade : grades) {
            sum += grade.getGrade();
        }
        return sum / grades.size();
    }

}
