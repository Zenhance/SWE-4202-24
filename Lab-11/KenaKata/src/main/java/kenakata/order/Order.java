package kenakata.order;

import kenakata.catalog.DigitalGood;
import kenakata.catalog.GiftWrap;
import kenakata.catalog.StockedGood;
import kenakata.payment.MobileWalletPayment;

public class Order {
    public Order(Object dhaka, DeliveryCalculator deliveryCalculator) {
    }

    public void addProduct(StockedGood stockedGood, int i) {
    }

    public void addAddOn(GiftWrap giftWrap) {
    }

    public void applyCoupon(Coupon eid10) {
    }

    public Object quote(int i) {

        return null;
    }

    public void insure(int i) {
    }

    public void place(MobileWalletPayment mobileWalletPayment, int i) {
    }

    public boolean placed() {
        return true;
    }

    public @org.jspecify.annotations.Nullable Object finalBreakdown() {
        return null;
    }
}
