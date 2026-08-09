package kenakata.order;

import kenakata.exceptions.CouponRejectedException;

public class Coupon {
    private final String code;
    private final int percent;
    private final long maxDiscount;
    private final long minimumSubtotal;
    private final int expiryDay;

    public Coupon(String code, int percent, long maxDiscount, long minimumSubtotal, int expiryDay) {
        if (code == null || code.isBlank() || percent < 0 || percent > 100 || maxDiscount<0 || minimumSubtotal<0 || expiryDay<0) {
            throw new IllegalArgumentException();
        }

        this.code = code;
        this.percent = percent;
        this.maxDiscount = maxDiscount;
        this.minimumSubtotal = minimumSubtotal;
        this.expiryDay = expiryDay;
    }

    public long discount(long amount, int day)throws CouponRejectedException {
        if (amount < 0) {
            throw new IllegalArgumentException();
        }

        if (percent == 0) {
            throw new CouponRejectedException();
        }

        if (amount < minimumSubtotal || day > expiryDay) {
            throw new CouponRejectedException();
        }

        long discount = (amount * percent + 99) / 100;

        if (discount > maxDiscount) {
            discount = maxDiscount;
        }

        return discount;
    }

    public String code() {
        return code;
    }

    public int percent() {
        return percent;
    }


}