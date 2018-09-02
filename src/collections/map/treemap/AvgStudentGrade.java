package collections.map.treemap;

public class AvgStudentGrade implements Comparable<AvgStudentGrade> {

    private final String name;
    private final float avgGrade;

    public AvgStudentGrade(String name, float avgGrade) {
        this.name = name;
        this.avgGrade = avgGrade;
    }

    public String getName() {
        return name;
    }

    public float getAvgGrade() {
        return avgGrade;
    }

    @Override
    public int compareTo(AvgStudentGrade that) {
        if (this.avgGrade < that.getAvgGrade()) {
            return -1;
        }
        if (this.avgGrade > that.getAvgGrade()) {
            return 1;
        }
        return this.name.compareTo(that.getName());
    }

    @Override
    public String toString() {
        return name + " - " + avgGrade;
    }
}
