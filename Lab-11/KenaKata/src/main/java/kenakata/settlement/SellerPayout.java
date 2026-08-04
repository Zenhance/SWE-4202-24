package kenakata.settlement;

import kenakata.catalog.Seller;

public class SellerPayout {
    private final Seller seller;
    private long grossSales = 0;
    private long commission = 0;
    private long refunds = 0;

    public SellerPayout(Seller seller) {
        this.seller = seller;
    }

    public Seller seller() { return seller; }
    public long grossSales() { return grossSales; }
    public long commission() { return commission; }
    public long refunds() { return refunds; }

    public long payout() { return grossSales - commission - refunds; }

    void addSale(long gross, long platformCommission) {
        this.grossSales += gross;
        this.commission += platformCommission;
    }

    void addRefund(long refundAmount) {
        this.refunds += refundAmount;
    }
}