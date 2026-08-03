package kenakata.settlement;

import kenakata.catalog.Seller;

import java.util.List;

public class SettlementReport {
    private List<SellerPayout> payouts;
    private long platformRevenue;
    public SettlementReport(List<SellerPayout> payouts, long platformRevenue) {
        this.payouts = payouts;
        this.platformRevenue = platformRevenue;
    }
    public List<SellerPayout> payouts() {
        return payouts;
    }
    public long platformRevenue() {
        return platformRevenue;
    }
    public SellerPayout forSeller(Seller seller) {
        for(SellerPayout payout : payouts) {
            if(payout.seller() == seller) {
                return payout;
            }
        }
        return null;
    }
}