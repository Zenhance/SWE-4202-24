package kenakata.order;

import kenakata.catalog.Seller;

public class Coupon{
    private final String code;
    private final long percent;
    private final long maxDiscount;
    private final long minSpend;
    private final long validUntil;
    public Coupon (String code, long percent, long maxDiscount, long minSpend, long validUntil){
        if(code==null || code.isBlank()){
            throw new IllegalArgumentException("Code can't be null or blank!");
        }
        if(percent<0 || percent>100){throw new IllegalArgumentException("Percent can't be negative and also can't exceed 100.");}
        this.code=code;
        this.percent=percent;
        this.maxDiscount=maxDiscount;
        this.minSpend=minSpend;
        this.validUntil=validUntil;
    }
    public String getCode(){
        return code;
    }
    public long getPercent(){
        return percent;
    }
    public long getMaxDiscount(){
        return maxDiscount;
    }
    public long getMinSpend(){
        return minSpend;
    }
    public long getValidUntil(){
        return validUntil;
    }



}