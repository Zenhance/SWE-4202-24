package kenakata.settlement;
import kenakata.catalog.CatalogItem;
import kenakata.catalog.Seller;
import kenakata.order.*;

import java.util.ArrayList;
import java.util.List;

public class Marketplace {
    private final List<Seller> registeredSellers = new ArrayList<>();
    private final List<Order>placedOrders= new ArrayList<>();

    public void register(Seller seller){
        if(seller != null && !registeredSellers.contains(seller)){
            registeredSellers.add(seller);
        }
    }
    public void record(Order order){
        if(order != null && order.placed()){
            placedOrders.add(order);
        }
    }
    public SettlementReport settle() {
        List<SellerPayout> payoutList = new ArrayList<>();
        for (Seller seller : registeredSellers) {
            payoutList.add(new SellerPayout(seller));
        }

        long platformRevenue = 0;
        for (Order order : placedOrders) { //processing each placed order
            PriceBreakdown bd = order.finalBreakdown();
            platformRevenue += bd.delivery() + bd.vat() + bd.serviceFee() + bd.insurance() - bd.discount();

            for (OrderLine line : order.lines()) { //looks at each item separately
                Chargeable item = line.item();
                if (item instanceof CatalogItem catalogItem) {
                    Seller seller = catalogItem.seller();
                    SellerPayout payout = findPayoutForSeller(payoutList, seller);

                    long lineValue = line.lineValue(); //calculates total line price(unit price x quantity)
                    payout.addSales(lineValue);

                    long comm = catalogItem.commissionOn(lineValue); // take platform commission
                    payout.addCommission(comm);
                    platformRevenue += comm;
                    if (line.returned()) { // handle customer returns
                        payout.addRefund(lineValue);
                    }
                } else {
                    platformRevenue += line.lineValue();
                }
            }
        }
        return new SettlementReport(payoutList, platformRevenue);
    }
    //helper method
    private SellerPayout findPayoutForSeller(List<SellerPayout>payouts,Seller seller){
        for(SellerPayout payout : payouts){
            if(payout.seller().equals(seller)){
                return payout;
            }
        }
        SellerPayout newPayout = new SellerPayout(seller);
        payouts.add(newPayout);
        return newPayout;

            }
    }

