package kenakata.settlement;

import kenakata.catalog.Seller;
import java.util.Map;

public class SettlementReport {
    private final Map<Seller, SellerPayout> sellerPayouts;
    private final long platformRevenue;

    public SettlementReport(Map<Seller, SellerPayout> sellerPayouts, long platformRevenue) {
        this.sellerPayouts = sellerPayouts;
        this.platformRevenue = platformRevenue;
    }

    public SellerPayout forSeller(Seller s) {
        return sellerPayouts.getOrDefault(s, new SellerPayout(0,0,0,0));
    }

    public long platformRevenue() {
        return platformRevenue;
    }
}
