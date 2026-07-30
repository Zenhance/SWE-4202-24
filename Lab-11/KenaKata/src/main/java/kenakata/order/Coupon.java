package kenakata.order;

public class Coupon {

    String code;
    int percent;
    int capped;
    int minSpend;
    int day;

    public Coupon(String code, int percent, int capped, int c, int day) {
        if(percent > 100 || percent < 0)
            throw new IllegalArgumentException("invalid percentage");
        this.code = code;
        this.percent = percent;
        this.capped = capped;
        this.minSpend = c;
        this.day = day;
    }
}
