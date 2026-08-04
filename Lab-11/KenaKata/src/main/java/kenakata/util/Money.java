package kenakata.util;


public final class Money {

    private Money() {
    }

    public static long ceilDiv(long numerator, long denominator) {
        if (denominator <= 0) {
            throw new IllegalArgumentException("denominator must be positive");
        }
        if (numerator <= 0) {
            return numerator == 0 ? 0 : -Math.floorDiv(-numerator, denominator);
        }
        return (numerator + denominator - 1) / denominator;
    }

    public static long ceilPermille(long amount, long permille) {
        if (amount == 0 || permille == 0) {
            return 0;
        }
        return ceilDiv(amount * permille, 1000);
    }

    public static long ceilPercent(long amount, long percent) {
        if (amount == 0 || percent == 0) {
            return 0;
        }
        return ceilDiv(amount * percent, 100);
    }
}
