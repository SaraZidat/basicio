import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Exercise1 {
    public static void main(String[] args) throws IOException {
        String inputStream = "input.txt";
        String outputStream = "output.txt";

        copier(inputStream, outputStream);
    }

    private static void copier(String inputStream, String outputStream) throws IOException {
        FileInputStream src = new FileInputStream(inputStream);
        FileOutputStream dest = new FileOutputStream(outputStream);

        FileChannel inChannel = src.getChannel();
        FileChannel outChannel = dest.getChannel();

        for(ByteBuffer buffer = ByteBuffer.allocate(1024*1024);
        inChannel.read(buffer) != -1;
        buffer.clear()){
            buffer.flip();
            while (buffer.hasRemaining()) outChannel.write(buffer);
        }

        inChannel.close();
        outChannel.close();

    }
}
