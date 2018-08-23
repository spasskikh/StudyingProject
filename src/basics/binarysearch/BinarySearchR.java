package basics.binarysearch;

public class BinarySearchR {

    public static int binarySearchR (int[] arr, int start, int end, int i) {

        if (start > end) {
            return -1;
        } else {
            int mid = (start + end) / 2;
            if (i == arr[mid]) {
                return mid;
            } else if (i < arr[mid]) {
                return binarySearchR(arr, start,mid-1, i);
            } else {
                return binarySearchR(arr,mid+1, end, i);
            }
        }
    }
}
