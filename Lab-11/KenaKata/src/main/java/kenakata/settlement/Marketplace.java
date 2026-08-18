package kenakata.settlement;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Seller;
import kenakata.order.Order;
import kenakata.order.OrderLine;
import kenakata.order.PriceBreakdown;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Marketplace {

    private final List<Seller> registeredSellers = new ArrayList<>();
    private final List<Order> recordedOrders = new ArrayList<>();

    public void register(Seller seller) {
        if (seller == null) {
            throw new IllegalArgumentException("seller must not be null");
        }
        registeredSellers.add(seller);
    }

    public void record(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("order must not be null");
        }
        if (!order.placed()) {
            throw new IllegalStateException("Only placed orders can be recorded for settlement");
        }
        recordedOrders.add(order);
    }

    public SettlementReport settle() {
        Map<Seller, Long> gross = new LinkedHashMap<>();
        Map<Seller, Long> commission = new LinkedHashMap<>();
        Map<Seller, Long> refunds = new LinkedHashMap<>();
        for (Seller seller : registeredSellers) {
            gross.put(seller, 0L);
            commission.put(seller, 0L);
            refunds.put(seller, 0L);
        }

        long totalCommission = 0;
        long totalAddOnRevenue = 0;
        long totalDelivery = 0;
        long totalItemVat = 0;
        long totalServiceFee = 0;
        long totalInsurance = 0;
        long totalDiscount = 0;

        for (Order order : recordedOrders) {
            PriceBreakdown breakdown = order.finalBreakdown();
            totalDelivery += breakdown.delivery();
            totalServiceFee += breakdown.serviceFee();
            totalInsurance += breakdown.insurance();
            totalDiscount += breakdown.discount();

            for (OrderLine line : order.lines()) {
                long lineValue = line.value();
                long lineVat = line.vatTotal();

                if (line.item() instanceof CatalogItem catalogItem) {
                    Seller seller = catalogItem.seller();
                    long lineCommission = catalogItem.commissionOn(lineValue);

                    gross.merge(seller, lineValue, Long::sum);
                    commission.merge(seller, lineCommission, Long::sum);
                    totalCommission += lineCommission;
                    totalItemVat += lineVat;

                    if (line.returned()) {
                        refunds.merge(seller, lineValue, Long::sum);
                    }
                } else {
                    totalAddOnRevenue += lineValue + lineVat;
                }
            }
        }

        Map<Seller, SellerPayout> payouts = new LinkedHashMap<>();
        for (Seller seller : registeredSellers) {
            payouts.put(seller, new SellerPayout(
                    seller,
                    gross.getOrDefault(seller, 0L),
                    commission.getOrDefault(seller, 0L),
                    refunds.getOrDefault(seller, 0L)));
        }

        long platformRevenue = totalCommission + totalAddOnRevenue + totalDelivery
                + totalItemVat + totalServiceFee + totalInsurance - totalDiscount;

        return new SettlementReport(payouts, platformRevenue);
    }
}