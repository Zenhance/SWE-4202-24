package kenakata.order;

public class Coupon {
    private String code;
    private int percentage;
    private int cap;
    private int minimumSpend;
    private int lastValidDay;

    public Coupon(String code, int percentage, int cap, int minimumSpend, int lastValidDay) {
        this.code = code;
        this.percentage = percentage;
        this.cap = cap;
        this.minimumSpend = minimumSpend;
        this.lastValidDay = lastValidDay;
    }
}
