package dokan;

import java.util.HashMap;
import java.util.Map;

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
    Map<T,Integer> counts=new HashMap<>();

    /** Records one more sighting of {@code value}. */
    public void add(T value) {
        counts.merge(value,1,Integer::sum);

    }

    /** How many times {@code value} has been added. Zero if never. */
    public int count(T value) {
        return counts.getOrDefault(value,0);

    }

    /** How many different values have been counted. */
    public int distinct() {
        return counts.size();
    }

    /** The value seen most often, or an empty box if nothing has been counted yet. */
    public Box<T> mostCommon() {
        T best=null;
        int bestcount=-1;
        for (Map.Entry<T,Integer>entry:counts.entrySet()){
            if (entry.getValue()>bestcount){
                bestcount= entry.getValue();
                best= entry.getKey();}

        }
        return best == null ? Box.empty() : Box.of(best);

    }
}
