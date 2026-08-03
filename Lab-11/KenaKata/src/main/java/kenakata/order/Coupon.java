package kenakata.order;

import kenakata.exceptions.CouponRejectedException;

public final class Coupon {

    private final String code;
    private final int percentage;
    private final long cap;
    private final long minimumSpend;
    private final int lastValidDay;

    public Coupon(
            String code,
            int percentage,
            long cap,
            long minimumSpend,
            int lastValidDay) {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("Coupon code cannot be blank");
        }

        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Coupon percentage must be between 0 and 100");
        }

        if (cap < 0 || minimumSpend < 0 || lastValidDay < 0) {

            throw new IllegalArgumentException("Coupon limits cannot be negative"
            );
        }

        this.code = code;
        this.percentage = percentage;
        this.cap = cap;
        this.minimumSpend = minimumSpend;
        this.lastValidDay = lastValidDay;
    }

    public String code() {
        return code;
    }

    public long discountFor(long discountableBase, int currentDay)
            throws CouponRejectedException {

        if (discountableBase < 0 || currentDay < 0) {
            throw new IllegalArgumentException(
                    "Base and day cannot be negative"
            );
        }

        if (currentDay > lastValidDay) {
            throw new CouponRejectedException(
                    "Coupon " + code + " has expired"
            );
        }

        if (discountableBase < minimumSpend) {
            throw new CouponRejectedException(
                    "Coupon " + code
                            + " requires a minimum spend of Tk "
                            + minimumSpend
            );
        }

        long discount = ceilFraction(
                discountableBase,
                percentage,
                100
        );

        return Math.min(discount, cap);
    }

    private static long ceilFraction(long amount, long numerator, long denominator) {
        if (amount == 0 || numerator == 0) {
            return 0;
        }

        long multiplied = Math.multiplyExact(
                amount,
                numerator
        );

        long adjusted = Math.addExact(
                multiplied,
                denominator - 1
        );

        return adjusted / denominator;
    }
}