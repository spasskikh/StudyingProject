package cg;

public class UnaryEncoding {

    public static void main(String[] args) {

        String str = "This is a String!";

        char[] chars = str.toCharArray();

        StringBuilder input = new StringBuilder();

        for (char c : chars) {
            String binaryString = Integer.toBinaryString(c);
            if (binaryString.length() < 7) {
                input.append("0" + binaryString);
            } else {
                input.append(binaryString);
            }
        }

        int[] binary = new int[input.length()];
        for (int i = 0; i < binary.length; i++) {
            binary[i] = Integer.parseInt(Character.toString(input.charAt(i)));
        }

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < binary.length; i++) {
            if (binary[i] == 1) {
                output.append("0 ");
                while (i < binary.length && binary[i] == 1) {
                    output.append("0");
                    i++;
                }
                i--;
            } else {
                output.append("00 ");
                while (i < binary.length && binary[i] == 0) {
                    output.append("0");
                    i++;
                }
                i--;
            }
            if (i < binary.length - 1) {
                output.append(" ");
            }
        }
        System.out.println(output);


    }
}
