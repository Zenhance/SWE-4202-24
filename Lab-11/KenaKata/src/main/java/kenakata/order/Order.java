package kenakata.order;

import kenakata.catalog.DigitalGood;
import kenakata.catalog.FreshGood;
import kenakata.catalog.GiftWrap;
import kenakata.catalog.StockedGood;
import kenakata.payment.Chargeable;
import kenakata.settlement.CatalogItem;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public Order(Zone zone, DeliveryCalculator deliveryCalculator) {
    }

    public void addProduct(FreshGood stockedGood, int i) {
    }

    public void addAddOn(GiftWrap giftWrap) {
    }

    public void applyCoupon(Coupon eid10) {
    }

    public void addProduct(StockedGood stockedGood, int i) {
    }

    public void addProduct(DigitalGood e, int i) {
    }

    public PriceBreakdown quote(int i) {
        return null;
    }

    public void insure(int i) {
    }

    public void place(MobileWalletPayment mobileWalletPayment, int i) {
    }

    public boolean placed() {
    }

    public PriceBreakdown finalBreakdown() {
        return null;
    }

    public void addProduct(CatalogItem item, int i) {
    }

    public void addAddOn(Chargeable unit) {
    }

    public void acceptReturn(int i, int i1) {
    }

    public Map<Object, Object> lines() {
        return null;
    }
}
