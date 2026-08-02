package kenakata.order;

public class Coupon {
    String code; int percent, cap, minspend, validdate;
    public Coupon(String code, int percent, int cap, int minspend, int validdate) {
        this.code = code;
        this.percent = percent;
        this.cap = cap;
        this.minspend = minspend;
        this.validdate = validdate;
    }
}
