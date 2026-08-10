package dokan;

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

    /** Records one more sighting of {@code value}. */
    public void add(T value) {
        throw new UnsupportedOperationException("TODO: Counter.add");
    }

    /** How many times {@code value} has been added. Zero if never. */
    public int count(T value) {
        throw new UnsupportedOperationException("TODO: Counter.count");
    }

    /** How many different values have been counted. */
    public int distinct() {
        throw new UnsupportedOperationException("TODO: Counter.distinct");
    }

    /** The value seen most often, or an empty box if nothing has been counted yet. */
    public Box<T> mostCommon() {
        throw new UnsupportedOperationException("TODO: Counter.mostCommon");
    }
}
