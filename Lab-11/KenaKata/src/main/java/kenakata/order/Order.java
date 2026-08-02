package kenakata.order;

import kenakata.catalog.*;
import kenakata.payment.PaymentMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Order {
    public  ArrayList<OrderLine> Lines= new ArrayList<>();
    public Order(Zone zone, DeliveryCalculator delivery) {
    }

    public void addProduct(StockedGood lamp, int i) {
    }

    public void place(PaymentMethod payment, int today) {
    }

    public void addAddOn(GiftWrap giftWrap) {
    }

    public void applyCoupon(Coupon eid10) {
    }

    public void addProduct(FreshGood hilsa, int i) {
    }

    public void addProduct(DigitalGood ebook, int i) {
    }
        PriceBreakdown P=  new PriceBreakdown(5);

    public PriceBreakdown quote(int today) {
        return P;
    }

    public void insure(int i) {
    }

    public void acceptReturn(int i, int i1) {
    }

    public void addAddOn(ExpressHandling expressHandling) {
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

    public void addProduct(CatalogItem item, int i) {
    }

    public void addAddOn(Chargeable unit) {
    }
}
