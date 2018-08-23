package basics.lambdas.others;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        List<String> bunnies = new ArrayList<>();

        bunnies.add("long ear");
        bunnies.add("hoppy");
        bunnies.add("floppy");

        System.out.println(bunnies);

//        bunnies.forEach(System.out::print);

        System.out.println();

        bunnies.removeIf(a -> a.startsWith("h"));

        System.out.println(bunnies);
    }
}
