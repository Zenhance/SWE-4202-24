package kenakata.settlement;

import kenakata.catalog.Seller;

import java.util.List;

public class SettlementReport {

    private final List<SellerPayout> payouts;
    private final long platformRevenue;

    public SettlementReport(List<SellerPayout> payouts, long platformRevenue) {
        this.payouts = payouts;
        this.platformRevenue = platformRevenue;
    }

    public List<SellerPayout> getPayouts() {
        return this.payouts;
    }

    public long getPlatformRevenue() {
        return this.platformRevenue;
    }

    public SellerPayout forSeller(Seller s) {
        long grossales=0;
        long commission=0;
        long refunds=0;
        long payout =0;
        return new SellerPayout(s, grossales,commission,refunds,payout );
    }
}