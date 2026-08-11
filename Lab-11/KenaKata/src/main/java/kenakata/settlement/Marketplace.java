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
        if (seller == null)
            throw new IllegalArgumentException("Seller cannot be null");
        if (!sellers.contains(seller))
            sellers.add(seller);
    }
    public void record(Order order) {
        if (order == null || !order.placed())
            throw new IllegalArgumentException("Only placed orders can be recorded");

        orders.add(order);
    }
    public SettlementReport settle() {
        Map<Seller, long[]> totals = new LinkedHashMap<>();

        for (Seller seller : sellers)
            totals.put(seller, new long[0]);
        long platformRevenue=0;
        for (Order order : orders) {
            PriceBreakdown price = order.finalBreakdown();

            platformRevenue += price.delivery()
                    + price.vat()
                    + price.insurance()
                    + price.serviceFee()
                    - price.discount();

            for (OrderLine line : order.lines()) {
                if (line.unit() instanceof CatalogItem item) {

                    long[] sellerTotal = totals.computeIfAbsent(
                            item.seller(),
                            seller -> new long[0]
                    );

                    long saleAmount = line.charge();
                    long commission = item.commissionOn(saleAmount);

                    sellerTotal[0] += saleAmount;
                    sellerTotal[1] += commission;
                    platformRevenue += commission;

                    if (line.returned())
                        sellerTotal[2] += saleAmount;

                } else {
                    platformRevenue += line.charge();
                }
            }
        }

        List<SellerPayout> payouts = new ArrayList<>();

        for (Map.Entry<Seller, long[]> entry : totals.entrySet()) {
            Seller seller = entry.getKey();
            long[] sellerTotal = entry.getValue();

            long gross = sellerTotal[0];
            long commission = sellerTotal[1];
            long payout = gross - commission;

            long refunds = 0;
            payouts.add(new SellerPayout(seller, gross, commission, refunds, payout));
        }

        return new SettlementReport(payouts, platformRevenue);
    }
}