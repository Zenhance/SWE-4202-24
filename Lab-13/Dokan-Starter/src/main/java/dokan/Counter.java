package dokan;

import java.util.HashMap;


public final class Counter<T>{
    private final Map<T,Integer> counts = new HashMap<>();
    public void add(T value){
        counts.put(value,count(value)+1);
    }
    public int count(T value){
        return counts.getOrDefault(value, 0);
    }
    public int distinct() {
        return counts.size();
    }
    public Box<T> mostCommon() {
        if (counts.isEmpty()) {
            return Box.empty();
        }

        T mostCommon = null;
        int highestCount = -1;
}