package kenakata.settlement;

import kenakata.catalog.Seller;

public class SellerPayout {
    private final Seller seller;
    private long grossSales;
    private long commission;
    private long refunds;
    private final long payout;

    public SellerPayout(Seller seller, long grossSales, long commission, long refunds, long payout) {
        this.seller = seller;
        this.grossSales = grossSales;
        this.commission = commission;
        this.refunds = refunds;
        this.payout = payout;
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
        return payout;
    }
}


