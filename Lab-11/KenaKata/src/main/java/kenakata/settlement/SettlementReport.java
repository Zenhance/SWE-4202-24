package kenakata.settlement;

import kenakata.catalog.Seller;
import kenakata.order.Order;

import java.util.ArrayList;

public class SettlementReport {
    private ArrayList<Order> orders;
    private ArrayList<Seller> sellers;
    private ArrayList<SellerPayout> payouts;

    public SettlementReport(ArrayList<Order> orders, ArrayList<Seller> sellers) {
        this.orders = orders;
        this.sellers = sellers;
    }


    public SellerPayout forSeller(Seller seller) {
        SellerPayout payout = new SellerPayout(seller);

        return payout;
    }

    public int platformRevenue() {
        return 0;
    }

    public ArrayList<SellerPayout> payouts() {
        return payouts;
    }
}
