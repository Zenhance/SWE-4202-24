package kenakata.coupon;

public class Coupon {
    private String code;
    private int discountAmount;
    private int expiryDay;

    public Coupon(String code, int discountAmount, int expiryDay) {
        this.code = code;
        this.discountAmount = discountAmount;
        this.expiryDay = expiryDay;
    }

    public String getCode() {
        return code;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public int getExpiryDay() {
        return expiryDay;
    }

    public boolean isExpired(int currentDay) {
        return currentDay > expiryDay;
    }

    public long computeDiscount(long subtotal, int currentDay) {

        if (isExpired(currentDay)) {
            return 0;
        }

        if (discountAmount > subtotal) {
            return subtotal;
        }

        return discountAmount;
    }
}