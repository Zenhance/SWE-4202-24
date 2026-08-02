package kenakata.order;

public class Coupon {

    private String code;
    private int percentage;
    private long maximumDiscount;
    private long minimumSpend;
    private int expiryDay;


    public Coupon(String code, int percentage, long maximumDiscount, long minimumSpend, int expiryDay) {
        if(percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Invalid percentage");
        }
        this.code = code;
        this.percentage = percentage;
        this.maximumDiscount = maximumDiscount;
        this.minimumSpend = minimumSpend;
        this.expiryDay = expiryDay;
    }
    public int percentage() {
        return percentage;
    }
    public long maximumDiscount() {
        return maximumDiscount;
    }
    public long minimumSpend() {
        return minimumSpend;
    }
    public int expiryDay() {
        return expiryDay;
    }
    public String code() {
        return code;
    }
}