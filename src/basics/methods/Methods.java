package basics.methods;

import java.util.Arrays;

public class Methods {

    public static void main(String[] args) {

        printMessage();
        printMessage("message!!!");
        System.out.println("Rectangle Square = "+calcRectangleSquare(5, 10));

        String str1 = "I love coffee";
        String str2 = null;
        String str3 = new String("I love coffee");
        System.out.println(str1==str3);
        System.out.println(str1.equals(str3));


        str1 = str1.toUpperCase();
        for (int i = str1.length(); i>0  ; i--) {
            if (i==str1.length()) str2 = str1.substring(i-1,i);
            else str2 += str1.charAt(i-1);
        }
        System.out.println(str2);

        String[] words = str2.split(" ");
        System.out.println(Arrays.toString(words));


    }

    public static void printMessage() {
        System.out.println("message...");
    }

    public static void printMessage(String string) {
        System.out.println(string);
    }

    public static int calcRectangleSquare(int x, int y) {
        return x * y;
    }


}
