package javaio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStream {

    public static void byteStream(String fileName) {
        try (FileInputStream reader = new FileInputStream(fileName);
             FileOutputStream writer = new FileOutputStream("ByteGradeBook.txt")) {

            int c;
            while ((c = reader.read()) != -1) {
                System.out.print(c + " ");
                writer.write(c);
            }
            System.out.println();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
