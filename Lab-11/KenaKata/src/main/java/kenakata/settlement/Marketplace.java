package kenakata.settlement;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kenakata.catalog.CatalogItem;
import kenakata.order.Order;
import kenakata.order.OrderLine;
import kenakata.order.PriceBreakdown;


public final class Marketplace {

    private final List<Seller>sellers=new ArrayList<>();
    private final List<Order> oders=new ArrayList<>();

    public void register(Seller seller) {
        if (seller==null) {
            throw new IllegalArgumentException("seller must not be null");
        }
        sellers.add(seller);
    }

    public void record(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("order must not be null");
        }
        if (!order.placed()) {
            throw new IllegalStateException("only a placed order can be recorded");
        }

    }

    /** Runs settlement over every order recorded so far. */
    public SettlementReport settle() {
        Map<Seller, Long> grossSales = new LinkedHashMap<>();
        Map<Seller, Long> commissions = new LinkedHashMap<>();
        Map<Seller, Long> refunds = new LinkedHashMap<>();
        for (Seller seller : sellers) {
            grossSales.put(seller, 0L);
            commissions.put(seller, 0L);
            refunds.put(seller, 0L);
        }

        long platformRevenue = 0;

        Order[] orders = new Order[0];
        for (Order order : orders) {
            PriceBreakdown breakdown = order.finalBreakdown();
            long orderCommission = 0;
            long orderAddOnCharges = 0;

            for (OrderLine line:order.lines()) {
                if (line.chargeable() instanceof CatalogItem item) {
                    long lineValue = line.lineCharge();
                    long commission = item.commissionOn(lineValue);
                    Seller seller = new seller();

                    grossSales.merge(seller, lineValue, Long::sum);
                    commissions.merge(seller, commission, Long::sum);
                    orderCommission += commission;

                    if (line.returned()) {
                        refunds.merge(seller, lineValue, Long::sum);
                    }
                } else {
                    orderAddOnCharges += line.lineCharge();
                }
            }

            platformRevenue += orderCommission + orderAddOnCharges
                    + breakdown.delivery() + breakdown.vat() + breakdown.serviceFee()
                    - breakdown.discount();
        }

        Map<Seller, SellerPayout> payouts = new LinkedHashMap<>();
        for (Seller seller : sellers) {
            payouts.put(seller, new SellerPayout(seller, grossSales.get(seller),
                    commissions.get(seller), refunds.get(seller)));
        }

        return new SettlementReport(payouts, platformRevenue);
    }
}
