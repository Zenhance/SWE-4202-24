package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
import kenakata.payment.PaymentMethod;

import java.util.function.Supplier;

public class Order {
    public void addProduct(CatalogItem item, int i) {
    }

    public void addAddOn(Chargeable giftWrap) {
    }

    public void applyCoupon(Coupon eid10) {
    }

    public PriceBreakdown quote(int i) {
    }

    public void insure(int i) {
    }

    public void place(PaymentMethod payment, int today) {
    }

    public void acceptReturn(int i, int i1) {
    }

    public boolean placed() {
    }

    public PriceBreakdown finalBreakdown() {
    }

    public Supplier<Object> lines() {
    }
}
