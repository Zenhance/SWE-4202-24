package kenakata.settlement;

import kenakata.catalog.Seller;
import kenakata.order.Order;
import kenakata.order.PriceBreakdown;

import java.util.ArrayList;

public class Marketplace {

    private ArrayList<Seller> sellers;
    private ArrayList<Order> orders;


    public Marketplace() {
        sellers = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public void register(Seller seller) {
        if (seller == null) {
            throw new IllegalArgumentException("Seller cannot be null");
        }

        sellers.add(seller);
    }

    public void record(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }

        if (!order.placed()) {
            throw new IllegalArgumentException("Order has not been placed.");
        }

        orders.add(order);
    }

    public SettlementReport settle() {

        SettlementReport report = new SettlementReport();

        for (Seller seller : sellers) {

            long grossSales = 0;
            long commission = 0;
            long refunds = 0;

            for (Order order : orders) {

                for (int i = 0; i < order.lines().size(); i++) {

                    var line = order.lines().get(i);

                    if (line.product().seller() != seller) {
                        continue;
                    }

                    long value =
                            line.product().unitCharge() * line.quantity();

                    grossSales += value;

                    commission += line.product().commissionOn(value);

                    if (line.returned()) {
                        refunds += value;
                    }
                }
            }

            SellerPayout payout = new SellerPayout(seller, grossSales, commission, refunds);

            report.addSellerPayout(payout);
        }

        long platformRevenue = 0;

        for (Order order : orders) {

            PriceBreakdown b = order.finalBreakdown();

            platformRevenue += b.delivery();
            platformRevenue += b.vat();
            platformRevenue += b.serviceFee();
            platformRevenue += b.insurance();

            platformRevenue -= b.discount();

            for (var line : order.lines()) {

                long value =
                        line.product().unitCharge() * line.quantity();

                platformRevenue +=
                        line.product().commissionOn(value);
            }

            for (var addOn : order.addOns()) {
                platformRevenue += addOn.unitCharge();
            }
        }

        report.setPlatformRevenue(platformRevenue);

        return report;
    }
}