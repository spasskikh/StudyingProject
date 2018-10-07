package sort.test;

import sort.sortings.*;

import java.util.Arrays;

public class TestSort {

    public static void main(String[] args) {

        int [] arr = /*{55, 93, 2, 96, 1}; //*/new int [1000];

        for (int i = 0 ; i< arr.length ; i++) {
            arr[i] = (int)(Math.random()*1000);
        }

        int [] arr1 = arr.clone();
        int [] arr2 = arr.clone();
        int [] arr3 = arr.clone();
        int [] arr4 = arr.clone();
        int [] arr5 = arr.clone();

        System.out.println(Arrays.toString(arr));
        System.out.println();

        StupidSort.stupidSort(arr1);

        BubbleSort.bubbleSort(arr2);

        ShakeSort.shakeSort(arr3);

        SelectionSort.selectionSort(arr4);

        InsertionSort.insertionSort(arr5);

    }

}
