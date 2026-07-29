package kenakata.order;

import kenakata.catalog.Chargeable;

import java.util.ArrayList;

public class PriceBreakdown {
    private ArrayList<Chargeable> chargeables;
    private Coupon coupon;

    public PriceBreakdown(ArrayList<Chargeable> chargeables, Coupon coupon) {
        this.chargeables = chargeables;
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
        return discount;
    }

    public int vat() {
        int totalVat = 0;
        for (Chargeable c : chargeables) {
            totalVat += c.unitVat();
        }
        return  totalVat;
    }
}
