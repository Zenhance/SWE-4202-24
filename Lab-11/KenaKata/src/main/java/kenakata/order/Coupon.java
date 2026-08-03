package kenakata.order;
import kenakata.exceptions.CouponRejectedException;
public class Coupon {
    private final String code;
    private final double percentage;
    private final long maxDiscount;
    private final long minSpend;
    private final int lastValidDay;
    public Coupon(String code, double percentage, long maxDiscount, long minSpend, int lastValidDay) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Invalid percentage");
        }
        this.code = code;
        this.percentage = percentage;
        this.maxDiscount = maxDiscount;
        this.minSpend = minSpend;
        this.lastValidDay = lastValidDay;
    }
    public String code() {
        return code;
    }
}
