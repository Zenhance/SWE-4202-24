package kenakata.order;

import kenakata.catalog.ExpressHandling;
import kenakata.payment.MobileWalletPayment;
import kenakata.catalog.CatalogItem;
import kenakata.catalog.GiftWrap;
import kenakata.catalog.StockedGood;
import kenakata.payment.PaymentMethod;
import kenakata.catalog.Chargeable;
import kenakata.exceptions.CheckoutException;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<OrderLine> lines = new ArrayList<>();

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

    public PriceBreakdown finalBreakdown() {
        return null;
    }

    public PriceBreakdown acceptReturn(int i, int i1) {
        return null;
    }

    public List<OrderLine> lines() {
        return lines;
    }

    public void addProduct(StockedGood p1, int i) {
    }

    public void addAddOn(ExpressHandling expressHandling) {
    }

    public void place(PaymentMethod payment, int today) throws CheckoutException {
    }

    public void addAddOn(Chargeable addOn) {
    }
}
