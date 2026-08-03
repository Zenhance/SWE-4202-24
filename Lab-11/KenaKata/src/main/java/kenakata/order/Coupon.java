package kenakata.order;

public class Coupon {
    private final String code;
    private final int percentage;
    private final long cap;
    private final long minimumSpend;
    private final int expiryDay;
    
    public Coupon(String code, int percentage, long cap, long minimumSpend, int expiryDay){
        if(code == null || code.isBlank()){
            throw new IllegalArgumentException();
        }
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException();
        }
        if(cap<0 || minimumSpend<0 || expiryDay<0){
            throw new IllegalArgumentException();
        }
        this.code = code;
        this.percentage = percentage;
        this.cap = cap;
        this.minimumSpend = minimumSpend;
        this.expiryDay = expiryDay;
    }
    public String code(){
        return code;
    }
    public int percentage(){
        return percentage;
    }
    public long cap(){
        return cap;
    }
    public long minimumSpend(){
        return minimumSpend;
    }
    public int getExpiryDay(){
        return expiryDay;
    }
}
