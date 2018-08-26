package collections.arrays;

import java.util.Arrays;

public class GradeBook {

    public static void main(String[] args) {
        int[][] gradesArray = new int[10][3];
        for (int i = 0; i < gradesArray.length; i++) {
            for (int j = 0; j < gradesArray[i].length; j++) {
                gradesArray[i][j] = (int) (Math.random() * 100);
            }
        }

        System.out.println("Minimum grade: " + calcMin(gradesArray));

        varArgs();

        processArrays();

    }

    private static int calcMin(int[][] grades) {
        int min = 100;

        for (int[] a : grades) {
            for (int i : a) {
                if (min > i) min = i;
            }
        }
        return min;
    }

    private static void varArgs() {
        double a = 0.56;
        double b = 1.92;
        double c = 3.45;
        double d = 5.01;

        System.out.println("Average for 2 elements: " + calcAvg(a,b));
        System.out.println("Average for 3 elements: " + calcAvg(a,b,c));
        System.out.println("Average for 4 elements: " + calcAvg(a,b,c,d));
    }

    private static double calcAvg(double... doubles) {
        double sum = 0;

        for (double d : doubles) {
            sum += d;
        }
        return sum / doubles.length;
    }

    private static void processArrays() {
        double[] arr = new double[5];
        for (int i = 0; i<arr.length; i++) {
            arr[i] = Math.random()*10;
        }

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

        int[] newArr = new int[5];
        Arrays.fill(newArr, (int)(Math.random()*50));
        System.out.println(Arrays.toString(newArr));

        int[] copyArray = new int[10];
        System.arraycopy(newArr,0,copyArray,1,newArr.length);
        System.out.println(Arrays.toString(copyArray));
    }
}
