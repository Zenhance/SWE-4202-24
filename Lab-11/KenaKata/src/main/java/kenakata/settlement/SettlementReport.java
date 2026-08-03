package kenakata.settlement;

import kenakata.catalog.Seller;

import java.util.List;

/** The result of one nightly settlement: every seller's payout and the platform's own
 * revenue for the day. */
public final class SettlementReport {

    private final List<SellerPayout> payouts;
    private final long platformRevenue;

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
        for (SellerPayout payout : payouts) {
            if (payout.seller().equals(seller)) {
                return payout;
            }
        }
        return null;
    }
}
