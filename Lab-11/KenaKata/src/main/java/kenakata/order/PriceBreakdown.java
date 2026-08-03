package kenakata.order;

import kenakata.catalog.*;

import java.util.ArrayList;

public class PriceBreakdown {
    private ArrayList<Chargeable> chargeables;
    private Coupon coupon;
    private Zone zone;

    public PriceBreakdown(ArrayList<Chargeable> chargeables, Zone zone) {
        if (chargeables == null)
            throw new IllegalArgumentException("ArrayList of chargeables cannot be null");
        this.chargeables = chargeables;

        if (zone == null)
            throw new IllegalArgumentException("Delivery zone cannot be null");
        this.zone = zone;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public int subtotal() {
        int subtotal = 0;
        for (Chargeable c : chargeables) {
            subtotal += c.unitCharge();
        }
        return subtotal;
    }

    public int discountableAmount() {
        int amount = 0;
        for (Chargeable c : chargeables) {
            if (c instanceof StockedGood)
                amount += c.unitCharge();
        }
        return amount;
    }

    public int discount() {
        int discount = 0;
        discount += (int) Math.ceil(discountableAmount() * coupon.getPercentage() * 0.01);

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

        if (calculator.onlyDigitalGood())
            return 0;

        int deliveryCharge = calculator.deliveryZone(zone);

        if (calculator.hasFreshGood())
            deliveryCharge += 50;

        deliveryCharge += calculator.billedWeight(zone);
        return deliveryCharge;
    }

    public int insurance() {
        int totalInsurance = 0;
        for (Chargeable c : chargeables) {
            if (c instanceof Insurable i)
                totalInsurance += i.insurance();
        }

        return Math.max(totalInsurance, 20);
    }

    public int serviceFee() {
        return (int) Math.ceil(subtotal() * 0.01);
    }

    public int grandTotal() {
        return subtotal() - discount() + delivery() + vat() + insurance() + serviceFee();
    }
}
