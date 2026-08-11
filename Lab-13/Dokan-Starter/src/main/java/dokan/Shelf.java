package dokan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public final class Shelf<T extends Item> {
    private final int capacity;
    private final List<T> items = new ArrayList<>();

    public Shelf(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cant be negative");
        }
        this.capacity = capacity;
    }
    public boolean add(T item){
        if(isFull()){
            return false;
        }
        items.add(item);
        return true;
    }
    public T get(int index){
        return items.get(index);
    }
    public int size(){
        return items.size();
    }
    public int capacity(){
        return capacity;
    }
    public boolean isFull(){
        return size()==capacity;
    }
    public boolean isEmpty(){
        return items.isEmpty();
    }
    public boolean contains(String name){
        for(T item : items){
            if(item.name().equals(name)){
                return true;
            }
        }
        return false;
    }
    public boolean remove(String name){
        for(int i =0;i<items.size();i++){
            if(items.get(i).name().equals(name)){
                items.remove(i);
                return true;
            }
        }
        return false;
    }
    public int totalPriceTaka(){
        int total=0;
        for(T item: items){
            total+=item.priceTaka();
        }
        return total;
    }
    public List<T> items(){
        return Collections.unmodifiableList(items);
    }
}