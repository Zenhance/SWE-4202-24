package kenakata.settlement;

import kenakata.catalog.Seller;

public class SellerPayout {

    private Seller seller;
    private long grossSales;
    private long commission;
    private long refunds;
    private long payout;

    public SellerPayout(Seller seller,
                        long grossSales,
                        long commission,
                        long refunds) {

        if (seller == null) {
            throw new IllegalArgumentException("Seller cannot be null");
        }

        this.seller = seller;
        this.grossSales = grossSales;
        this.commission = commission;
        this.refunds = refunds;

        payout = grossSales - commission - refunds;
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