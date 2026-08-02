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

/**
 * The marketplace: registers sellers, records placed orders through the day, and at day's end
 * runs settlement -- for each seller, the value of their product lines minus commission minus
 * any refunds for returns they took back; everything else (add-ons, delivery, VAT, service fee,
 * net of discounts) is platform revenue.
 */
public final class Marketplace {

    private final List<Seller> sellers = new ArrayList<>();
    private final List<Order> orders = new ArrayList<>();

    public void register(Seller seller) {
        if (seller == null) {
            throw new IllegalArgumentException("seller must not be null");
        }
        sellers.add(seller);
    }

    /** Records a placed order to be included in the next settlement run. */
    public void record(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("order must not be null");
        }
        if (!order.placed()) {
            throw new IllegalStateException("only a placed order can be recorded");
        }
        orders.add(order);
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

        for (Order order : orders) {
            PriceBreakdown breakdown = order.finalBreakdown();
            long orderCommission = 0;
            long orderAddOnCharges = 0;

            for (OrderLine line : order.lines()) {
                if (line.chargeable() instanceof CatalogItem item) {
                    long lineValue = line.lineCharge();
                    long commission = item.commissionOn(lineValue);
                    Seller seller = item.seller();

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
