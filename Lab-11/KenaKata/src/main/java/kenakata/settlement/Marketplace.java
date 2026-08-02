package kenakata.settlement;

import kenakata.catalog.Seller;
import kenakata.order.Order;
import kenakata.order.OrderLine;
import kenakata.order.PriceBreakdown;

import java.util.*;

public class Marketplace {
    private final Set<Seller> registeredSellers = new LinkedHashSet<>();
    private final List<Order> orders = new ArrayList<>();

    public void register(Seller s) {
        registeredSellers.add(s);
    }

}
