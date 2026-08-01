package kenakata.settlement;

import java.util.Collection;
import java.util.Map;

import kenakata.catalog.Seller;

public final class SettlementReport {
    private final Map<Seller, SellerPayout> payouts;
    private final long platformRevenue;

    public SettlementReport(Map<Seller, SellerPayout> payouts, long platformRevenue) {
        this.payouts = payouts;
        this.platformRevenue = platformRevenue;
    }

    public SellerPayout forSeller(Seller seller) {
        return payouts.get(seller);
    }

    public Collection<SellerPayout> payouts() {
        return payouts.values();
    }

    public long platformRevenue() {
        return platformRevenue;
    }
}