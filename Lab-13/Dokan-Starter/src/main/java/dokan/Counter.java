package dokan;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO (step 3). Counts how many times each value has been seen.
 *
 * <p>Rahim uses it to find his best-selling item, but notice that {@code T} has
 * <em>no bound at all</em> here — this class does not need to know what an item is,
 * so it does not ask. The very same class counts Strings, Integers, Books or anything
 * else. Write it once, use it everywhere.
 *
 * <p>Hints:
 * <ul>
 *   <li>A {@code Map<T, Integer>} is all the state you need.</li>
 *   <li>{@link #mostCommon()} returns a {@code Box<T>}: the type parameter travels
 *       from this generic class straight into the other one. When nothing has been
 *       counted, that is an empty box — no null, no special case at the call site.</li>
 * </ul>
 */
public final class Counter<T> {
    private List<T> items = new ArrayList<>();

    /** Records one more sighting of {@code value}. */
    public void add(T value) {
        items.add(value);
    }

    /** How many times {@code value} has been added. Zero if never. */
    public int count(T value) {
        int count = 0;
        for (T item : items) {
            if (item.equals(value)) {
                count++;
            }
        }
        return count;
    }

    /** How many different values have been counted. */
    public int distinct() {
        List<T> itemsCopy = new ArrayList<>(items.size());
        for (T item : items) {
            if(!itemsCopy.contains(item)) {
                itemsCopy.add(item);
            }
        }
        return itemsCopy.size();
    }

    /** The value seen most often, or an empty box if nothing has been counted yet. */
    public Box<T> mostCommon() {
        if (items.isEmpty()) {
           return new Box<>(null);
        }
        T mostCommon = items.get(0);
        int highestCount = count(mostCommon);
        for (T item : items) {
            int currentCount = count(item);
            if (currentCount > highestCount) {
                highestCount = currentCount;
                mostCommon = item;
            }
        }
        return new Box<>(mostCommon);
    }
}
