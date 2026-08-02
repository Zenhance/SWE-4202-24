package kenakata.catalog;

/**
 * A line that has weight and therefore ships. The delivery calculator totals the weight of only
 * the lines that implement this capability; everything else (digital goods, add-ons) is ignored.
 */
public interface Weighable {

    /** Weight, in grams, of a single unit of this line. */
    long unitWeightGrams();
}
