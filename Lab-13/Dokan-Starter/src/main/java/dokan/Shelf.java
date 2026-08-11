package dokan;

import java.util.ArrayList;
import java.util.List;
public final class Shelf<T extends Item>{
    private final List<T> items;
    private final int capacity;
    public Shelf(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }
    public boolean add(T item){
        if (isFull()){
            return false;
        }
        items.add(item);
        return true;
    }
    public T get(int index) {
        return items.get(index);
    }
    public int size() {
        return items.size();
    }
    public boolean isEmpty() {
        return items.isEmpty();
    }
    public boolean isFull() {
        return items.size() == capacity;
    }
    public int capacity(){
        return capacity;
    }
    public boolean contains(String name) {
        for (T item : items) {
            if (item.name().equals(name)) {
                return true;
            }
        }
        return false;
    }
    public boolean remove(String name){
        for (int i = 0; i < items.size(); i++){
            if (items.get(i).name().equals(name)){
                items.remove(i);
                return true;
            }
        }
        return false;
    }
    public int totalPriceTaka(){
        int total = 0;
        for (T item : items){
            total += item.priceTaka();
        }
        return total;
    }
    public List<T> items(){
        return new ArrayList<>(items);
    }
}