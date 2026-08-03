package kenakata.settlement;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Seller;
import kenakata.order.Order;
import kenakata.order.OrderLine;
import kenakata.order.PriceBreakdown;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class Marketplace {

    private final Set<Seller> sellers = new LinkedHashSet<>();
    private final List<Order> orders = new ArrayList<>();

    public void register(Seller seller) {
        sellers.add(seller);
    }

    public void record(Order order) {
        orders.add(order);
    }

    public SettlementReport settle() {
        Map<Seller, Long> gross = new LinkedHashMap<>();
        Map<Seller, Long> commission = new LinkedHashMap<>();
        Map<Seller, Long> refunds = new LinkedHashMap<>();

        long totalCommission = 0;
        long addOnCharges = 0;
        long totalDelivery = 0;
        long totalVat = 0;
        long totalInsurance = 0;
        long totalServiceFee = 0;
        long totalDiscount = 0;

        for (Order order : orders) {
            PriceBreakdown breakdown = order.finalBreakdown();
            totalDelivery += breakdown.delivery();
            totalVat += breakdown.vat();
            totalInsurance += breakdown.insurance();
            totalServiceFee += breakdown.serviceFee();
            totalDiscount += breakdown.discount();

            for (OrderLine line : order.lines()) {
                if (line.isProduct()) {
                    CatalogItem item = line.asItem();
                    Seller seller = item.seller();
                    long value = line.charge();
                    long lineCommission = item.commissionOn(value);

                    gross.merge(seller, value, Long::sum);
                    commission.merge(seller, lineCommission, Long::sum);
                    totalCommission += lineCommission;

                    if (line.returned()) {
                        refunds.merge(seller, value, Long::sum);
                    }
                } else {
                    addOnCharges += line.charge();
                }
            }
        }

        List<SellerPayout> payouts = new ArrayList<>();
        for (Seller seller : sellers) {
            payouts.add(new SellerPayout(
                    seller,
                    gross.getOrDefault(seller, 0L),
                    commission.getOrDefault(seller, 0L),
                    refunds.getOrDefault(seller, 0L)));
        }

        long platformRevenue = totalCommission + addOnCharges + totalDelivery + totalVat
                + totalInsurance + totalServiceFee - totalDiscount;

        return new SettlementReport(payouts, platformRevenue);
    }
}
