package kenakata.settlement;
import kenakata.catalog.CatalogItem;
import kenakata.order.*;

import java.util.ArrayList;
import java.util.List;

public class Marketplace {
    private final List<Seller> registeredSellers = new ArrayList<>();
    private final List<Order>placeOrders= new ArrayList<>();

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
    }
}
