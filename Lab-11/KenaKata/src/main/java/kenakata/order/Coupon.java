package kenakata.order;

import kenakata.exceptions.InvalidCouponException;

public class Coupon {
    private String code;
    private int percentage;
    private long cap;
    private long minSpend;
    private int lastValidDay;
}
}