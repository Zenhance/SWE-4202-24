package kenakata.catalog;

/** A line that may be returned, within a fixed number of days of the order being placed. */
public interface Returnable {

    /** Number of days after placement during which a return is still accepted. */
    int returnWindowDays();
}
