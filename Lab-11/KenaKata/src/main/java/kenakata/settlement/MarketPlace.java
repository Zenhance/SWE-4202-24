package kenakata.settlement;

import kenakata.catalog.CatalogItem;
import kenakata.order.*;

import java.util.ArrayList;
import java.util.List;

public class Marketplace {
    private final List<Seller> registeredSellers = new ArrayList<>();
    private final List<Order> placedOrders = new ArrayList<>();
    public void register(Seller seller) {
        if (seller != null && !registeredSellers.contains(seller)) {
            registeredSellers.add(seller);
        }
    }
    public void record(Order order) {
        if (order != null && order.placed()) {
            placedOrders.add(order);
        }
    }
    public SettlementReport settle() {
        List<SellerPayout> payoutsList = new ArrayList<>();
        for (Seller s : registeredSellers) {
            payoutsList.add(new SellerPayout(s));
        }
        long platformRevenue = 0;
        for (Order order : placedOrders) {
            PriceBreakdown bd = order.finalBreakdown();
            platformRevenue += bd.delivery() + bd.vat() + bd.serviceFee() + bd.insurance() - bd.discount();
            for (OrderLine line : order.lines()) {
                Chargeable item = line.item();
                if (item instanceof CatalogItem catalogItem) {
                    Seller seller = catalogItem.seller();
                    SellerPayout payout = findOrCreatePayout(payoutsList, seller);
                    long lineValue = line.lineValue();
                    payout.addSales(lineValue);
                    long comm = catalogItem.commissionOn(lineValue);
                    payout.addCommission(comm);
                    platformRevenue += comm;
                    if (line.returned()) {
                        payout.addRefund(lineValue);
                    }
                } else {
                    // Non-product add-ons revenue belongs fully to the platform
                    platformRevenue += line.lineValue();
                }
            }
        }
        return new SettlementReport(payoutsList, platformRevenue);
    }
    private SellerPayout findOrCreatePayout(List<SellerPayout> payoutsList, Seller seller) {
        for (SellerPayout payout : payoutsList) {
            if (payout.seller().equals(seller)) {
                return payout;
            }
        }
        SellerPayout newPayout = new SellerPayout(seller);
        payoutsList.add(newPayout);
        return newPayout;
    }
}
