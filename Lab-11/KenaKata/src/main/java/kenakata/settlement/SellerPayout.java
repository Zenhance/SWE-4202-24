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










}
