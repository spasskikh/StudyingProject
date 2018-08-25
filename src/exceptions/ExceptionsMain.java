package exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionsMain {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean continueLoop = true;

        do {
            try {
                System.out.println("Please enter numerator:");
                int numerator = scanner.nextInt();

                System.out.println("Please enter denominator:");
                int denominator = scanner.nextInt();

//                System.out.println(divide(numerator,denominator));
                saveToFile(divide(numerator, denominator));
                continueLoop = false;

                throw new InvalidInputParamException("Tetsing exception");

            } catch (ArithmeticException | InputMismatchException exc) {
                exc.printStackTrace();
                System.out.println("Only integer non zero parameters allowed.");
                scanner.nextLine();
            } catch (InvalidInputParamException exc) {
                exc.printStackTrace();
            }
            System.out.println("Try/catch block finished.");
        } while (continueLoop);

    }

    private static int divide(int numerator, int denominator) throws ArithmeticException {
        return numerator / denominator;
    }

    private static void saveToFile(int i) {
//        PrintWriter writer = null;

        /*Resources should implement AutoClosable*/

        try (PrintWriter writer = new PrintWriter(new FileWriter("auto.txt"))) {
//            writer = new PrintWriter(new FileWriter("auto.txt"));
            writer.println("Result = " + i);
        } catch (IOException exc) {
            exc.printStackTrace();
        } /*finally {
            System.out.println("Finally block called.");
            if (writer != null) {
                writer.close();
            }
        }*/
    }
}
