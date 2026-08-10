package dokan;

import java.util.List;

/**
 * TODO (step 4). Helpers that work on any shelf, of any kind of item.
 *
 * <p>Every method here is a <strong>static generic method</strong>: the {@code <T>}
 * sits on the method, not on the class. That is why callers write
 * {@code Shelves.cheapest(books)} and never {@code Shelves.<Book>cheapest(books)} —
 * the compiler works the type out from the argument. This is called
 * <em>inference</em>, and it is why generic code stays readable.
 *
 * <p>The wildcards in these signatures are the marked part. Do not "simplify" them;
 * unit tests pin them, and the lab sheet explains each one.
 */
public final class Shelves {

    private Shelves() {
        // a holder for static methods; no instances
    }

    /** The cheapest item on the shelf, or an empty box if the shelf is empty. */
    public static <T extends Item> Box<T> cheapest(Shelf<T> shelf) {
        throw new UnsupportedOperationException("TODO: Shelves.cheapest");
    }

    /**
     * The items on the shelf that pass the check, in shelf order.
     *
     * <p>PECS, the <em>consumer super</em> half: the check only <em>looks at</em>
     * items, so a check written for any {@code Item} works perfectly well on a shelf
     * of Books. Writing {@code Check<T>} here would reject that.
     */
    public static <T extends Item> List<T> keep(Shelf<T> shelf, Check<? super T> check) {
        throw new UnsupportedOperationException("TODO: Shelves.keep");
    }

    /**
     * The largest of the values.
     *
     * <p>{@code <T extends Comparable<T>>} is a bound that says "whatever T is, two of
     * them can be compared". Without it, {@code compareTo} could not be called at all.
     * The same method then works for Integers, Strings, or anything else comparable.
     * An empty list has no largest value, so refuse it.
     */
    public static <T extends Comparable<T>> T max(List<T> values) {
        throw new UnsupportedOperationException("TODO: Shelves.max");
    }

    /**
     * Pours items onto a shelf, stopping when it is full. Returns how many went on.
     *
     * <p>PECS, the <em>producer extends</em> half: the list only <em>hands over</em>
     * items, so a {@code List<Book>} can be poured onto a {@code Shelf<Item>}. Writing
     * {@code List<T>} here would reject that perfectly sensible line.
     */
    public static <T extends Item> int addAll(Shelf<T> shelf, List<? extends T> items) {
        throw new UnsupportedOperationException("TODO: Shelves.addAll");
    }
}
