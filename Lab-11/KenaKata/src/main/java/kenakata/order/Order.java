package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.GiftWrap;

import java.util.ArrayList;

public class Order {
    ArrayList<Line> lines=new ArrayList<>();
    private Coupon coupon;
    private Zone zone;
    private DeliveryCalculator deliveryCalculator;
    private PriceBreakdown priceBreakdown;
    public Order(Zone zone,DeliveryCalculator deliveryCalculator){
        if(zone == null) throw new IllegalArgumentException("zone can't be null");
        if(deliveryCalculator == null) throw new IllegalArgumentException("Delivery calculator cannot be empty");
        this.zone=zone;
        this.deliveryCalculator=deliveryCalculator;
    }
     public void addProduct (CatalogItem item,int quantity){
        lines.add(new Line(item, quantity));
     }
     public void applyCoupon(Coupon coupon){
        this.coupon=coupon;
     }
     public void addAddOn(GiftWrap giftWrap){

     }


     }

