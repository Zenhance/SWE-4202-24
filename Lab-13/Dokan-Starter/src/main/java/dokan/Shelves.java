package dokan;

import java.util.ArrayList;
import java.util.List;

public final class Shelves {

    private Shelves() {

    }


    public static <T extends Item> Box<T> cheapest(Shelf<T> shelf) {

        T cheapest = null;

        for (T item : shelf.items()) {
            if (cheapest == null || item.priceTaka() < cheapest.priceTaka()) {
                cheapest = item;
            }
        }

        if (cheapest == null) {
            return Box.empty();
        }

        return Box.of(cheapest);
    }

    public static <T extends Item> List<T> keep(
            Shelf<T> shelf,
            Check<? super T> check) {

        List<T> result = new ArrayList<>();

        for (T item : shelf.items()) {
            if (check.passes(item)) {
                result.add(item);
            }
        }

        return result;
    }

    public static <T extends Comparable<T>> T max(List<T> values) {

        if (values.isEmpty()) {
            throw new IllegalArgumentException("Cannot find max of empty list");
        }

        T maximum = values.get(0);

        for (T value : values) {
            if (value.compareTo(maximum) > 0) {
                maximum = value;
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