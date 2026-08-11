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

    private final List<T> uniqueItems = new ArrayList<>();
    private final List<Integer> counts = new ArrayList<>();

    /** Records one more sighting of {@code value}. */
    public void add(T value) {
        int index = uniqueItems.indexOf(value);

        if (index == -1) {
            uniqueItems.add(value);
            counts.add(1);
        } else {
            int currentCount = counts.get(index);
            counts.set(index, currentCount + 1);
        }
    }

    /** How many times {@code value} has been added. Zero if never. */
    public int count(T value) {
        int index = uniqueItems.indexOf(value);
        if (index == -1) {
            return 0; // Item not found
        }
        return counts.get(index);
    }

    /** How many different values have been counted. */
    public int distinct() {
        return uniqueItems.size();
    }

    /** The value seen most often, or an empty box if nothing has been counted yet. */
    public Box<T> mostCommon() {
        if (uniqueItems.isEmpty()) {
            return Box.empty();
        }

        int maxIndex = 0;
        int maxCount = counts.get(0);

        // Find the index of the highest count
        for (int i = 1; i < counts.size(); i++) {
            if (counts.get(i) > maxCount) {
                maxCount = counts.get(i);
                maxIndex = i;
            }
        }

        // Return the item that corresponds to the highest count
        return Box.of(uniqueItems.get(maxIndex));
    }
}