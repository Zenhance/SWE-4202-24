package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
import kenakata.exceptions.CheckoutException;
import kenakata.payment.PaymentMethod;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Zone zone;
    private Coupon coupon;
    private PriceBreakdown priceBreakdown;
    private DeliveryCalculator deliveryCalculator;
    private List<OrderLine> lines=new ArrayList<>();

    public Order(Zone zone,DeliveryCalculator deliveryCalculator){
        this.zone=zone;
        this.deliveryCalculator=deliveryCalculator;
    }

    public void addProduct(CatalogItem item,int quantity){

    }

    public void addAddOn(Chargeable addOn){

    }

    public void place(PaymentMethod payment,int day){

    }

    public void applyCoupon(Coupon coupon){

    }

    public PriceBreakdown quote(int day){

    }


}
