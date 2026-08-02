package kenakata.order;

public class Coupon {
    private final String code;
    private final long percent;
    private final long maxDiscount;
    private final long minimumSpend;
    private final long validUntil;

    public Coupon(String code, long percent,long maxDiscount, long minimumSpend, long validUntill){
        if(code==null || code.isBlank()){
            throw new IllegalArgumentException("Invalid Coupon code");
        }
        if(percent<0 || percent>100){
            throw new IllegalArgumentException("Invalid Coupon percentage");
        }
        if(maxDiscount<0) {
            throw new IllegalArgumentException("Maximum discount cannot be negative");
        }
        if(minimumSpend<0){
            throw new IllegalArgumentException("Minimum discount cannot be negative");
        }
        if(validUntill<0){
            throw new IllegalArgumentException("Invalid expiry date");
        }
        this.code=code;
        this.percent=percent;
        this.maxDiscount=maxDiscount;
        this.minimumSpend=minimumSpend;
        this.validUntil=validUntill;
    }

    public String code() {
        return code;
    }

    public long percent() {
        return percent;
    }

    public long maxDiscount() {
        return maxDiscount;
    }

    public long minimumSpend() {
        return minimumSpend;
    }

    public long validUntil() {
        return validUntil;
    }
}
