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

    public List<SellerPayout> payouts() { return payouts; }
    public long platformRevenue() { return platformRevenue; }

    public SellerPayout forSeller(Seller seller) {
        return payouts.stream()
                .filter(p -> p.seller().equals(seller))
                .findFirst()
                .orElse(new SellerPayout(seller, 0, 0, 0, 0));
    }
}