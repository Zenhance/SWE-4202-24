package kenakata.order;

import kenakata.catalog.Chargeable;

import java.util.ArrayList;

public class PriceBreakdown {
    private ArrayList<Chargeable> chargeables;
    private Coupon coupon;
    private Zone zone;

    public PriceBreakdown(ArrayList<Chargeable> chargeables, Coupon coupon, Zone zone) {
        if (chargeables == null)
            throw new IllegalArgumentException("ArrayList of chargeables cannot be null");
        this.chargeables = chargeables;

        if (coupon == null)
            throw new IllegalArgumentException("Coupon cannot be null");
        this.coupon = coupon;

        if (zone == null)
            throw new IllegalArgumentException("Delivery zone cannot be null");
        this.zone = zone;
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
        final int DHAKA = 140;
        final int  OUTSIDE = 120;

        if (zone == Zone.DHAKA) return DHAKA;
        else return OUTSIDE;
    }

    public int insurance() {
        return  0;
    }

    public int serviceFee() {
        return 0;
    }

    public int grandTotal() {
        return 0;
    }
}
