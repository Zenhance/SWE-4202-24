package kenakata.settlement;

public class SellerPayout {
    private final Seller seller;
    private long grossSales;
    private long commission;
    private long refunds;

    public SellerPayout(Seller seller){
        this.seller=seller;
    }
    public void addSales(long amount){
        this.grossSales+=amount;
    }
    public void addCommission(long amount){
        this.commission+=amount;
    }
    public void addRefund(long amount){
        this.refunds+=amount;
    }
    public long grossSales(){
        return grossSales;
    }
    public long refunds(){
        return refunds;
    }
    public long payout(){
        return grossSales-commission-refunds;
    }
    public Seller seller(){
        return seller;
    }
}
