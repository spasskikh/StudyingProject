package basics.other;

public class Transpose {

    public static void main(String[] args) {

        int c = 4;
        int r = 3;

        int[][] array = new int[c][r];

        for (int i = 0 ; i<array.length ; i++) {
            int v = 1;
            for (int j = 0 ; j<array[i].length ; j++) {
                array[i][j] = v;
                v++;
            }
        }

        toString(array);

        System.out.println();

        int[][] newArr = transpose(array);

        toString(newArr);


    }

    public static int [][] transpose (int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;

        int[][] newArr = new int[c][r];

        for (int i = 0 ; i < newArr.length ; i++) {
            for (int j = 0 ; j < arr.length ; j++)
            newArr[i][j] = arr[j][i];
        }

        return newArr;

    }

    public static void toString (int [][] arr) {

        for (int[] a : arr) {
            System.out.print("[ ");
            for (int i : a) {
                System.out.print(i+" ");
            }
            System.out.print("]");
            System.out.println();
        }

    }


}
