package kenakata.order;

import kenakata.catalog.*;
import kenakata.exceptions.CouponRejectedException;
import kenakata.exceptions.EmptyWalletException;
import kenakata.exceptions.NotInsurableException;
import kenakata.payment.MobileWalletPayment;
import kenakata.payment.PaymentMethod;

import java.util.Map;

public class Order {

    private PriceBreakdown finalBreakdown;
    public Order(Object dhaka, DeliveryCalculator deliveryCalculator) {
    }

    public void addProduct(CatalogItem item, int quantity) {

    }

    public void addAddOn(GiftWrap giftWrap) {
    }

    public void applyCoupon(Coupon eid10) {
    }

    public PriceBreakdown quote(int i) throws CouponRejectedException {

        return finalBreakdown;
    }

    public void insure(int i) throws NotInsurableException {
    }

    public void place(PaymentMethod payment, int i) throws EmptyWalletException {
    }

    public boolean placed() {
        return true;
    }

    public @org.jspecify.annotations.Nullable Object finalBreakdown() {
        return null;
    }

    public void acceptReturn(int i, int i1) {
    }

    public Map<Object, Object> lines() {
    }

    public void addAddOn(Chargeable unit) {
    }
}
