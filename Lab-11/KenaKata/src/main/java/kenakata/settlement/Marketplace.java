package kenakata.settlement;

import kenakata.catalog.Seller;
import kenakata.order.Order;

import java.util.ArrayList;

public class Marketplace {
    private ArrayList<Seller> sellers;
    private ArrayList<Order> orders;
    private SettlementReport report = new SettlementReport();

    public void register(Seller seller) {
        sellers.add(seller);
    }

    public void record(Order order) {
        orders.add(order);
    }

    public SettlementReport settle() {
        return new SettlementReport(orders, sellers);
    }
}
