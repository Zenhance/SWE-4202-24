package kenakata.settlement;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Seller;
import kenakata.order.Order;
import kenakata.order.OrderLine;
import java.util.ArrayList;
import java.util.List;
public class Marketplace {
    private final List<Seller> sellers = new ArrayList<>();
    private final List<Order> orders = new ArrayList<>();
    public void register(Seller seller) {
        sellers.add(seller);
    }
    public void record(Order order) {
        orders.add(order);
    }
    public SettlementReport settle() {
        List<SellerPayout> payouts = new ArrayList<>();
        long platformRevenue = 0;
        for (Seller seller : sellers) {

            long gross = 0;
            long commission = 0;
            long refunds = 0;

            for (Order order : orders) {

                if (!order.placed()) {
                    continue;
                }

                for (OrderLine line : order.lines()) {

                    if (!line.isProduct()) {
                        continue;
                    }

                    CatalogItem item = line.catalogItem();

                    if (item.seller() != seller) {
                        continue;
                    }

                    long value = line.charge();

                    gross += value;
                    commission += item.commissionOn(value);

                    if (line.returned()) {
                        refunds += value;
                    }
                }
                platformRevenue +=
                        order.finalBreakdown().delivery()
                                + order.finalBreakdown().vat()
                                + order.finalBreakdown().serviceFee()
                                + order.finalBreakdown().insurance()
                                - order.finalBreakdown().discount();
            }

            payouts.add(
                    new SellerPayout(
                            seller,
                            gross,
                            commission,
                            refunds
                    )
            );
        }
        for (Order order : orders) {

            if (!order.placed()) {
                continue;
            }

            for (OrderLine line : order.lines()) {

                if (!line.isProduct()) {
                    platformRevenue += line.charge();
                }
            }
        }
        for (SellerPayout payout : payouts) {
            platformRevenue += payout.commission();
        }

        return new SettlementReport(
                payouts,
                platformRevenue
        );
    }
}