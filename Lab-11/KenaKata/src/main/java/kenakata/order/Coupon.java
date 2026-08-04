package kenakata.order;

public class Coupon {
    private final String code;
    private final double percentage;
    private final long maxDiscount;
    private final long minSpend;
    private final int validDays;

    public Coupon(String code, double percentage, long maxDiscount, long minSpend, int validDays) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Coupon percentage must be between 0 and 100.");
        }
        this.code = code;
        this.percentage = percentage;
        this.maxDiscount = maxDiscount;
        this.minSpend = minSpend;
        this.validDays = validDays;
    }

    public String getCode() {
        return code;
    }

    public double getPercentage() {
        return percentage;
    }

    public long getMaxDiscount() {
        return maxDiscount;
    }

    public long getMinSpend() {
        return minSpend;
    }

    public int getValidDays() {
        return validDays;
    }
}