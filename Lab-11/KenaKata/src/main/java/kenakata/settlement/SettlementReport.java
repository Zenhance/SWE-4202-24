package kenakata.settlement;

import kenakata.catalog.Seller;
import kenakata.order.Order;

import java.util.ArrayList;

public class SettlementReport {
    private ArrayList<Order> orders;
    private ArrayList<Seller> sellers;

    public SellerPayout forSeller(Seller seller) {
        return new SellerPayout(seller);
    }
}
