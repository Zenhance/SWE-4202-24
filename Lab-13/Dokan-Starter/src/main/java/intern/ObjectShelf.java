package intern;

/**
 * THE INTERN'S SHELF. This is the code you are replacing.
 *
 * <p>It holds {@code Object}, so it will hold anything at all and tell you nothing
 * about what came back out. Every caller has to cast, and every cast is a promise the
 * compiler cannot check.
 */
public class ObjectShelf {

    private final Object[] slots;
    private int count;

    public ObjectShelf(int capacity) {
        this.slots = new Object[capacity];
    }

    /** Takes anything. A Book, a Snack, a String, a Thursday. */
    public boolean add(Object item) {
        if (count == slots.length) {
            return false;
        }
        slots[count++] = item;
        return true;
    }

    /** Gives back an Object, so the caller must cast and hope. */
    public Object get(int index) {
        return slots[index];
    }

    public int size() {
        return count;
    }

    /** Returns null when the shelf is empty, which the caller always forgets. */
    public Object cheapest() {
        if (count == 0) {
            return null;
        }
        Object best = slots[0];
        for (int i = 1; i < count; i++) {
            if (price(slots[i]) < price(best)) {
                best = slots[i];
            }
        }
        return best;
    }

    /** And here is the cast, in the middle of the shelf itself. */
    private int price(Object item) {
        return ((shop.Book) item).priceTaka();
    }
}
