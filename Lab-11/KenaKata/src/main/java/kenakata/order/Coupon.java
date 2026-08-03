package kenakata.order;

public class Coupon {
    private final String couponCode;
    private final long percentage;
    private final long cap;
    private final long validDays;

    public Coupon(String couponCode, long percentage, long cap, long validDays) {
        this.couponCode = couponCode;
        this.percentage = percentage;
        this.cap = cap;
        this.validDays = validDays;
    }
}
