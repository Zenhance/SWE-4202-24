package dokan;

import java.util.ArrayList;
import java.util.List;

public final class Shelves
{
    private Shelves()
    {

    }

    public static <T extends Item> Box<T> cheapest(Shelf<T> shelf)
    {
        if(shelf.isEmpty())
        {
            return Box.empty();
        }

        T best = shelf.get(0);
        for(T item : shelf.items())
        {
            if(item.priceTaka() < best.priceTaka())
            {
                best = item;
            }
        }
        return Box.of(best);
    }

    public static <T extends Item> List<T> keep(Shelf<T> shelf, Check<? super T> check)
    {
        List<T> result = new ArrayList<>();
        for(T item : shelf.items())
        {
            if(check.passes(item))
            {
                result.add(item);
            }
        }
        return result;
    }

    public static <T extends Comparable<T>> T max(List<T> values)
    {
        if(values.isEmpty())
        {
            throw new IllegalArgumentException("values must not be empty");
        }
        T best = values.get(0);
        for(T value : values)
        {
            if(value.compareTo(best) > 0)
            {
                best = value;
            }
        }
        return best;
    }

    public static <T extends Item> int addAll(Shelf<T> shelf, List<? extends T> items)
    {
        int added = 0;
        for (T item : items)
        {
            if(shelf.add(item))
            {
                added++;
            }
            else
            {
                break;
            }
        }
        return added;
    }
    }