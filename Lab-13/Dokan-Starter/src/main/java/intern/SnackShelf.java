package intern;

import shop.Snack;

/**
 * THE INTERN'S SNACK SHELF — copy two of two.
 *
 * <p>Identical to {@link BookShelf} apart from the word {@code Snack}... and apart
 * from never getting the fix. Removing an item here blanks the slot but leaves the
 * count alone, so the shelf keeps a hole in the middle. The bug was found once and
 * fixed once, and it is still live right here.
 */
public class SnackShelf {

    private final Snack[] slots;
    private int count;

    public SnackShelf(int capacity) {
        this.slots = new Snack[capacity];
    }

    public boolean add(Snack snack) {
        if (count == slots.length) {
            return false;
        }
        slots[count++] = snack;
        return true;
    }

    public Snack get(int index) {
        return slots[index];
    }

    public int size() {
        return count;
    }

    public boolean remove(String name) {
        for (int i = 0; i < count; i++) {
            if (slots[i] != null && slots[i].name().equals(name)) {
                slots[i] = null;        // NOT FIXED: a hole, and count still says 3
                return true;
            }
        }
        return false;
    }

    public int totalPriceTaka() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += slots[i].priceTaka();      // NullPointerException on the hole
        }
        return total;
    }
}
