package kenakata.order;

import kenakata.catalog.Chargeable;

import java.util.ArrayList;

public class PriceBreakdown {
    private ArrayList<Chargeable> chargeables;
    private Coupon coupon;
    private Zone zone;

    public PriceBreakdown(ArrayList<Chargeable> chargeables, Coupon coupon, Zone zone) {
        this.chargeables = chargeables;
        this.coupon = coupon;
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
        return discount;
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