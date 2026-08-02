package kenakata.settlement;

import kenakata.catalog.Seller;
import kenakata.order.Order;

import java.util.ArrayList;

public class Marketplace {
    private ArrayList<Seller> sellers;
    private ArrayList<Order> orders;

    public void register(Seller seller) {
        sellers.add(seller);
    }

    public void record(Order order) {
        orders.add(order);
    }
}
