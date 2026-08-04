package kenakata.settlement;

import kenakata.catalog.Seller;

import java.util.ArrayList;

public class SettlementReport {

    private ArrayList<SellerPayout> payouts;
    private long platformRevenue;

    public SettlementReport() {
        payouts = new ArrayList<>();
        platformRevenue = 0;
    }

    public void addSellerPayout(SellerPayout payout) {

        if (payout == null) {
            throw new IllegalArgumentException("Payout cannot be null");
        }

        payouts.add(payout);
    }

    public SellerPayout forSeller(Seller seller) {

        for (SellerPayout payout : payouts) {

            if (payout.seller().equals(seller)) {
                return payout;
            }
        }

        return null;
    }

    public void setPlatformRevenue(long revenue) {
        platformRevenue = revenue;
    }

    public long platformRevenue() {
        return platformRevenue;
    }

    public ArrayList<SellerPayout> payouts() {
        return payouts;
    }
}