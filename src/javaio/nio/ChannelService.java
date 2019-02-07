package javaio.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static java.nio.file.StandardOpenOption.*;

public class ChannelService {

    public void readWithChannel(String fileName) throws IOException {
        RandomAccessFile file = new RandomAccessFile(fileName, "rw");
        FileChannel channel = file.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(100);
        int bytesNumber = channel.read(buffer);

        while (bytesNumber > 0) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }
            buffer.clear();
            bytesNumber = channel.read(buffer);
        }
        channel.close();
    }

    public void writeWithChannel(String fileName) throws IOException {

        String str = "Some new text";

        RandomAccessFile file = new RandomAccessFile(fileName, "rw");
        FileChannel channel = file.getChannel();

        ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());

        channel.write(buffer);
        channel.close();
    }

    public void writeWithRandomAccess(String fileName) throws IOException {
        String someText = "MARKED_AREA";
        ByteBuffer mark = ByteBuffer.wrap(someText.getBytes());
        ByteBuffer buffer = ByteBuffer.allocate(10);

        Path path = Paths.get(fileName);

        try (FileChannel channel = FileChannel.open(path, READ, WRITE)) {
            int numBytes = 0;
            while (buffer.hasRemaining() && numBytes != -1) {
                channel.read(buffer);
            }
            channel.position(0);
            channel.write(mark);

            long size = channel.size();
            channel.position(size/2);
            mark.rewind();
            channel.write(mark);

            channel.position(size-someText.length());
            mark.rewind();
            channel.write(mark);
            channel.write(buffer);
        }
    }
}
