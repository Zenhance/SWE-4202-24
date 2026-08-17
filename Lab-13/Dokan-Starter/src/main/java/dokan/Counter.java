package dokan;

import java.util.HashMap;
import java.util.Map;


public final class Counter<T>
{
    private final Map<T, Integer> counts = new HashMap<>();
    public void add(T value)
    {
        counts.merge(value, 1, Integer::sum);
    }

    public int count(T value)
    {
        return counts.getOrDefault(value, 0);
    }

    public int distinct()
    {
        return counts.size();
    }

    public Box<T> mostCommon()
    {
        T best = null;
        int bestCount = -1;
        for(Map.Entry<T, Integer> entry : counts.entrySet())
        {
            if(entry.getValue() > bestCount)
            {
                best = entry.getKey();
                bestCount = entry.getValue();
            }
        }
        return best == null ? Box.empty() : Box.of(best);
    }
}