package kenakata.order;

import kenakata.catalog.*;
import kenakata.payment.PaymentMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Order {
    public CatalogItem item;
    public Coupon coupon;
    public PaymentMethod payment;
    public int quantity;
    public AddOn addOn;
    public PriceBreakdown P;
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
        this.payment=payment;

    }

    public void applyCoupon(Coupon coupon) {
        if (coupon==null)
            throw new IllegalArgumentException();
        this.coupon=coupon;
    }


    public PriceBreakdown quote(int today) {
        P = null;
        return P;
    }

    public void insure(int i) {
    }

    public void acceptReturn(int i, int i1) {
    }

    public boolean placed() {
    return true;
    }
    public PriceBreakdown finalBreakdown() {
        P = null;
        return P;
    }
    public ArrayList<OrderLine> lines() {
        return this.Lines;
    }

}
