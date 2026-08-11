package dokan;

import java.util.HashMap;


public final class Counter<T>{
    private final Map<T,Integer> counts = new HashMap<>();
    public void add(T value){
        counts.put(value,count(value)+1);
    }
}