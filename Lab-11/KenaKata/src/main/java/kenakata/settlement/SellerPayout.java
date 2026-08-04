package kenakata.settlement;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Seller;
import kenakata.order.Order;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SellerPayout {


    public Seller s;
    public ArrayList<CatalogItem> items = new ArrayList<>();
    public ArrayList<Integer> count = new ArrayList<>();

    public int commission() {
        int total = 0;
        for(int i = 0; i < items.size(); i++){
            CatalogItem c = items.get(i);
                total += ((CatalogItem) c).commissionOn(c.unitCharge()) * count.get(i);
        }
        return total;
    }

    public int grossSales() {
        int total = 0;
        for(int i=0; i<items.size(); i++){
            total += items.get(i).unitCharge() * count.get(i);
        }
        return total-refunds();
    }

    public int payout() {
        return grossSales()-commission();
    }


    public int refunds() {
        int total = 0;
        for(int i=0; i<items.size(); i++){
            CatalogItem c = items.get(i);
            if(c.isReturned()){
                total += c.unitCharge()*count.get(i);
            }
        }
        return total;
    }

    public Seller seller() {
        return s;
    }
}
