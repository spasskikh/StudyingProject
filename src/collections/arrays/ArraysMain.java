package collections.arrays;

import java.util.Arrays;

public class ArraysMain {

    public static void main(String[] args) {


        /*all elements initialized as 0*/
        int[] myArray = new int[10];


        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(myArray));

        System.out.println(Arrays.toString(sort(myArray)));

        multiDimArray();

    }

    private static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tech = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tech;
                }
            }
        }
        return arr;
    }

    private static void multiDimArray() {
        int[][] a = {{1, 2},
                {3, 4, 5, 6, 7},
                {8, 9, 0}
        };

        System.out.println("Multi-dimensional array:");

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
