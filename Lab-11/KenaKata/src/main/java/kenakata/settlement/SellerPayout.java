package kenakata.settlement;
import kenakata.catalog.Seller;

public class SellerPayout {
    private final Seller seller;

    private long grossSales;
    private long commission;
    private long refunds;

    public SellerPayout(Seller seller){
        this.seller = seller;

    }
    public void addSale(long amount,long commission
    ){
        grossSales += amount;
        this.commission += commission;
    }
    public void addRefund(long amount){
        refunds += amount;
    }
    public Seller seller(){
        return seller;
    }

    public long grossSales(){
        return grossSales;
    }

    public long commission(){
        return commission;
    }
    public long refunds(){
        return refunds;

    }
    public long payout(){
        return grossSales - commission - refunds;

    }

}