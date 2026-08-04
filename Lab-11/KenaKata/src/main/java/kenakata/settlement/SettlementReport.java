package kenakata.settlement;

import kenakata.catalog.Seller;

import java.util.Map;

public class SettlementReport {
    private Map<Seller, SellerPayout> payouts;
    private double platformRevenue;

    public SellerPayout forSeller(Seller seller) {
        return null;
    }
    public long platformRevenue(){
        return platformRevenue;
    }
}
