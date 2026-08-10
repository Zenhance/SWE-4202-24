package kenakata.order;
import kenakata.exceptions.CouponRejectedException;
public class Coupon {
    private final String code;
    private final int percentage;
    private final long cap;
    private final long minimumSpend;
    private final int validThroughDay;
    public Coupon(
            String code,
            int percentage,
            long cap,
            long minimumSpend,
            int validThroughDay
    ) {
        if (code == null || code.isBlank()){
            throw new IllegalArgumentException("Coupon code is required");
        }
        if (percentage < 0 || percentage > 100){
            throw new IllegalArgumentException(
                    "Coupon percentage must be between 0 and 100"
            );
        }
        if (cap < 0){
            throw new IllegalArgumentException(
                    "Coupon cap cannot be negative"
            );
        }
        if (minimumSpend < 0){
            throw new IllegalArgumentException(
                    "Minimum spend cannot be negative"
            );
        }
        this.code = code;
        this.percentage = percentage;
        this.cap = cap;
        this.minimumSpend = minimumSpend;
        this.validThroughDay = validThroughDay;
    }
    public String code(){
        return code;
    }
    public long discount(long discountableBase, int currentDay)
            throws CouponRejectedException {
        if (currentDay > validThroughDay) {
            throw new CouponRejectedException(
                    "Coupon has expired"
            );
        }
        if (discountableBase < minimumSpend){
            throw new CouponRejectedException(
                    "Minimum spend not reached"
            );
        }
        if (discountableBase < 0){
            throw new IllegalArgumentException(
                    "Discountable base cannot be negative"
            );
        }
        long discount = (long) Math.ceil(discountableBase * percentage / 100.0);
        return Math.min(discount, cap);
    }
}