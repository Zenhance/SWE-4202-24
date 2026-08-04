package kenakata.settlement;


import kenakata.catalog.CatalogItem;
import kenakata.catalog.Seller;
import kenakata.order.Order;
import kenakata.order.OrderLine;
import kenakata.order.PriceBreakdown;

import java.util.ArrayList;
import java.util.List;

public class Marketplace {

    private final List<Seller> sellers = new ArrayList<>();
    private final List<Order> orders = new ArrayList<>();

    public void register(Seller seller) {
        if (seller == null) {
            throw new IllegalArgumentException();
        }
        sellers.add(seller);
    }

    public void record(Order order) {
        if (order == null) {
            throw new IllegalArgumentException();
        }
        if (!order.placed()) {
            throw new IllegalArgumentException();
        }
        orders.add(order);
    }

    public SettlementReport settle() {

        List<SellerPayout> payouts = new ArrayList<>();
        long platformRevenue = 0;

        for (Seller seller : sellers) {
            long grossSales = 0;
            long commission = 0;
            long refunds = 0;
            for (Order order : orders) {

                for (OrderLine line : order.lines()) {

                    CatalogItem product = line.getProduct();

                    if (product == null) {
                        continue;
                    }

                    if (product.Seller() != seller) {
                        continue;
                    }

                    long value = line.lineCharge();

                    grossSales += value;
                    commission += (long) Math.ceil(product.commissionOn(value));

                    if (line.returned()) {
                        refunds += value;
                    }
                }
            }

            payouts.add(
                    new SellerPayout(
                            seller,
                            grossSales,
                            commission,
                            refunds,
                            grossSales - commission - refunds
                    )
            );
        }

        for (Order order : orders) {
            PriceBreakdown b = order.finalBreakdown();

            platformRevenue += b.grandTotal();
        }

        long totalSellerPayout = 0;

        for (SellerPayout payout : payouts) {
            totalSellerPayout += payout.payout();
        }

        platformRevenue -= totalSellerPayout;

        return new SettlementReport(payouts, platformRevenue);
    }
}