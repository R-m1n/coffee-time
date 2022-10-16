package util;

import java.util.Map;
import java.util.HashMap;

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

    public static Integer countPairsWithDiff(int[] numbers, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int pairs = 0;

        for (int number : numbers) {
            map.put(number + difference, number);
        }

        for (int number : numbers) {
            if (map.getOrDefault(number, Integer.MIN_VALUE) == number - difference)
                pairs++;
        }

        return pairs;
    }
}