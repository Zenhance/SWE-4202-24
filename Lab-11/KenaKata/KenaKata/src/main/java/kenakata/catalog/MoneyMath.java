package kenakata.catalog;

public final class MoneyMath {
    private MoneyMath() {}

    public static long ceilRate(long amount, long numerator, long denominator) {
        if (amount < 0 || numerator < 0 || denominator <= 0) {
            throw new IllegalArgumentException("not a valid percent");
        }
        if (amount == 0 || numerator == 0) {
            return 0;
        }
        long product = Math.multiplyExact(amount, numerator);
        return Math.floorDiv(Math.addExact(product, denominator - 1), denominator);
    }
}
