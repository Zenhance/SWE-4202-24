package kenakata.order;

public class Coupon {
    private final String code;
    private final int percentage;
    private final int validUntil;
    private final int minimumSpend;
    private final int maximumDiscount;

    public Coupon(String code,int percentage,int validUntil,int minimumSpend,int maximumDiscount){
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
        this.validUntil=validUntil;
        this.minimumSpend=minimumSpend;
        this.maximumDiscount=maximumDiscount;
    }

    public String code(){
        return code;
    }

    public int percentage(){
        return percentage;
    }

    public int validUntil(){
        return validUntil;
    }

    public int minimumSpend(){
        return minimumSpend;
    }

    public int maximumDiscount(){
        return maximumDiscount;
    }
}
