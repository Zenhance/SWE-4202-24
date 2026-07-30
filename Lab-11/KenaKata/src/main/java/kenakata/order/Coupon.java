package kenakata.order;

import kenakata.exceptions.CouponRejectedException;

public class Coupon {
    private final String code;
    private final int percent;
    private final long cap;
    private final long minimumSpend;
    private final int lastValidDay;
    public Coupon(String code, int percent, long cap, long minimumSpend, int lastValidDay) {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException();
        }
        if (percent<0 || percent>100) {
            throw new IllegalArgumentException();
        }
        this.code = code;
        this.percent = percent;
        this.cap = cap;
        this.minimumSpend = minimumSpend;
        this.lastValidDay = lastValidDay;
    }
    public String code() {
        return code;
    }
    public long discount(long discountableBase, int today) throws CouponRejectedException {
        if (today > lastValidDay)
            throw new CouponRejectedException("Coupon expired");
        if (discountableBase < minimumSpend)
            throw new CouponRejectedException("Minimum spend not met");
        long amount = (long) Math.ceil(discountableBase * percent / 100.0);
        return Math.min(amount, cap);
    }
}
