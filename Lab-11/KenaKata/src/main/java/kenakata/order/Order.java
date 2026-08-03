package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
import kenakata.payment.PaymentMethod;

import java.util.Collections;
import java.util.List;

public class Order {

    public void addProduct(CatalogItem item, int quantity){

    }
    public void addAddOn(Chargeable addOn){

    }
    public void applyCoupon(Coupon coupon){

    }
    public void insure(int lineIndex){

    }
    public List<Order> lines(){
        return null;
    }
    public boolean placced(){
        return false;
    }
    public PriceBreakdown finalBreakdown(){
        return null;
    }
    public PriceBreakdown quote(int today){
        return null;
    }
    public void place(PaymentMethod payment,int today){

    }
    public void acceptReturn(int lineIndex, int today){

    }
    public PriceBreakdown priceOrder(int today){
        return null;
    }


}
