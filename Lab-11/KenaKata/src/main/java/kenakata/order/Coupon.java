package kenakata.order;

public class Coupon {
    String code; int percent, cap, minspend, validdate;
    public Coupon(String code, int percent, int cap, int minspend, int validdate) {
       if(percent<0||percent>100){
           throw new IllegalArgumentException("percent out of range");
       }
        this.code = code;
        this.percent = percent;
        this.cap = cap;
        this.minspend = minspend;
        this.validdate = validdate;
    }
}
