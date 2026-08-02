package kenakata.settlement;

import kenakata.catalog.Seller;
import kenakata.order.Order;

import java.util.ArrayList;

public class SettlementReport {

    ArrayList<Seller> sellers = new ArrayList<>();
    ArrayList<Order> orders = new ArrayList<>();
    ArrayList<SellerPayout> payouts = new ArrayList<>();
    public SellerPayout[] payouts() {
        return null;
    }

    public int platformRevenue() {
        return 0;
    }

    public SellerPayout forSeller(Seller a) {
        return null;
    }


    public long grandTotal() {
        return 0;
    }
}
