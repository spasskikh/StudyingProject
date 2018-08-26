package collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToArray {

    public static void main(String[] args) {

        String[] colors = {"black", "red", "blue"};

        List<String> list = new ArrayList<>(Arrays.asList(colors));

        list.add("yellow");

        colors = list.toArray(new String[0]);

        for (String str: colors) {
            System.out.println(str);
        }
    }
}
