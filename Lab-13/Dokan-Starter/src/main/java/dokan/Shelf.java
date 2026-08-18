package dokan;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Shelf<T extends Item>{
    private final int capacity;
    private final List<T> items;
    public Shelf(int capacity){
        if(capacity<0){
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
        this.capacity=capacity;
        this.items=new ArrayList<>();
    }
    public boolean add (T item){
        if(item==null){
            throw new NullPointerException("item");
        }
        if (isFull()){
            return false;
        }
        items.add(item);
        return true;
    }
    public T get(int index){
        return items.get(Index);
    }
    public int size(){
        return items.size();
    }
    public int capacity(){
        return capacity;
    }
    public boolean isFull(){
        return size()>=capacity;
    }
    public boolean isEmpty(){

    }
}