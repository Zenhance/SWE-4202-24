package kenakata.order;

public class Coupon {
    private String code;
    private  long percentage;
    private long cap;
    private long minimumSpend;
    private int lastValidDay;
    public Coupon(String code,long percentage,long cap,long minimumSpend,int lastValidDay) {
        if(code == null || code.isBlank()) throw new IllegalArgumentException("cupon code cannot be null or blank");
        if(percentage<0 || percentage>100) throw new IllegalArgumentException("perchantage is invalid");
        if(cap<=0) throw new IllegalArgumentException("cap can't be negative or zero");
        if(minimumSpend<0) throw new IllegalArgumentException("Minimum spend can't be negative");
        if(lastValidDay<0) throw new IllegalArgumentException("Last valid day can't be negative");
        this.code=code;
        this.percentage=percentage;
        this.cap=cap;
        this.minimumSpend=minimumSpend;
        this.lastValidDay=lastValidDay;
    }

}
