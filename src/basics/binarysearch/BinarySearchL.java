package basics.binarysearch;

public class BinarySearchL {

    public static int binarySearchL (int[] arr, int i) {

        int start = 0;
        int end = arr.length-1;

        while (start <= end) {
//            System.out.println(start);
            int mid = start + (end - start)/2;
            if (i == arr[mid]) {
                return mid;
            }
            else if (i < arr[mid]) {
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        return -1;
    }
}
