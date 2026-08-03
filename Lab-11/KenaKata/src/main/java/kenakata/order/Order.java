package kenakata.order;

import kenakata.catalog.AddOn;
import kenakata.catalog.Chargeable;
import kenakata.catalog.CatalogItem;
import kenakata.exceptions.CheckoutException;
import kenakata.exceptions.ReturnNotAllowedException;
import kenakata.payment.PaymentMethod;

import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;

public class Order {
    private Zone zone;
    private DeliveryCalculator calculator;
    private ArrayList<Chargeable> chargeables;
    private Coupon coupon;

    public Order(Zone zone, DeliveryCalculator calculator) {
        if (zone == null)
            throw new IllegalArgumentException("Delivery zone cannot be null");
        this.zone = zone;

        if (calculator == null)
            throw new IllegalArgumentException("Delivery calculator cannot be null");
        this.calculator = calculator;
    }

    public void addProduct(Chargeable product, int qty) {
        for (int i = 0; i < qty; i++)
            chargeables.add(product);
    }

    public void addAddOn(Chargeable addOn) {
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

    // check the parameter
    public void place(PaymentMethod p, int day) throws CheckoutException {

    }

    public boolean placed() {
        return false;
    }

    public PriceBreakdown finalBreakdown() {
        return new PriceBreakdown(chargeables, coupon, zone);
    }

    public void acceptReturn(int serial, int day) throws ReturnNotAllowedException {

    }

    public ArrayList<Chargeable> lines() {
        return chargeables;
    }
}
