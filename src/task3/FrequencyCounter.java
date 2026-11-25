package task3;

import java.util.LinkedHashMap;
import java.util.Map;

public class FrequencyCounter {

    public <T> Map<T, Long> frequency(T[] items) {
        Map<T, Long> result = new LinkedHashMap<>();

        for (T item : items) {
            result.merge(item, 1L, Long::sum);
        }

        return result;
    }
}
