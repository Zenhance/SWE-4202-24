package kenakata.order;

import kenakata.exceptions.CouponRejectedException;
import kenakata.money.Money;

public final class Coupon {

    private final String code;
    private final int percentage;
    private final long cap;
    private final long minimumSpend;
    private final int validThroughDay;

    public Coupon(String code, int percentage, long cap, long minimumSpend, int validThroughDay) {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("code must not be blank");
        }
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("percentage must be between 0 and 100");
        }
        if (cap < 0) {
            throw new IllegalArgumentException("cap must not be negative");
        }
        if (minimumSpend < 0) {
            throw new IllegalArgumentException("minimumSpend must not be negative");
        }
        this.code = code;
        this.percentage = percentage;
        this.cap = cap;
        this.minimumSpend = minimumSpend;
        this.validThroughDay = validThroughDay;
    }

    public String code() {
        return code;
    }

    /** The discount for a discountable base on the given day, or a refusal if invalid. */
    public long discountFor(long discountableBase, int today) throws CouponRejectedException {
        if (today > validThroughDay) {
            throw new CouponRejectedException(code + " expired on day " + validThroughDay);
        }
        if (discountableBase < minimumSpend) {
            throw new CouponRejectedException(
                    code + " requires a minimum spend of " + minimumSpend);
        }
        long raw = Money.ceilPercent(discountableBase, percentage);
        return Math.min(raw, cap);
    }
}
