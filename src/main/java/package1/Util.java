package package1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Util {

    public static void saveToFile(String path, String body) {

        try {
            RandomAccessFile stream = new RandomAccessFile(path, "rw");
            FileChannel channel = stream.getChannel();

            byte[] strBytes = body.getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);
            buffer.put(strBytes);

            buffer.flip();
            channel.write(buffer);
            stream.close();
            channel.close();

        } catch (IOException e) {

        }

    }

    public static void mkdir (String path) {
        File dir = new File(path);
        dir.mkdirs();
    }


    public static String getFromFile(String path) {

        try {
            RandomAccessFile reader = new RandomAccessFile(path, "r");
            String body = reader.readLine();
            reader.close();
        }
        catch (IOException e){

        }

        return "";
    }

}
