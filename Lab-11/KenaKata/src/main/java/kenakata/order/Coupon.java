package kenakata.order;

public class Coupon {
    private final String code;
    private final double percentage;
    private final long maxDiscount;
    private final long minSpeed;
    private final int lastValidDay;
    public Coupon(String code,double percentage,long maxDiscount,long minSpeed, int lastValidDay){
        if(percentage<0 || percentage > 100) {
            throw new IllegalArgumentException("Invalid percentage");
        }
        this.code=code;
        this.percentage = percentage;
        this.maxDiscount= maxDiscount;
        this.minSpeed= minSpeed;
        this.lastValidDay = lastValidDay;
        }
        public String code(){
        return code;
    }
}
