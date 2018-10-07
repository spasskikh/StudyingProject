package sort.sortings;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

public class ShakeSort {

    static int iter = 0;

    public static void shakeSort (int [] arr) {

        long startTime = System.currentTimeMillis();

        int left = 0;
        int right = arr.length-1;

        while (left<=right) {
            for (int k = left; k<right ; k++) {
                if (arr[k+1]<arr[k]) {
                    int tech = arr[k];
                    arr[k] = arr[k+1];
                    arr[k+1] = tech;
                    iter++;
                }
                else iter++;
            }
            right--;
            for (int k = right ; k > left ; k--) {
                if (arr[k-1]>arr[k]) {
                    int tech = arr[k];
                    arr[k] = arr[k-1];
                    arr[k-1] = tech;
                    iter++;
                }
                else iter++;
            }
            left++;
        }

        System.out.println("ShakeSort:");
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
