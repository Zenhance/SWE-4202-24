package intern;

import shop.Book;

/**
 * THE INTERN'S BOOK SHELF — copy one of two.
 *
 * <p>This is the copy somebody remembered to fix: see the line marked FIXED, which
 * closes the gap after a removal. {@link SnackShelf} is the same thirty lines
 * <em>without</em> that fix, because it is a copy, not another instance of the same
 * class.
 */
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
