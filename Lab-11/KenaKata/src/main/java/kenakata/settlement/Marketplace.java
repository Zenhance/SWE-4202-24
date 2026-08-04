package kenakata.settlement;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Seller;
import kenakata.order.Order;
import kenakata.order.OrderLine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Marketplace {
    private final List<Seller> registeredSellers = new ArrayList<>();
    private final List<Order> dailyOrders = new ArrayList<>();

    public void register(Seller seller) {
        if (!registeredSellers.contains(seller)) {
            registeredSellers.add(seller);
        }
    }

    public void record(Order order) {
        if (order.placed()) {
            dailyOrders.add(order);
        }
    }

    public SettlementReport settle() {
        Map<Seller, SellerPayout> payouts = new HashMap<>();
        for (Seller seller : registeredSellers) {
            payouts.put(seller, new SellerPayout(seller));
        }

        long totalCollectedFromCustomers = 0;

        for (Order order : dailyOrders) {
            totalCollectedFromCustomers += order.finalBreakdown().grandTotal();

            for (OrderLine line : order.lines()) {
                if (line.unit() instanceof CatalogItem item) {
                    Seller seller = item.seller();
                    SellerPayout payout = payouts.get(seller);

                    if (payout != null) {
                        long grossLineCharge = line.lineCharge();
                        long commission = item.commissionOn(grossLineCharge);
                        payout.addSale(grossLineCharge, commission);

                        if (line.returned()) {
                            payout.addRefund(grossLineCharge);
                        }
                    }
                }
            }
        }

        long totalPaidOutToSellers = 0;
        for (SellerPayout payout : payouts.values()) {
            totalPaidOutToSellers += payout.payout();
        }

        // Platform keeps everything that wasn't paid out to a seller
        long platformRevenue = totalCollectedFromCustomers - totalPaidOutToSellers;

        return new SettlementReport(payouts, platformRevenue);
    }
}