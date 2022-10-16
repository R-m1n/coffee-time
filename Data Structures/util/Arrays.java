package util;

import java.util.HashMap;
import java.util.Map;

public class Arrays {
    public static Integer mostFrequent(int[] numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;

        for (int number : numbers) {
            map.put(number, map.getOrDefault(number, 0) + 1);

            if (map.get(number) >= max)
                max = map.get(number);
        }

        for (int key : map.keySet()) {
            if (map.get(key) == max)
                return key;
        }

        return null;
    }
}
