package dokan;

import java.util.List;
import java.util.ArrayList;

public final class Shelf<T extends Item> {

    private final List<T> items;
    private final int capacity;

    public Shelf(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public boolean add(T item) {
        if (items.size() >= capacity) {
            return false;
        }

        items.add(item);
        return true;
    }

    public T get(int index) {
        throw new UnsupportedOperationException("TODO: Shelf.get");
    }

    public int size() {
        return items.size();
    }

    public int capacity() {
        throw new UnsupportedOperationException("TODO: Shelf.capacity");
    }

    public boolean isFull() {
        return items.size() >= capacity;
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("TODO: Shelf.isEmpty");
    }

    public boolean contains(String name) {
        for (T item : items) {
            if (item.name().equals(name)) {
                return true;
            }
        }

        return false;
    }

    public boolean remove(String name) {
        throw new UnsupportedOperationException("TODO: Shelf.remove");
    }

    public int totalPriceTaka() {
        int total = 0;

        for (T item : items) {
            total += item.priceTaka();
        }

        return total;
    }

    public List<T> items() {
        throw new UnsupportedOperationException("TODO: Shelf.items");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("TODO: Shelf.toString");
    }
}