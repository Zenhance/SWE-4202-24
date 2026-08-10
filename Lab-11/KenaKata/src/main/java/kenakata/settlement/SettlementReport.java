package kenakata.settlement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import kenakata.catalog.Seller;

public final class SettlementReport {

    private final List<SellerPayout> payouts;
    private final long platformRevenue;

    public SettlementReport(
            List<SellerPayout> payouts,
            long platformRevenue
    ) {
        if (payouts == null) {
            throw new IllegalArgumentException(
                    "Payout list cannot be null"
            );
        }

        this.payouts = Collections.unmodifiableList(
                new ArrayList<>(payouts)
        );

        this.platformRevenue = platformRevenue;
    }

    public List<SellerPayout> payouts() {
        return payouts;
    }

    public long platformRevenue() {
        return platformRevenue;
    }

    public SellerPayout forSeller(Seller seller) {
        if (seller == null) {
            throw new IllegalArgumentException(
                    "Seller cannot be null"
            );
        }

        for (SellerPayout payout : payouts) {
            if (payout.seller() == seller) {
                return payout;
            }
        }

        throw new IllegalArgumentException(
                "Seller was not registered in this marketplace"
        );
    }
}