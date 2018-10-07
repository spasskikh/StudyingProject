package sort.sortings;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

public class StupidSort {

    static int iter = 0;

    public static void stupidSort (int [] arr) {

        long startTime = System.currentTimeMillis();

        for (int i = 0 ; i<arr.length-1 ; i++) {
            if (arr [i+1] < arr [i]) {
                int tech = arr [i];
                arr [i] = arr [i+1];
                arr [i+1] = tech;
                iter ++;
                i=-1;
            }
            else iter++;
        }

        System.out.println("StupidSort:");
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
