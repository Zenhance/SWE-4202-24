package kenakata.settlement;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Seller;
import kenakata.order.Order;
import kenakata.order.OrderLine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Marketplace {
    private final List<Seller> registeredSellers=new ArrayList<>();
    private final List<Order> recordedOrders=new ArrayList<>();
    public void register(Seller seller){
        if(!registeredSellers.contains(seller)){
            registeredSellers.add(seller);
        }
    }
    public void record(Order order) {
        if (order.placed()) {
            recordedOrders.add(order);
        }
    }
    public SettlementReport settle() {
        Map<Seller, SellerPayout> payouts = new HashMap<>();
        for (Seller seller : registeredSellers) {
            payouts.put(seller, new SellerPayout());
        }
        long totalGrandTotals = 0;
        for (Order order : recordedOrders) {
            totalGrandTotals += order.finalBreakdown().grandTotal();
            for (OrderLine line : order.lines()) {
                if (line.getItem() instanceof CatalogItem item) {
                    Seller seller = item.getSeller();
                    if (!payouts.containsKey(seller)) {
                        payouts.put(seller, new SellerPayout());
                    }
                    SellerPayout payout = payouts.get(seller);
                    long lineValue = item.unitCharge() * line.getQuantity();
                    long commission = item.commissionOn(lineValue);
                    payout.addSales(lineValue);
                    payout.addCommission(commission);
                    if (line.returned()) {
                        payout.addRefund(lineValue);
                    }
                }
            }
        }
        long totalSellerPayouts = 0;
        for (SellerPayout payout : payouts.values()) {
            totalSellerPayouts += payout.payout();
        }
        long platformRevenue = totalGrandTotals - totalSellerPayouts;
        return new SettlementReport(payouts, platformRevenue);
    }

}
