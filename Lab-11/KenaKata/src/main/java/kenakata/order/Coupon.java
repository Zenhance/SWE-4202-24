package kenakata.order;

public class Coupon {

    String code;
    int percent;
    int capped;
    int c;
    int d;

    public Coupon(String code, int percent, int capped, int c, int d) {
        this.code = code;
        this.percent = percent;
        this.capped = capped;
        this.c = c;
        this.d = d;
    }
}
