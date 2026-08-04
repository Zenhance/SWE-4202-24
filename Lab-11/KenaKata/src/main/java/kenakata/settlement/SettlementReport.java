package kenakata.settlement;

import java.util.List;

public class SettlementReport {

    private final List<SellerPayOut> payouts;
    private final long platformRevenue;

    public SettlementReport(List<SellerPayOut> payouts, long platformRevenue) {
        this.payouts = payouts;
        this.platformRevenue = platformRevenue;
    }

    public List<SellerPayOut> getPayouts() {
        return this.payouts;
    }

    public long getPlatformRevenue() {
        return this.platformRevenue;
    }
}