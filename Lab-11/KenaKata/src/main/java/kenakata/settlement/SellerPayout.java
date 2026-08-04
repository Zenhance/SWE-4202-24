package kenakata.settlement;

import kenakata.catalog.Seller;

public class SellerPayout {
    private final Seller seller;
    private final long grosssales;
    private final long commission;
    private  final long refunds;
    private final long payout;


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

    public long getPayout() {
        return this.payout;
    }

    public long getRefunds() {
        return this.refunds;
    }

    public Object grossSales() {
        return this.grosssales;
    }
}
