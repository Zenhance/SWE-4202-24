package kenakata.order;

public class Coupon {
private final String code;
private final int discount_per;
private final long maxDiscount;
private final long minimumspend;
private final int expirydate;


    public Coupon(String code, int discountPer, long maxDiscount, long minimumspend, int expirydate) {
        if(code==null || code.isBlank())
            throw new IllegalArgumentException("Invalid");
        if(discountPer<0 || maxDiscount<0 || minimumspend<0 || expirydate<0)
            throw new IllegalArgumentException("Invalid");
        this.code = code;
        this.discount_per = discountPer;
        this.maxDiscount = maxDiscount;
        this.minimumspend = minimumspend;
        this.expirydate = expirydate;
    }
    public String getCode(){
        return code;
    }

    public int getDiscount_per() {
        return this.discount_per;
    }

    public int getExpirydate() {
        return this.expirydate;
    }

    public long getMaxDiscount() {
        return this.maxDiscount;
    }

    public long getMinimumspend() {
        return this.minimumspend;
    }

}
