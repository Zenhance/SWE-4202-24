package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.GiftWrap;
import kenakata.catalog.StockedGood;
import kenakata.exceptions.EmptyWalletException;
import kenakata.exceptions.NotInsurableException;
import kenakata.exceptions.CouponRejectedException;
import kenakata.payment.MobileWalletPayment;

import java.util.ArrayList;
import java.util.List;



public class Order {
    private final Zone zone;
    private final DeliveryCalculator deliveryCalculator;

    public Order(Zone zone, DeliveryCalculator deliveryCalculator){
        this.zone = zone;
        this.deliveryCalculator= deliveryCalculator;
    }


    public void addProduct(CatalogItem item, int i) {
        
    }

    public void addAddOn(Object addOn){
        
    }

    public void applyCoupon(Coupon eid10) {
    }
    public void insure(int value){

    }

    public PriceBreakdown quote(int i) {
        return null;
    }

}
