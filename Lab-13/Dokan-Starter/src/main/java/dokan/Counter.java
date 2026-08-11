package dokan;
import java.util.List;
import java.util.ArrayList;



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
    private final List<T> values = new ArrayList<>();
    private final List<Integer> counts = new ArrayList<>();
    /** Records one more sighting of {@code value}. */
    public void add(T value) {
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i).equals(value)) {
                counts.set(i, counts.get(i) + 1);
                return;
            }
        }
        values.add(value);
        counts.add(1);
    }

    /** How many times {@code value} has been added. Zero if never. */
    public int count(T value) {
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i).equals(value)) {
                return counts.get(i);
            }
        }
        return 0; }

    /** How many different values have been counted. */
    public int distinct() {
    return values.size();}

    /** The value seen most often, or an empty box if nothing has been counted yet. */
    public Box<T> mostCommon() {
        if (values.isEmpty()) {
            return Box.empty();
        }
        int bestIndex = 0;
        for (int i = 1; i < values.size(); i++) {
            if (counts.get(i) > counts.get(bestIndex)) {
                bestIndex = i;
            }
        }
        return Box.of(values.get(bestIndex));
    }}

