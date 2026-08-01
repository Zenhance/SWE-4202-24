package kenakata.order;

public class Coupon {
    private final String code;
    private final int percentage;
    private final int minimumSpend;
    private final int maximumDiscount;
    private final int validUntil;

    public Coupon(String code,int percentage,int maximumDiscount,int minimumSpend,int validUntil){
        if(code==null || code.isBlank()){
            throw new IllegalArgumentException();
        }
        if(percentage<0 || percentage>100){
            throw new IllegalArgumentException();
        }
        if(maximumDiscount<0){
            throw new IllegalArgumentException();
        }
        this.code=code;
        this.percentage=percentage;
        this.minimumSpend=minimumSpend;
        this.maximumDiscount=maximumDiscount;
        this.validUntil=validUntil;
    }

    public String code(){
        return code;
    }

    public int percentage(){
        return percentage;
    }

    public int minimumSpend(){
        return minimumSpend;
    }

    public int maximumDiscount(){
        return maximumDiscount;
    }

    public int validUntil(){
        return validUntil;
    }

}
