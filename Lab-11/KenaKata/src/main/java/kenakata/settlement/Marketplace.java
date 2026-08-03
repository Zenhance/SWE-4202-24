package kenakata.settlement;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Seller;
import kenakata.order.Order;
import kenakata.order.OrderLine;
import kenakata.order.PriceBreakdown;

public final class Marketplace {

    private final List<Seller> sellers = new ArrayList<>();
    private final List<Order> orders = new ArrayList<>();

    public void register(Seller seller) {
        if (seller == null) {
            throw new IllegalArgumentException("Seller cannot be null");
        }

        if (!sellers.contains(seller)) {
            sellers.add(seller);
        }
    }

    public void record(Order order) {
        if (order == null || !order.placed()) {
            throw new IllegalArgumentException(
                    "Only placed orders can be recorded"
            );
        }

        orders.add(order);
    }

    public SettlementReport settle() {

        // seller -> {gross sales, commission, refunds}
        Map<Seller, long[]> totals = new LinkedHashMap<>();

        for (Seller seller : sellers) {
            totals.put(seller, new long[3]);
        }

        long platformRevenue = 0;

        for (Order order : orders) {

            PriceBreakdown price = order.finalBreakdown();

            platformRevenue += price.delivery() + price.vat() + price.insurance() + price.serviceFee() - price.discount();

            for (OrderLine line : order.lines()) {

                if (line.unit() instanceof CatalogItem item) {

                    long[] sellerTotal = totals.computeIfAbsent(
                            item.seller(),
                            seller -> new long[3]
                    );

                    long value = line.charge();
                    long commission = item.commissionOn(value);

                    sellerTotal[0] += value;
                    sellerTotal[1] += commission;
                    platformRevenue += commission;

                    if (line.returned()) {
                        sellerTotal[2] += value;
                    }

                } else {
                    // Add-on charge belongs to the platform.
                    platformRevenue += line.charge();
                }
            }
        }

        List<SellerPayout> payouts = new ArrayList<>();

        for (Map.Entry<Seller, long[]> entry : totals.entrySet()) {

            long gross = entry.getValue()[0];
            long commission = entry.getValue()[1];
            long refunds = entry.getValue()[2];

            payouts.add(new SellerPayout(
                    entry.getKey(),
                    gross,
                    commission,
                    refunds,
                    gross - commission - refunds
            ));
        }

        return new SettlementReport(payouts, platformRevenue);
    }
}