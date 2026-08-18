package dokan;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO (step 2). A shelf of fixed capacity holding items of one kind.
 *
 * <p>{@code <T extends Item>} is a <strong>bounded</strong> type parameter, and it is
 * the heart of this lab. The bound does two jobs at once:
 * <ul>
 *   <li>it lets {@link #totalPriceTaka()} call {@code priceTaka()} on a {@code T},
 *       because every {@code T} is guaranteed to be an {@code Item}. Delete the bound
 *       and that method stops compiling — try it, it is worth seeing;</li>
 *   <li>it makes {@code Shelf<String>} a compile error, because a String is not an
 *       Item and has no business being on Rahim's shelf.</li>
 * </ul>
 *
 * <p>And a {@code Shelf<Book>} refuses a Snack at compile time, not at the till.
 * That is the intern's PAIN 1, fixed.
 *
 * <p><strong>About the storage.</strong> You probably want {@code new T[capacity]}.
 * You cannot have it: Java erases type parameters, so at run time there is no
 * {@code T} to make an array of. Use an {@code ArrayList<T>} and keep the capacity in
 * an {@code int} instead. Your submitted README must mention this.
 *
 * <p>Other hints: {@code add} returns {@code false} when the shelf is full — being
 * full is ordinary, not exceptional. {@code remove} must close the gap it leaves, or
 * you will have reinvented the intern's PAIN 2. {@code items()} must not let the
 * caller change the shelf.
 */
public final class Shelf<T extends Item> {

    private final List<T> items;
    private final int capacity;

    public Shelf(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        this.items = new ArrayList<>(capacity);
    }

    /** Puts an item on the shelf. Returns false, without adding, if the shelf is full. */
    public boolean add(T item) {
        if(items.size() == capacity) {
            return false;
        }
        items.add(item);
        return true;
    }

    public T get(int index) {
        if(index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        return items.get(index);
    }

    public int size() {
        return items.size();
    }

    public int capacity() {
        return capacity;
    }

    public boolean isFull() {
        return items.size() ==  capacity;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public boolean contains(String name) {
        for(T item : items) {
            if(item.name().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /** Takes the first item with this name off the shelf. True if one was there. */
    public boolean remove(String name) {
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).name().equals(name)) {
                items.remove(i);
                return true;
            }
        }
        return false;
    }

    /** What everything on the shelf is worth. This is the method the bound pays for. */
    public int totalPriceTaka() {
        int total = 0;
        for(T item : items) {
            total += item.priceTaka();
        }
        return total;
    }

    /** The items, as a list the caller cannot use to change the shelf. */
    public List<T> items() {
        return List.copyOf(items);
    }

    @Override
    public String toString() {
        return items.toString();
    }
}
