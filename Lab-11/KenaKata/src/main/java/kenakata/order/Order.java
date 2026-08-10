package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.ExpressHandling;
import kenakata.catalog.GiftWrap;
import kenakata.payment.PaymentMethod;
import kenakata.catalog.Chargeable;
import kenakata.catalog.FreshGood;
import kenakata.catalog.StockedGood;
import kenakata.catalog.*;

import java.util.ArrayList;

public class Order {
    ArrayList<Line> lines=new ArrayList<>();

    public Coupon coupon;
    private Zone zone;
    private DeliveryCalculator deliveryCalculator;
    private PriceBreakdown priceBreakdown;
    private ArrayList<Chargeable>items;
    private ArrayList<Integer>quantities;
    public Order(Zone zone,DeliveryCalculator deliveryCalculator){
        if(zone == null) throw new IllegalArgumentException("zone can't be null");
        if(deliveryCalculator == null) throw new IllegalArgumentException("Delivery calculator cannot be empty");
        this.zone=zone;
        this.deliveryCalculator=deliveryCalculator;
    }
     public void addProduct (CatalogItem item,int amount){
         lines.add(new Line(item,amount));
       /* items.add(item);
        quantities.add(amount);*/
     }
     public void addAddOn(Chargeable addOn){
       /* lines.add(new Line(addOn,1));*/
        items.add(addOn);
        quantities.add(1);
     }
     public void applyCoupon(Coupon coupon){
        this.coupon=coupon;
     }
     public void addAddOn(ExpressHandling expressHandling){

     }
     public PriceBreakdown quote(int currentDay){
      return null;
     }
  public void place(PaymentMethod paymentMethod,int currentDay){

  }



    public void insure(int i) {
    }

    public void acceptReturn(int i, int i1) {
    }

    public ArrayList<Line> lines() {
        return null;
    }


    public boolean placed() {
        return false;
    }

    public PriceBreakdown finalBreakdown() {
        return null;
    }
}

