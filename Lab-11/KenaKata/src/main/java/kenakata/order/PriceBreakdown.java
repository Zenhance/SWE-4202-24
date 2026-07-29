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
}
