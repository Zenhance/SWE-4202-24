package kenakata.settlement;

import kenakata.catalog.Seller;

public class SellerPayout {
    private final Seller seller;
    private final long grossSale;
    private final long commission;
    private final long refunds;
    private final long payout;

    public SellerPayout(Seller seller, long grossSale, long commission, long refunds, long payout) {
        this.seller = seller;
        this.grossSale = grossSale;
        this.commission = commission;
        this.refunds = refunds;
        this.payout = payout;
    }

    public Seller seller() {
        return seller;
    }

    public long grossSale() {
        return grossSale;
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

    public Seller getSeller() {
        return seller;
    }

    public long getGrossSale() {
        return grossSale;
    }

    public long getCommission() {
        return commission;
    }

    public long getRefunds() {
        return refunds;
    }

    public long getPayout() {
        return payout;
    }
}
