package kenakata.order;

import kenakata.catalog.ExpressHandling;
import kenakata.catalog.GiftWrap;
import kenakata.catalog.Product;
import kenakata.catalog.StockedGood;
import kenakata.payment.CashOnDeliveryPayment;
import kenakata.payment.PaymentMethod;

public class Order {
    public Order(Object dhaka, DeliveryCalculator delivery) {
    }

    public void addProduct(Product title, int weightInGrams) {
    }

    public void addAddOn(GiftWrap giftWrap) {
    }

    public void applyCoupon(Coupon eid10) {
    }

    public PriceBreakdown quote(int today) {
        return null;
    }

    public void place(PaymentMethod payment, int today) {
    }

    public void insure(int i) {
    }

    public void acceptReturn(int i, int i1) {
    }

    public void addAddOn(ExpressHandling expressHandling) {
    }

    public void place(CashOnDeliveryPayment cashOnDeliveryPayment, int today) {
    }
}
