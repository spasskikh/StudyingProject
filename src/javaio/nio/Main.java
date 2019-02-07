package javaio.nio;

import java.io.IOException;

public class Main {

    private final static String FILE = "file.bin";

    public static void main(String[] args) throws IOException {
//        ChannelService channel = new ChannelService();
//        channel.readWithChannel(FILE);
//        channel.writeWithChannel(FILE);
//        channel.writeWithRandomAccess(FILE);

       Directories dirs = new Directories();
       dirs.processDirectory("temp");

    }
}
