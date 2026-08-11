package dokan;

import java.util.HashMap;
import java.util.Map;

public final class Counter<T> {

    private final Map<T, Integer> counts = new HashMap<>();

    public void add(T value) {
        counts.put(value, counts.getOrDefault(value, 0) + 1);
    }


    public int count(T value) {
        return counts.getOrDefault(value, 0);
    }


    public int distinct() {
        return counts.size();
    }


    public Box<T> mostCommon() {

        if (counts.isEmpty()) {
            return Box.empty();
        }

        T mostCommonValue = null;
        int highestCount = 0;

        for (Map.Entry<T, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > highestCount) {
                highestCount = entry.getValue();
                mostCommonValue = entry.getKey();
            }
        }

        return Box.of(mostCommonValue);
    }
}