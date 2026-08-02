package kenakata.util;

/**
 * Small collection of whole-Taka rounding helpers. Every figure derived from a percentage in
 * KenaKata is rounded UP to the next whole Taka (ceiling), so this one utility is shared by the
 * catalogue (VAT, commission), add-ons (charge, VAT), and orders (discount, service fee,
 * insurance) rather than being reimplemented in each place.
 *
 * <p>Percentages are expressed in "permille" (parts per 1000) so that fractional rates such as
 * 7.5% (75 permille) or 15% (150 permille) can be computed with exact integer arithmetic instead
 * of floating point.
 */
public final class Money {

    private Money() {
    }

    /** Ceiling integer division: the smallest whole number &ge; numerator / denominator. */
    public static long ceilDiv(long numerator, long denominator) {
        if (denominator <= 0) {
            throw new IllegalArgumentException("denominator must be positive");
        }
        if (numerator <= 0) {
            return numerator == 0 ? 0 : -Math.floorDiv(-numerator, denominator);
        }
        return (numerator + denominator - 1) / denominator;
    }

    /** {@code amount * permille / 1000}, rounded up (e.g. permille 75 == 7.5%). */
    public static long ceilPermille(long amount, long permille) {
        if (amount == 0 || permille == 0) {
            return 0;
        }
        return ceilDiv(amount * permille, 1000);
    }

    /** {@code amount * percent / 100}, rounded up (e.g. percent 10 == 10%). */
    public static long ceilPercent(long amount, long percent) {
        if (amount == 0 || percent == 0) {
            return 0;
        }
        return ceilDiv(amount * percent, 100);
    }
}
