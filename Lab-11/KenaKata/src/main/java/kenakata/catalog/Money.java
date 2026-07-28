package kenakata.catalog;
final class Money {

    private Money() {
    }

    static long ceilFraction(
            long amount,
            long numerator,
            long denominator
    ) {
        if (amount < 0 || numerator < 0 || denominator <= 0) {
            throw new IllegalArgumentException(
                    "Invalid percentage calculation"
            );
        }

        if (amount == 0 || numerator == 0) {
            return 0;
        }

        long multiplied = Math.multiplyExact(amount, numerator);
        long adjusted = Math.addExact(multiplied, denominator - 1);

        return adjusted / denominator;
    }
}