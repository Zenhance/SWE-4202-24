package kenakata.order;

import kenakata.catalog.AddOn;
import kenakata.catalog.Chargeable;
import kenakata.catalog.Good;
import kenakata.payment.PaymentMethod;

import java.util.ArrayList;

public class Order {
    private Zone zone;
    private DeliveryCalculator calculator;
    private ArrayList<Chargeable> chargeables;
    private Coupon coupon;

    public Order(Zone zone, DeliveryCalculator calculator) {
        this.zone = zone;
        this.calculator = calculator;
    }

    public void addProduct(Good product, int qty) {
        for (int i = 0; i < qty; i++)
            chargeables.add(product);
    }

    public void addAddOn(AddOn addOn) {
        chargeables.add(addOn);
    }

    public void applyCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public PriceBreakdown quote(int amount) {
        PriceBreakdown p = new PriceBreakdown(chargeables, coupon, zone);
        return p;
    }

    public void insure(int number) {

    }

    // fix the parameter
    public void place(PaymentMethod p, int something) {

    }

    public boolean placed() {
        return false;
    }

    public PriceBreakdown finalBreakdown() {
        return new PriceBreakdown(chargeables, coupon, zone);
    }
}
