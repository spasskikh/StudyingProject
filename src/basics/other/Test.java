package basics.other;

import java.util.Arrays;

public class Test {

    public static void main(String args[]) {

        String T = "E";

        String[] target = new String[T.length()];
        for (int i = 0; i < target.length; i++) {
            target[i] = T.substring(i, i + 1);
        }

        String[] abcd = {"a", "b", "c", "d", "e", "f", "g", "h", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        Arrays.sort(abcd);
        System.out.println(Arrays.binarySearch(abcd, "E".toLowerCase()));

        int[] indexes = new int[target.length];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = Arrays.binarySearch(abcd, target[i].toLowerCase());
            System.out.println(target[i]);
            System.out.println(indexes[i]);
        }
//        System.err.println(target[0]);
//        System.err.println(indexes[0]);
//        String[] abcdHashtag = new String[5];
//
//        for (int i = 0; i < H; i++) {
//            String ROW = in.nextLine();
//            abcdHashtag[i] = ROW;
//        }
//
//        int start = indexes[0]*4;
//        int end = start+4;
//
//        for (String s : abcdHashtag) {
//            System.out.println(s.substring(start,end));
//        }
    }
}

