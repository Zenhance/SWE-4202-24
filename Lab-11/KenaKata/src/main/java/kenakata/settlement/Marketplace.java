package kenakata.settlement;
import kenakata.catalog.Seller;
import kenakata.order.Order;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class Marketplace {

    private final List<Seller> sellers = new ArrayList<>();
    private final List<Order> placedOrders = new ArrayList<>();

    public void register(Seller seller) {
        sellers.add(seller);
    }

    public void record(Order order) {
        placedOrders.add(order);
    }
    public SettlementReport settle() {
        List<SellerPayout> payouts = new ArrayList<>();
        Map<Seller, SellerPayout> bySeller = new LinkedHashMap<>();
        for (Seller seller : sellers) {
            SellerPayout payout = new SellerPayout(seller, 0, 0, 0);
            payouts.add(payout);
            bySeller.put(seller, payout);
        }
        return new SettlementReport(payouts, bySeller, 0);
    }
}
