package kenakata.settlement;
import kenakata.catalog.Seller;

public class SellerPayout {
    private final Seller seller;
    private final int grossSales;
    private final int commission;
    private final int refunds;

    public SellerPayout(Seller seller, int grossSales,int commission,int refunds){
        this.seller=seller;
        this.grossSales=grossSales;
        this.commission=commission;
        this.refunds=refunds;
    }

    public Seller seller(){
        return seller;
    }

    public int grossSales(){
        return grossSales;
    }

    public int commission(){
        return commission;
    }

    public int refunds(){
        return refunds;
    }

    public int payout(){
        return grossSales-commission-refunds;
    }
}
