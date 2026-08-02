package kenakata.order;

import kenakata.exceptions.CouponRejectedException;

public class Coupon {
    private final String code;
    private final int pct;
    private final long cap;
    private final long minSpeed;
}
