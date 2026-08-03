package kenakata.settlement;

import kenakata.catalog.Seller;

public class SellerPayout {
    private Seller seller;
    private long grossSales;
    private long commission;
    private long refunds;
    public SellerPayout(Seller seller, long grossSales, long commission, long refunds) {
        this.seller = seller;
        this.grossSales = grossSales;
        this.commission = commission;
        this.refunds = refunds;
    }
    public Seller seller() {
        return seller;
    }
    public long grossSales() {
        return grossSales;
    }
    public long commission() {
        return commission;
    }
    public long refunds() {
        return refunds;
    }
    public long payout() {
        return grossSales - commission - refunds;
    }
}
