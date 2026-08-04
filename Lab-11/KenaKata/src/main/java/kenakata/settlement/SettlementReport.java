package kenakata.settlement;

import kenakata.catalog.Seller;
import java.util.*;

public class SettlementReport {
    private final List<SellerPayout> payouts;
    private final long platformRevenue;

    public SettlementReport(List<SellerPayout> payouts, long platformRevenue) {
        this.payouts = payouts;
        this.platformRevenue = platformRevenue;
    }

    public List<SellerPayout> payouts() { return payouts; }

    public SellerPayout forSeller(Seller s) {

    }

    public long platformRevenue() { return platformRevenue; }
}
