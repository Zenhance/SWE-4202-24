package kenakata.settlement;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Seller;
import kenakata.order.Order;
import kenakata.order.OrderLine;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Marketplace {
    private final Set<Seller> sellers=new LinkedHashSet<>();
    private final List<Order> recordedOrders = new ArrayList<>();

    public void register(Seller seller){
        sellers.add(seller);
    }

    public void record(Order order){
        if(!order.placed()){
            throw new IllegalStateException("Only a placed order can be recorded for settlement");
        }
        recordedOrders.add(order);
    }

    public SettlementReport settle(){
        Map<Seller, Integer> grossSales = new LinkedHashMap<>();
        Map<Seller, Integer> commissions = new LinkedHashMap<>();
        Map<Seller, Integer> refunds= new LinkedHashMap<>();
        for(Seller seller: sellers){
            grossSales.put(seller,0);
            commissions.put(seller,0);
            refunds.put(seller,0);
        }

        int totalPaidByCustomers=0;
        for(Order order: recordedOrders){
            totalPaidByCustomers+= order.finalBreakdown().grandTotal();

            for(OrderLine line: order.lines()){
                if(!(line.item() instanceof CatalogItem catalogItem)){
                    continue;
                }
                Seller seller=catalogItem.seller();
                if(!sellers.contains(seller)){
                    continue;
                }
                int lineCharge=catalogItem.unitCharge()*line.quantity();
                grossSales.merge(seller,lineCharge,Integer::sum);
                commissions.merge(seller,catalogItem.commissionOn(lineCharge),Integer::sum);
                if(line.returned()){
                    refunds.merge(seller,lineCharge,Integer::sum);
                }
            }
        }
         Map<Seller, SellerPayout> payouts=new LinkedHashMap<>();
        int totalPaidToSellers=0;
        for(Seller seller:sellers){
            SellerPayout payout=new SellerPayout(seller,grossSales.get(seller),commissions.get(seller),refunds.get(seller));
            payouts.put(seller,payout);
            totalPaidToSellers+=payout.payout();
        }

        int platformRevenue= totalPaidByCustomers-totalPaidToSellers;
        return new SettlementReport(payouts,platformRevenue);
    }
}
