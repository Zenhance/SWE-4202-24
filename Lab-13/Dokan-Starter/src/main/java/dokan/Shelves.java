package dokan;

import java.util.List;
import java.util.concurrent.RecursiveTask;

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
        if(shelf.isEmpty()){
            return Box.empty();
        }
        T cheapest = shelf.get(0);

        for (int i = 1; i < shelf.size(); i++) {
            T current = shelf.get(i);

            if (current.priceTaka() < cheapest.priceTaka()) {
                cheapest = current;
            }
        }
        return Box.of(cheapest);
    }
    public static  <T extends Item> List<T> keep(
            Shelf<T> shelf,
            Check<? super T> check) {

        List<T> result = new ArrayList<>();
        for (int i = 0; i < shelf.size(); i++) {
            T item = shelf.get(i);

            if (check.test(item)) {
                result.add(item);
            }
        }

        return result;
    }
    public static <T extends Comparable<T>> T max(List<T> values) {

        if (values.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }

        T maximum = values.get(0);

        for (int i = 1; i < values.size(); i++) {
            T current = values.get(i);

            if (current.compareTo(maximum) > 0) {
                maximum = current;
            }
        }
        return maximum;
    }

