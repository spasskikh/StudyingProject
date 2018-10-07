package sort.sortings;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

public class InsertionSort {

    static int iter = 0;

    public static void insertionSort (int [] arr) {

        long startTime = System.currentTimeMillis();

        for (int i = 1 ; i<arr.length ; i++) {

            for (int k = i ; k>0 && arr[k-1]>arr[k] ; k--) {
                int tech = arr[k-1];
                arr[k-1] = arr[k];
                arr[k] = tech;
                iter++;
            }
            iter++;
        }

        System.out.println("InsertionSort:");
        System.out.println(Arrays.toString(arr));

        System.out.println("Iterations: " + iter+".");

        long totalTime = System.currentTimeMillis()-startTime;
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(totalTime);
        SimpleDateFormat format = new SimpleDateFormat("ss:SSS");
        System.out.println("Time: "+format.format(cal.getTimeInMillis()));
        System.out.println();
    }
}
