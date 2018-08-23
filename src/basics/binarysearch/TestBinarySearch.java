package basics.binarysearch;

public class TestBinarySearch {

    public static void main(String[] args) {

        int[] arr = {10,20,30,40,50,60,70,80,90};

        /*---Test binary search implemented using recursion---*/

        System.out.println("Index for [0] is: "+BinarySearchR.binarySearchR(arr,0, arr.length-1,0));
        for (int i : arr) {
            System.out.println("Index for ["+i+"] is: "+BinarySearchR.binarySearchR(arr,0, arr.length-1,i));
        }
        System.out.println("Index for 100 is: "+BinarySearchR.binarySearchR(arr,0, arr.length-1,100));



        /*---Test binary search implemented using loops---*/

        System.out.println("Index for 1 is: "+BinarySearchL.binarySearchL(arr, 1));
        for (int i : arr) {
           System.out.println("Index for ["+i+"] is: "+BinarySearchL.binarySearchL(arr, i));
       }
        System.out.println("Index for 100 is: "+BinarySearchL.binarySearchL(arr, 100));

    }
}
