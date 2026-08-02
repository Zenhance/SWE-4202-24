package kenakata.settlement;

import kenakata.catalog.Seller;

/**
 * One seller's result for a settlement run: the gross value of their product lines, the
 * platform commission taken on them, any refunds for returns they took back, and what remains
 * as their payout.
 */
public final class SellerPayout {

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
