package kenakata.settlement;

import kenakata.catalog.Seller;
import kenakata.order.Order;


import java.util.ArrayList;
import java.util.List;

public class Marketplace {
    private final List<Seller> sellers = new ArrayList<>();
    private final List<Order> orders = new ArrayList<>();

    public void register(Seller seller) {
        sellers.add(seller);
    }

    public void record(Order order) {
        orders.add(order);
    }

    public SettlementReport settle() {
        List<SellerPayout> payouts = new ArrayList<>();
    }
}
