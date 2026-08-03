package kenakata.settlement;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Seller;
import kenakata.order.Order;
import kenakata.order.OrderLine;

import java.util.ArrayList;
import java.util.List;

public class Marketplace {
    private List<Seller> sellers;
    private List<Order> orders;

    public Marketplace() {
        sellers = new ArrayList<>();
        orders = new ArrayList<>();
    }
    public void register(Seller seller) {
        sellers.add(seller);
    }

    public void record(Order order) {
        orders.add(order);
    }
    public SettlementReport settle() {
        List<SellerPayout> result = new ArrayList<>();
        long sellerTotal = 0;
        for(Seller seller : sellers) {
            long sales = 0;
            long commission = 0;
            long refunds = 0;
            for(Order order : orders) {
                for(OrderLine line : order.lines()) {
                    if(line.item() instanceof CatalogItem) {
                        CatalogItem item = (CatalogItem) line.item();
                        if(item.seller() == seller) {
                            long value = line.value();
                            sales += value;
                            commission += item.commissionOn(value);
                            if(line.returned()) {
                                refunds += value;
                            }
                        }
                    }
                }
            }
            SellerPayout payout = new SellerPayout(seller, sales, commission, refunds);
            result.add(payout);
            sellerTotal += payout.payout();
        }
        long customerMoney = 0;
        for(Order order : orders) {
            customerMoney += order.finalBreakdown().grandTotal();
        }
        long platformRevenue = customerMoney - sellerTotal;
        return new SettlementReport(result, platformRevenue);
    }
}