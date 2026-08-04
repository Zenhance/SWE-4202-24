package kenakata.settlement;

import kenakata.catalog.Seller;

import java.util.ArrayList;
import java.util.List;

public final class SettlementReport {

    private final List<SellerPayout> payouts;
    private final long platformRevenue;

    public SettlementReport(List<SellerPayout> payouts, long platformRevenue) {
        if (payouts == null)
            throw new IllegalArgumentException();



        this.payouts = new ArrayList<>(payouts);
        this.platformRevenue = platformRevenue;
    }

    public SellerPayout forSeller(Seller seller) {
        if (seller == null) {
            throw new IllegalArgumentException();
        }
        for (SellerPayout payout : payouts) {
            if (payout.seller().equals(seller)) {
                return payout;
            }
        }
        throw new IllegalArgumentException("Seller not found.");
    }

    public List<SellerPayout> payouts() {
        return payouts;
    }
    public long platformRevenue() {
        return platformRevenue;
    }
}