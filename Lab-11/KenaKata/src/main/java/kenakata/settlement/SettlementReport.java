package kenakata.settlement;

import kenakata.catalog.Seller;
import kenakata.order.Order;

import java.util.ArrayList;

public class SettlementReport{
    private ArrayList<Order> orders;
    private ArrayList<Seller> sellers;
    private ArrayList<SellerPayout> payouts;

    public SellerPayout forSeller(Seller seller) {
        return new SellerPayout(seller);
    }

    public int platformRevenue() {
        return 0;
    }

    public ArrayList<SellerPayout> payouts() {
        return payouts;
    }
}