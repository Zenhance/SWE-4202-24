package intern;

import shop.Book;


public class BookShelf {

    private final Book[] slots;
    private int count;

    public BookShelf(int capacity) {
        this.slots = new Book[capacity];
    }

    public boolean add(Book book) {
        if (count == slots.length) {
            return false;
        }
        slots[count++] = book;
        return true;
    }

    public Book get(int index) {
        return slots[index];
    }

    public int size() {
        return count;
    }

    public boolean remove(String name) {
        for (int i = 0; i < count; i++) {
            if (slots[i].name().equals(name)) {
                // FIXED: shift the rest down and shrink, so no hole is left behind.
                for (int j = i; j < count - 1; j++) {
                    slots[j] = slots[j + 1];
                }
                slots[--count] = null;
                return true;
            }
        }
        return false;
    }

    public int totalPriceTaka() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += slots[i].priceTaka();
        }
        return total;
    }
}
