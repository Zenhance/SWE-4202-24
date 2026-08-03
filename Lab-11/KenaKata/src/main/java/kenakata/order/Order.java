package kenakata.order;

import kenakata.catalog.*;
import kenakata.payment.PaymentMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Order {
    public CatalogItem item;
    public int quantity;
    public AddOn addOn;
    public  ArrayList<OrderLine> Lines= new ArrayList<>();

    public Order(Zone zone, DeliveryCalculator delivery) {
    }

    public void addProduct(CatalogItem item, int quantity) {
        this.item=item;
        this.quantity=quantity;
        Lines.add(new OrderLine(item,quantity));
    }
    public void addAddOn(Chargeable addon) {
        this.addOn=addOn;
    }

    public void place(PaymentMethod payment, int today) {
    }

    public void applyCoupon(Coupon eid10) {
    }


    public PriceBreakdown quote(int today) {
        PriceBreakdown finalBreakdown = null;
        return finalBreakdown;
    }

    public void insure(int i) {
    }

    public void acceptReturn(int i, int i1) {
    }

    public boolean placed() {
    return true;
    }

    public PriceBreakdown finalBreakdown() {
        PriceBreakdown finalBreakdown = null;
        return finalBreakdown;
    }

    public ArrayList<OrderLine> lines() {
        return this.Lines;
    }

}
