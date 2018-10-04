package basics.other.transform.controller;

public class Transformer {

    public static String binary(int i) {
        return "0b"+transform(i,2);
    }

    public static String octal(int i) {
        return "0" + transform(i,8);
    }

    public static String hexadecimal(int i) {
        return "0x" +transform(i,16);
    }

    private static String transform(int i, int base) {
        StringBuilder sb = new StringBuilder();

        while (i > (base - 1)) {
            sb.append(i % base);
            i = i / base;
        }
        sb.append(i % base);


        return sb.reverse().toString();
    }

}
