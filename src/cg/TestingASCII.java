package cg;

import java.util.Arrays;

public class TestingASCII {

    public static void main(String[] args) {

        /*Initial parameters*/
        int L = 4;
        int H = 5;
        String[] hashesInit = getASCII();

        String T = "MANHATTAN";
        String[] target = new String[T.length()];
        for (int i = 0; i < target.length; i++) {
            target[i] = Character.toString(T.charAt(i)).toLowerCase();
        }

        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "?"};

        String[][] hashes = new String[H][hashesInit[0].length() / L];

        for (int i = 0; i < hashes.length; i++) {
            int start = 0;
            for (int j = 0; j < hashes[i].length; j++) {
                hashes[i][j] = hashesInit[i].substring(start, start + L);
                start += L;
            }
        }

        StringBuilder[] output = new StringBuilder[H];
        for (int i = 0; i < output.length; i++) {
            output[i] = new StringBuilder();
            for (int j = 0; j < target.length; j++) {
                int key = Arrays.binarySearch(alphabet, target[j]);
                if (key < 0) {
                    output[i].append(hashes[i][alphabet.length - 1]);
                } else {
                    output[i].append(hashes[i][key]);
                }
            }
        }

        for (StringBuilder str : output)
            System.out.println(str.toString());

    }

    private static String[] getASCII () {

        String[] arr = new String[5];
        arr[0] = " #  ##   ## ##  ### ###  ## # # ###  ## # # #   # # ###  #  ##   #  ##   ## ### # # # # # # # # # # ### ### ";
        arr[1] = "# # # # #   # # #   #   #   # #  #    # # # #   ### # # # # # # # # # # #    #  # # # # # # # # # #   #   # ";
        arr[2] = "### ##  #   # # ##  ##  # # ###  #    # ##  #   ### # # # # ##  # # ##   #   #  # # # # ###  #   #   #   ## ";
        arr[3] = "# # # # #   # # #   #   # # # #  #  # # # # #   # # # # # # #    ## # #   #  #  # # # # ### # #  #  #       ";
        arr[4] = "# # ##   ## ##  ### #    ## # # ###  #  # # ### # # # #  #  #     # # # ##   #  ###  #  # # # #  #  ###  #  ";

        return arr;

    }
}
