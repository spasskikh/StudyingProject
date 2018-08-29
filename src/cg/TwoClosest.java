package cg;

import java.util.Arrays;

public class TwoClosest {

    public static void main(String[] args) {

        int size = 100;
        int[] input = new int[size];

        for (int i = 0; i < input.length ;i++) {
            input[i] = (int) (Math.random()*100);
        }

        Arrays.sort(input);
        int[] diffs = new int[input.length-1];
        for (int i = 0; i<diffs.length; i++) {
            diffs[i] = input[i+1]-input[i];
        }
        Arrays.sort(diffs);
        System.out.println(diffs[0]);
    }
}
