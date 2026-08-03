package kenakata.settlement;
import java.util.ArrayList;
import java.util.IdentityHashMap;
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
    public void register(Seller seller){
        if(seller == null){
            throw new IllegalArgumentException("Seller must not be null");
        }
        if(!containsIdentity(sellers,seller)){
            sellers.add(seller);
        }
    }
    public void record(Order order){
        if(order == null){
            throw new IllegalArgumentException("Order must not be null");
        }
        if(!order.placed()){
            throw new IllegalArgumentException("Only placed orders may be recorded");
        }
        orders.add(order);
    }
    public SettlementReport settle(){
        Map<Seller, Totals> totals = new IdentityHashMap<>();
        for(Seller seller: sellers){
            totals.put(seller,new Totals());
        }
        long platformRevenue = 0;
        for(Order order:orders){
            PriceBreakdown breakdown = order.finalBreakdown();
            long addOnRevenue = 0;
            long orderCommission = 0;

            for(OrderLine line: order.lines()){
                if(line.unit() instanceof CatalogItem item){
                    Totals sellerTotals = totals.computeIfAbsent(item.seller(),ignored->new Totals());
                    long value = line.lineValue();
                    long commission = item.commissionOn(value);
                    sellerTotals.grossSales = Math.addExact(sellerTotals.grossSales,value);
                    sellerTotals.commission = Math.addExact(sellerTotals.commission,commission);
                    orderCommission = Math.addExact(orderCommission,commission);
                    if(line.returned()){
                        sellerTotals.refunds = Math.addExact(sellerTotals.refunds,value);
                    }
                }else{
                    addOnRevenue = Math.addExact(addOnRevenue,line.lineValue());
                }
        }
            long orderPlatform = orderCommission;
            orderPlatform = Math.addExact(orderPlatform,addOnRevenue);
            orderPlatform=Math.addExact(orderPlatform,breakdown.delivery());
            orderPlatform=Math.addExact(orderPlatform,breakdown.vat());
            orderPlatform=Math.addExact(orderPlatform,breakdown.serviceFee());
            orderPlatform=Math.addExact(orderPlatform,breakdown.discount());
            orderPlatform=Math.addExact(platformRevenue,orderPlatform);
        }
        List<SellerPayout> payouts=new ArrayList<>();
        for(Seller seller:sellers){
            Totals sellerTotals=totals.getOrDefault(seller,new Totals());
            long payout=Math.subtractExact(Math.subtractExact(sellerTotals.grossSales,sellerTotals.commission),sellerTotals.refunds);
           payouts.add(new SellerPayout(seller,sellerTotals.grossSales,sellerTotals.commission,sellerTotals.refunds,payout)
           );
        }
        for(Map.Entry<Seller,Totals>entry:totals.entrySet()){
            Seller seller=entry.getKey();
            if(!containsIdentity(sellers,seller)){
                Totals sellerTotals=entry.getValue();
                long payout=Math.subtractExact(Math.subtractExact(sellerTotals.grossSales,sellerTotals.commission),sellerTotals.refunds);
            payouts.add(new SellerPayout(seller,sellerTotals.grossSales,sellerTotals.commission,sellerTotals.refunds,payout));

            }
        }
        return new SettlementReport(payouts,platformRevenue);
}
private static boolean containsIdentity(List<Seller>list,Seller target){
        for(Seller seller:list){
            if(seller==target){
                return true;
            }
        }return false;
}
private static final class Totals{
        long grossSales;
        long commission;
        long refunds;
}
}
