package kenakata.settlement;
import kenakata.catalog.Seller;

public class SellerPayout {
    private final Seller seller;
    private final long grossSales;
    private final long commission;
    private final long refunds;
    public SellerPayout(Seller seller, long grossSales, long commission, long refunds) {
        this.seller = seller;
        this.grossSales = grossSales;
        this.commission = commission;
        this.refunds = refunds;
    }
    public Seller getSeller() {
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
        return grossSales - commission + refunds;
    }
}
