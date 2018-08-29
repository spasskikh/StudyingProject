package basics.binarysearch;

public class BinarySearchR {

    public static int binarySearchR (int[] arr, int start, int end, int key) {

        if (start > end) {
            return -1;
        } else {
            int mid = (start + end) / 2;
            if (key == arr[mid]) {
                return mid;
            } else if (key < arr[mid]) {
                return binarySearchR(arr, start,mid-1, key);
            } else {
                return binarySearchR(arr,mid+1, end, key);
            }
        }
    }
}
