package kenakata;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.GiftWrap;
import kenakata.catalog.StockedGood;

import java.util.Map;

public class Order {
    public Order(Object dhaka, DeliveryCalculator deliveryCalculator) {
    }

    public void addProduct(CatalogItem stockedGood, int i) {

    }

    public void addAddOn(GiftWrap giftWrap) {
    }

    public void applyCoupon(Coupon eid10) {

    }

    public PriceBreakdown quote(int i) {
        return null;
    }

    public void insure(int i) {
    }

    public void place(MobileWalletPayment mobileWalletPayment, int i) {
    }

    public boolean placed() {
        return true;
    }

    public Object finalBreakdown() {
        return null;
    }

    public void acceptReturn(int i, int i1) {
    }

    public Map<Object, Object> lines() {
        return null;
    }

    public void addProduct(StockedGood p1, int i) {
    }
}
