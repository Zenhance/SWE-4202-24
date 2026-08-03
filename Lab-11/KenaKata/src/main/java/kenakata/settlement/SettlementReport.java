package kenakata.settlement;

import kenakata.catalog.Seller;

import java.util.ArrayList;

public class SettlementReport {
    private Seller seller;
    private ArrayList<SellerPayout> payouts;
    public SettlementReport(Seller seller) {
        this.seller = seller;
    }
    public SellerPayout forSeller(Seller a) {
        return null;
    }

    public int platformRevenue() {
        return 0;
    }

    public ArrayList<SellerPayout> payouts() {
        return payouts;
    }

}
