package kenakata.order;

import kenakata.exceptions.CouponRejectedException;

public class Coupon {
    private final String code;
    private final int percent;

    public Coupon(String code, int percent) {
        if (code == null || code.isBlank() || percent < 0 || percent > 100) {
            throw new IllegalArgumentException();
        }

        this.code = code;
        this.percent = percent;
    }

    public long discount(long amount, int day)throws CouponRejectedException {
        if (amount < 0) {
            throw new IllegalArgumentException();
        }

        if (percent == 0) {
            throw new CouponRejectedException();
        }

        long discount = (amount * percent + 99) / 100;

        if (discount > 200) {
            discount = 200;
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