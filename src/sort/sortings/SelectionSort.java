package sort.sortings;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

public class SelectionSort {

    static int iter = 0;

    public static void selectionSort (int [] arr) {

        long startTime = System.currentTimeMillis();

        for (int i = 0 ; i<arr.length-1; i++) {

            for (int j = i+1 ; j<arr.length ; j++) {
                if (arr[j] < arr[i]) {
                    int tech = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tech;
                    iter++;
                }
                else iter++;
            }
            iter++;
        }

        System.out.println("SelectionSort:");
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
