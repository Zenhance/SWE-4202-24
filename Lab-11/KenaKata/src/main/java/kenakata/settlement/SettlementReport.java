package kenakata.settlement;

import kenakata.catalog.Seller;
import java.util.List;
import java.util.Map;

public class SettlementReport {
    private final Map<Seller, SellerPayout> payouts;
    private final long platformRevenue;

    public SettlementReport(Map<Seller, SellerPayout> payouts, long platformRevenue) {
        this.payouts = payouts;
        this.platformRevenue = platformRevenue;
    }

    public SellerPayout forSeller(Seller seller) {
        return payouts.getOrDefault(seller, new SellerPayout(seller));
    }

    public List<SellerPayout> payouts() {
        return List.copyOf(payouts.values());
    }

    public long platformRevenue() { return platformRevenue; }
}