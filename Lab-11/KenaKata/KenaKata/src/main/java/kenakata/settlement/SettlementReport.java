package kenakata.settlement;

import kenakata.catalog.Seller;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public final class SettlementReport {
    private final List<SellerPayout> payouts;
    private final long platformRevenue;
    private final Map<Seller, SellerPayout> bySeller = new IdentityHashMap<>();

    public SettlementReport(List<SellerPayout> payouts, long platformRevenue) {
        if (payouts == null) {
            throw new IllegalArgumentException("Payouts are required");
        }
        this.payouts = List.copyOf(payouts);
        this.platformRevenue = platformRevenue;
        for (SellerPayout payout : payouts) {
            bySeller.put(payout.seller(), payout);
        }
    }

    public List<SellerPayout> payouts() {
        return Collections.unmodifiableList(payouts);
    }

    public long platformRevenue() {
        return platformRevenue;
    }

    public SellerPayout forSeller(Seller seller) {
        SellerPayout payout = bySeller.get(seller);
        if (payout == null) {
            return new SellerPayout(seller, 0, 0, 0, 0);
        }
        return payout;
    }
}
