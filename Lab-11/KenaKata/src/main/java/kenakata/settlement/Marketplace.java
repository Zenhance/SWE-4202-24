package kenakata.settlement;

import kenakata.catalog.AbstractItem;
import kenakata.catalog.Seller;
import kenakata.order.Order;
import kenakata.order.OrderLine;
import kenakata.order.PriceBreakdown;

import java.util.*;

public class Marketplace {
    private final List<Seller> sellers = new ArrayList<>();
    private final List<Order> recordedOrders = new ArrayList<>();

    public void register(Seller seller) {
        if (seller == null) {
            throw new IllegalArgumentException("Seller cannot be null");
        }
        if (!sellers.contains(seller)) {
            sellers.add(seller);
        }
    }

    public void add(Order order) {
        record(order);
    }

    public void record(Order order) {
        if (order == null || !order.placed()) {
            throw new IllegalArgumentException("Order must be placed before recording");
        }
        recordedOrders.add(order);
    }

    public SettlementReport settle() {
        Map<Seller, Long> grossSalesMap = new HashMap<>();
        Map<Seller, Long> commissionMap = new HashMap<>();
        Map<Seller, Long> refundsMap = new HashMap<>();

        for (Seller s : sellers) {
            grossSalesMap.put(s, 0L);
            commissionMap.put(s, 0L);
            refundsMap.put(s, 0L);
        }

        long totalCustomerPayment = 0;

        for (Order order : recordedOrders) {
            PriceBreakdown bd = order.finalBreakdown();
            totalCustomerPayment += bd.grandTotal();

            for (OrderLine line : order.lines()) {
                if (line.item() instanceof AbstractItem abstractItem) {
                    Seller seller = abstractItem.seller();
                    long lineValue = line.lineValue();
                    long comm = abstractItem.commissionOn(lineValue);

                    grossSalesMap.put(seller, grossSalesMap.getOrDefault(seller, 0L) + lineValue);
                    commissionMap.put(seller, commissionMap.getOrDefault(seller, 0L) + comm);

                    if (line.returned()) {
                        refundsMap.put(seller, refundsMap.getOrDefault(seller, 0L) + lineValue);
                    }
                }
            }
        }

        List<SellerPayout> payouts = new ArrayList<>();
        long totalSellerPayouts = 0;

        for (Seller seller : sellers) {
            long gross = grossSalesMap.getOrDefault(seller, 0L);
            long comm = commissionMap.getOrDefault(seller, 0L);
            long ref = refundsMap.getOrDefault(seller, 0L);
            long netPayout = gross - comm - ref;

            payouts.add(new SellerPayout(seller, gross, comm, ref));
            totalSellerPayouts += netPayout;
        }

        long platformRevenue = totalCustomerPayment - totalSellerPayouts;
        return new SettlementReport((Map<Seller, SellerPayout>) payouts, platformRevenue);
    }
}