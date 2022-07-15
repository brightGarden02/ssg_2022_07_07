package package1;

import java.util.AbstractMap;
import java.util.Map;

public class Pair {

    // return a map entry (key-value pair) from the specified values
    public static <T, U> Map.Entry<T, U> of (T first, U second) {
        return new AbstractMap.SimpleEntry<>(first, second);
    }
}
