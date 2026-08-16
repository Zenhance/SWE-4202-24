package kenakata.order;

public class Coupon {
    String code;
    int percentage, cap, minSpend, validDate;
    public Coupon(String code, int percentage, int cap, int minSpend, int validDate) {
        if(percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("percentage must be between 0 and 100");
        }
        this.code = code;
        this.percentage = percentage;
        this.cap = cap;
        this.minSpend = minSpend;
        this.validDate = validDate;
    }
}
