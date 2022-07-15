package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Util {

    public static class file {

        public static void saveToFile(String path, String body) {

            try{
                RandomAccessFile stream = new RandomAccessFile(path, "rw");
                FileChannel channel = stream.getChannel();

                byte[] strBytes = body.getBytes();
                ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);
                buffer.put(strBytes);
                buffer.flip();
                channel.write(buffer);
            } catch (FileNotFoundException e){
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        public static void mkdir(String path) {
            new File(path).mkdirs();
        }

        public static String readFromFile(String path) {

            try (RandomAccessFile reader = new RandomAccessFile(path, "r")) {
                StringBuilder sb = new StringBuilder();

                String line;

                boolean isFirst = true;

                while ((line = reader.readLine()) != null) {
                    if (!isFirst) {
                        sb.append("\n");
                    }

                    sb.append(new String(line.getBytes("iso-8859-1"), "utf-8"));

                    isFirst = false;
                }

                return sb.toString();

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static void mkdir (String path) {
        File dir = new File(path);
        dir.mkdirs();
    }


    public static String readFromFile(String path) {

        try {
            RandomAccessFile reader = new RandomAccessFile(path, "r");
            String body = "";

            String line = null;
            while((line = reader.readLine()) != null) {
                body += new String(line.getBytes("iso-8859-1"), "utf-8") + "\n";
            }

            return body.trim();
        }
        catch (IOException e){

        }

        return "";
    }

    public static Map<String ,Object> jsonToMap(String json) {

        if(json.isEmpty()){
            return null;
        }

        final String[] jsonBits = json
                .replaceAll("\\{", "")
                .replaceAll("\\}", "")
                .split(",");


        final List<Object> bits = Stream.of(jsonBits)
                .map(String::trim)
                .flatMap(bit -> Arrays.stream(bit.split(":")))
                .map(String::trim)
                .map(s -> s.startsWith("\"") ? s.substring(1, s.length() - 1) : Integer.parseInt(s))
                .collect(Collectors.toList());

        Map<String, Object> map = IntStream
                .range(0, bits.size() / 2)
                .mapToObj(i -> Pair.of((String) bits.get(i * 2), bits.get(i * 2 + 1)))
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue(), (key1, key2) -> key1, LinkedHashMap::new));

        return map;
    }

}

class Pair {

    public static <T, U> Map.Entry<T, U> of (T first, U second) {
        return new AbstractMap.SimpleEntry<>(first, second);
    }
}