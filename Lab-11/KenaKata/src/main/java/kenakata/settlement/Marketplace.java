package kenakata.settlement;

import kenakata.catalog.Seller;
import kenakata.order.Order;
import kenakata.catalog.CatalogItem;
import kenakata.order.OrderLine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Marketplace {
    private final List<Seller> registeredSellers=new ArrayList<>();
    private final List<Order> recordedOrders = new ArrayList<>();
    public void register(Seller seller){
        registeredSellers.add(seller);
    }
    public void record(Order order){
        if(order.placed()){
            recordedOrders.add(order);
        }
    }
    public SettlementReport settle(){
        Map<Seller,Long> grossSalesMap = new HashMap<>();
        Map<Seller, Long>commissionMap=new HashMap<>();
        Map<Seller, Long>refundsMap=new HashMap<>();
        for(Seller seller:registeredSellers){
            grossSalesMap.put(seller,0L);
            commissionMap.put(seller,0L);
            refundsMap.put(seller,0L);
        }
        long totalCustomerPayment=0;
        for(Order order:recordedOrders){
            totalCustomerPayment+=order.finalBreakdown().grandTotal();
            for (OrderLine line: order.lines()){
                if(line.item() instanceof CatalogItem item){
                    Seller seller=item.seller();
                    if(registeredSellers.contains(seller)){
                        long lineValue= line.lineCharge();
                        long comm= item.commissionOn(lineValue);
                        grossSalesMap.put(seller,grossSalesMap.get(seller)+lineValue);
                        commissionMap.put(seller,commissionMap.get(seller));
                        if(line.returned()){
                            refundsMap.put(seller,refundsMap.get(seller)+lineValue);
                        }
                    }
                }
            }

        }
        List<SellerPayout>payouts=new ArrayList<>();
        long totalSellerPayouts=0;
        for (Seller seller:registeredSellers){
            long gross=grossSalesMap.get(seller);
            long comm=commissionMap.get(seller);
            long ref=refundsMap.get(seller);
            long netPayout=gross-comm-ref;
            payouts.add(new SellerPayout(seller,gross,comm,ref,netPayout));
            totalSellerPayouts+=netPayout;
        }
        long platformRevenue=totalCustomerPayment-totalSellerPayouts;
        return new SettlementReport(payouts,platformRevenue);
    }
}
