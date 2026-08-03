package kenakata.settlement;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Seller;
import kenakata.order.Order;
import kenakata.order.OrderLine;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public final class Marketplace {
    private final List<Seller> sellers = new ArrayList<>();
    private final List<Order> orders = new ArrayList<>();

    public void register(Seller seller) {
        if (seller == null) {
            throw new IllegalArgumentException("Seller is required");
        }
        for (Seller current : sellers) {
            if (current == seller) {
                return;
            }
        }
        sellers.add(seller);
    }

    public void record(Order order) {
        if (order == null || !order.placed()) {
            throw new IllegalArgumentException("Only placed orders can be recorded");
        }
        if (!orders.contains(order)) {
            orders.add(order);
        }
    }

    public SettlementReport settle() {
        Map<Seller, Totals> totals = new IdentityHashMap<>();
        for (Seller seller : sellers) {
            totals.put(seller, new Totals());
        }

        long paidByCustomers = 0;
        for (Order order : orders) {
            paidByCustomers = Math.addExact(
                    paidByCustomers, order.finalBreakdown().grandTotal());
            for (OrderLine line : order.lines()) {
                CatalogItem item = line.item();
                if (item == null) {
                    continue;
                }
                Totals t = totals.computeIfAbsent(item.seller(), ignored -> new Totals());
                long value = line.charge();
                t.gross = Math.addExact(t.gross, value);
                t.commission = Math.addExact(t.commission, item.commissionOn(value));
                if (line.returned()) {
                    t.refunds = Math.addExact(t.refunds, value);
                }
            }
        }

        List<SellerPayout> payouts = new ArrayList<>();
        long allSellerPayouts = 0;
        for (Seller seller : sellers) {
            Totals t = totals.remove(seller);
            if (t == null) {
                t = new Totals();
            }
            SellerPayout payout = toPayout(seller, t);
            payouts.add(payout);
            allSellerPayouts = Math.addExact(allSellerPayouts, payout.payout());
        }
        for (Map.Entry<Seller, Totals> extra : totals.entrySet()) {
            SellerPayout payout = toPayout(extra.getKey(), extra.getValue());
            payouts.add(payout);
            allSellerPayouts = Math.addExact(allSellerPayouts, payout.payout());
        }

        long platformRevenue = Math.subtractExact(paidByCustomers, allSellerPayouts);
        return new SettlementReport(payouts, platformRevenue);
    }

    private SellerPayout toPayout(Seller seller, Totals t) {
        long payout = Math.subtractExact(Math.subtractExact(t.gross, t.commission), t.refunds);
        return new SellerPayout(seller, t.gross, t.commission, t.refunds, payout);
    }

    private static final class Totals {
        long gross;
        long commission;
        long refunds;
    }
}
