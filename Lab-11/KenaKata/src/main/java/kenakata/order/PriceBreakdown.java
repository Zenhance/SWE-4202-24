package kenakata.order;

import kenakata.catalog.Chargeable;
import kenakata.catalog.DigitalGood;
import kenakata.catalog.FreshGood;
import kenakata.catalog.StockedGood;

import java.util.ArrayList;

public class PriceBreakdown {
    private ArrayList<Chargeable> chargeables;
    private Coupon coupon;
    private Zone zone;

    public PriceBreakdown(ArrayList<Chargeable> chargeables, Coupon coupon, Zone zone) {
        if (chargeables == null)
            throw new IllegalArgumentException("ArrayList of chargeables cannot be null");
        this.chargeables = chargeables;

        if (zone == null)
            throw new IllegalArgumentException("Delivery zone cannot be null");
        this.zone = zone;

        this.coupon = coupon;
    }

    public int subtotal() {
        int subtotal = 0;
        for (Chargeable c : chargeables) {
            subtotal += c.unitCharge();
        }
        return subtotal;
    }

    public int discount() {
        int discount = (int) Math.ceil(subtotal() * coupon.getPercentage() * 0.01);
        return Math.min(discount, coupon.getCap());
    }

    public int vat() {
        int totalVat = 0;
        for (Chargeable c : chargeables) {
            totalVat += c.unitVat();
        }
        return  totalVat;
    }

    public int delivery() {
        DeliveryCalculator calculator = new DeliveryCalculator(chargeables);
        int deliveryCharge = 0;
        final int DHAKA = 140;
        final int  OUTSIDE = 120;

        if (zone == Zone.DHAKA) deliveryCharge = DHAKA;
        else deliveryCharge = OUTSIDE;

        if (calculator.hasFreshGood())
            deliveryCharge += 50;

        if (calculator.onlyDigitalGood())
            return 0;
        return deliveryCharge;
    }

    public int insurance() {
        return  0;
    }

    public int serviceFee() {
        return (int) Math.ceil(subtotal() * 0.01);
    }

    public int grandTotal() {
        return subtotal() - discount() + delivery() + vat() + insurance() + serviceFee();
    }
}
