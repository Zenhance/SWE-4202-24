package kenakata.order;

import java.util.IllformedLocaleException;

public class Coupon {
    private String code;
    private int percentage;
    private int cap;
    private int minimumSpend;
    private int lastValidDay;

    public Coupon(String code, int percentage, int cap, int minimumSpend, int lastValidDay) {
        if (code == null)
            throw new IllegalArgumentException("Coupon code cannot be null");
        if (code.isBlank())
            throw new IllegalArgumentException("Coupon code cannot be blank");
        this.code = code;

        if (percentage <= 0)
            throw new IllegalArgumentException("Discount percentage cannot be negative or equal to zero");
        this.percentage = percentage;

        if (cap <= 0)
            throw new IllegalArgumentException("Cap cannot be negative or zero");
        this.cap = cap;

        if (minimumSpend < 0)
            throw new IllegalArgumentException("Minimum expenditure cannot be negative");
        this.minimumSpend = minimumSpend;

        if (lastValidDay <= 0)
            throw new IllegalArgumentException("Last valid day cannot be negative or zero");
        this.lastValidDay = lastValidDay;
    }

    public String getCode() {
        return code;
    }

    public int getPercentage() {
        return percentage;
    }

    public int getCap() {
        return cap;
    }

    public int getMinimumSpend() {
        return minimumSpend;
    }

    public int getLastValidDay() {
        return lastValidDay;
    }
}
