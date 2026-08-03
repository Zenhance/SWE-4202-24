package kenakata.settlement;

import kenakata.catalog.Seller;

public class SellerPayout {
    private Seller seller;
    private long grossSales = 0;
    private long commission = 0;
    private long refunds = 0;
    public SellerPayout(Seller seller) {
        this.seller = seller;
    }
    public SellerPayout() {
    }

    public void addSales(long amount) {
        this.grossSales += amount;
    }
    public Seller seller() {
        return this.seller;
    }

    public void addCommission(long amount) {
        this.commission += amount;
    }

    public void addRefund(long amount) {
        this.refunds += amount;
    }
    public long commission(){
        return commission;
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
}
