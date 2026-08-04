package kenakata.settlement;

import kenakata.catalog.Seller;

public class SellerPayout {
    public final Seller seller;
    private final long grosssales;
    public final long commission;
    public final long refunds;
    public final long payout;


    public SellerPayout(Seller seller, long grosssales, long commission, long refunds, long payout) {
        this.seller = seller;
        this.grosssales = grosssales;
        this.commission = commission;
        this.refunds = refunds;
        this.payout = payout;
    }

    public Seller getSeller() {
        return this.seller;
    }

    public long getCommission() {
        return this.commission;
    }

    public long getGrosssales() {
        return this.grosssales;
    }

    public long Payout() {
        return payout;
    }

    public long getRefunds() {
        return this.refunds;
    }

    public Object grossSales() {
        return this.grosssales;
    }

    public boolean seller() {
        return true;
    }

    public long commission() {
        return this.commission;
    }

    public final long payout() {
       return this.payout;
    }

    public long refunds() {
        return refunds;
    }
}
