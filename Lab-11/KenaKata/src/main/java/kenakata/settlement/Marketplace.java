package kenakata.settlement;

import java.util.ArrayList;
import java.util.HashMap;
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
        sellers.add(seller);
    }

    public void record(Order order) {
        if (!order.placed()) {
            throw new IllegalStateException("Only a placed order can be recorded");
        }
        orders.add(order);
    }

    public SettlementReport settle() {
        Map<Seller, Long> gross = new HashMap<>();
        Map<Seller, Long> commission = new HashMap<>();
        Map<Seller, Long> refunds = new HashMap<>();
        for (Seller seller : sellers) {
            gross.put(seller, 0L);
            commission.put(seller, 0L);
            refunds.put(seller, 0L);
        }

        long totalCommission = 0;
        long totalAddOnCharges = 0;
        long totalDelivery = 0;
        long totalVat = 0;
        long totalServiceFee = 0;
        long totalDiscount = 0;

        for (Order order : orders) {
            PriceBreakdown breakdown = order.finalBreakdown();
            totalDelivery += breakdown.delivery();
            totalVat += breakdown.vat();
            totalServiceFee += breakdown.serviceFee();
            totalDiscount += breakdown.discount();

            for (OrderLine line : order.lines()) {
                if (line.isProduct()) {
                    CatalogItem item = line.product();
                    long value = item.unitCharge() * line.quantity();
                    long lineCommission = item.commissionOn(value);
                    totalCommission += lineCommission;

                    Seller seller = item.seller();
                    gross.merge(seller, value, Long::sum);
                    commission.merge(seller, lineCommission, Long::sum);
                    if (line.returned()) {
                        refunds.merge(seller, value, Long::sum);
                    }
                } else {
                    totalAddOnCharges += line.charge();
                }
            }
        }

        Map<Seller, SellerPayout> payouts = new HashMap<>();
        for (Seller seller : gross.keySet()) {
            long sellerGross = gross.get(seller);
            long sellerCommission = commission.get(seller);
            long sellerRefunds = refunds.get(seller);
            long payout = sellerGross - sellerCommission - sellerRefunds;
            payouts.put(seller, new SellerPayout(seller, sellerGross, sellerCommission, sellerRefunds, payout));
        }

        long platformRevenue = totalCommission + totalAddOnCharges + totalDelivery
                + totalVat + totalServiceFee - totalDiscount;

        return new SettlementReport(payouts, platformRevenue);
    }
}
