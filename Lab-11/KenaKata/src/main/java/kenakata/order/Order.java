package kenakata.order;


import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
import kenakata.catalog.GiftWrap;
import kenakata.catalog.StockedGood;
import kenakata.exceptions.CheckoutException;
import kenakata.payment.MobileWalletPayment;
import kenakata.payment.PaymentMethod;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.function.Supplier;

public class Order {
private  Zone zone;
private  DeliveryCalculator deliveryCalculator;
public  List<OrderLine> lines =  new ArrayList<>();
private Coupon coupon;
private boolean placed;
private PriceBreakdown priceBreakdown;

    public Order(Zone zone, DeliveryCalculator deliveryCalculator) {
        this.zone = zone;
        this.deliveryCalculator = deliveryCalculator;
    }

    public void addProduct(CatalogItem item, int quantity) {
        lines.add(new OrderLine(item, quantity));
    }

    public void insure(int i) {
    }

    public void applyCoupon(Coupon c) {
        coupon = c;
    }

    public void addAddOn(Chargeable addon) {
        lines.add(new OrderLine(addon,1));
    }

    public boolean placed() {
        return false;
    }



    public PriceBreakdown finalBreakdown() {
        return null;
    }

    public void acceptReturn(int i, int i1) {

    }


    public PriceBreakdown quote(int i) {
        return null;
    }

    public void place(PaymentMethod payment, int today) throws CheckoutException {
    }

    public ArrayList<OrderLine> lines() {
        return null;
    }
}

