package sort.sortings;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

public class BubbleSort {

    static int iter = 0;

    public static void bubbleSort (int [] arr) {

        long startTime = System.currentTimeMillis();

//        int a = arr.length-1;
//
//        for (int i = 0 ; i<a ; i++) {
//            if (arr[i+1] < arr[i]) {
//                int tech = arr[i];
//                arr[i] = arr[i+1];
//                arr[i+1] = tech;
//                for (int k = i+1 ; k<a ; k++) {
//                    if (arr[k+1] < arr[k]) {
//                        int tech2 = arr[k];
//                        arr[k] = arr[k+1];
//                        arr[k+1] = tech2;
//                        iter++;
//                    }
//                    else iter++;
//                }
//                i=-1;
//                a--;
//            }
//            else iter++;
//        }

        for (int i = arr.length-1; i>=0 ; i--) {
            for (int k = 0 ; k<i ; k++) {
                if (arr[k+1] < arr[k]) {
                    int tech = arr[k];
                    arr[k] = arr[k+1];
                    arr[k+1] = tech;
                    iter++;
                }
                else iter++;
            }
            iter++;
        }

        System.out.println("BubbleSort:");
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
