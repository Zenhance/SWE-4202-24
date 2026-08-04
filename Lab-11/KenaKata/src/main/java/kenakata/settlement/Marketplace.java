package kenakata.settlement;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Seller;
import kenakata.order.Order;
import kenakata.order.OrderLine;
import kenakata.order.PriceBreakdown;

import java.util.ArrayList;
import java.util.List;

public class Marketplace {
    private final List<Seller> sellerss=new ArrayList<>();
    private final List<Order>placedorders= new ArrayList<>();
    public void register(Seller seller){
        if(seller!=null && !sellerss.contains(seller)){
            sellerss.add(seller);
        }
    }
    public void record(Order order){
        if(order==null)
            throw new IllegalArgumentException("Invalid");
        placedorders.add(order);
    }

    public SettlementReport settle(){
        List<SellerPayOut>payoutList= new ArrayList<>();
        for(Seller seller : sellerss){
            long grossSales = 0;
            long commission = 0;
            long refunds = 0;
            for(Order order:placedorders){
                PriceBreakdown d=order.finalBreakdown();
                Object platformRevenue = d.delivery();
                platformRevenue = platformRevenue + d.vat();
                platformRevenue = platformRevenue + d.serviceFee();
                platformRevenue = platformRevenue + d.insurance();
                platformRevenue = platformRevenue - d.discount();
                for(OrderLine line: order.line()){
                    if (!line.isproduct()) {
                        platformRevenue += line.Charge();
                        continue;
                    } CatalogItem item = line.product();

                    if (item.getSeller() != seller) {
                        continue;
                    }
                    long value =line.Charge();
                    grossSales+=value;
                    long comm=item.commissionOn(value);
                    commission += comm;

                    platformRevenue += comm;

                    if (line.returned()) {
                        refunds += value;
                    }


                }
            }long payout=grossSales - commission - refunds;
            payoutList.add(
                    new SellerPayOut(
                            seller,
                            grossSales,
                            commission,
                            refunds,
                            payout
                    )
            );
            return new SettlementReport(
                    payoutList,
                    platformRevenue
            );

        }



