package dokan;

import java.util.List;
import java.util.concurrent.RecursiveTask;


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
    public static <T extends Item> int addAll(
            Shelf<T> shelf,
            List<? extends T> items) {

        int added = 0;

        for (T item : items) {
            if (shelf.add(item)) {
                added++;
            } else {
                break;
            }
        }

        return added;
    }
}

