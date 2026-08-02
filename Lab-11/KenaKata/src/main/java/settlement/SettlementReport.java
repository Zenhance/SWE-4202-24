package kenakata.settlement;

import java.util.List;
import java.util.Map;
import kenakata.catalog.Seller;

/** The result of one nightly settlement run: every seller's payout and the platform's revenue. */
public final class SettlementReport {

    private final Map<Seller, SellerPayout> payoutsBySeller;
    private final long platformRevenue;

    public SettlementReport(Map<Seller, SellerPayout> payoutsBySeller, long platformRevenue) {
        this.payoutsBySeller = payoutsBySeller;
        this.platformRevenue = platformRevenue;
    }

    public List<SellerPayout> payouts() {
        return List.copyOf(payoutsBySeller.values());
    }

    public SellerPayout forSeller(Seller seller) {
        return payoutsBySeller.get(seller);
    }

    public long platformRevenue() {
        return platformRevenue;
    }
}
