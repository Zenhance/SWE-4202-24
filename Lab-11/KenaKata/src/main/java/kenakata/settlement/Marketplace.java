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
}
