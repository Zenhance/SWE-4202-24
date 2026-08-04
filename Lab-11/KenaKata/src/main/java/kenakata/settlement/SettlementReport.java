package kenakata.settlement;

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
}