package kenakata.settlement;

import java.util.Map;

public class SettlementReport {
    private final Map<Seller, SellerPayout> payouts;
    private final long platformRevenue;

    public SettlementReport(Map<Seller, SellerPayout> payouts, long platformRevenue){
        this.payouts = payouts;
        this.platformRevenue = platformRevenue;
    }

    public SellerPayout forSeller(seller seller){
        return payouts.getOrDefault(seller, new SellerPayout(seller));
    }

    public long platformRevenue() {
        return platformRevenue;
    }
}
