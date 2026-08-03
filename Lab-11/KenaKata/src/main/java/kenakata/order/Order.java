package kenakata.order;

import kenakata.catalog.*;
import kenakata.exceptions.*;
import kenakata.payment.PaymentMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private Zone zone;
    private DeliveryCalculator deliveryCalculator;
    private List<OrderLine> lines = new ArrayList<>();
    private Coupon coupon;
    private boolean isPlaced = false;
    private PriceBreakdown finalBreakdown;
    private int placementDay;

    public Order(Zone zone, DeliveryCalculator deliveryCalculator) {
        if (zone == null || deliveryCalculator == null) {
            throw new IllegalArgumentException("Zone and DeliveryCalculator must not be null");
        }
        this.zone = zone;
        this.deliveryCalculator = deliveryCalculator;
    }

    public void addProduct(CatalogItem item, int quantity) {
        lines.add(new OrderLine(item, quantity));
    }

    public void addAddOn(Chargeable addOn) {
        lines.add(new OrderLine(addOn, 1));
    }

    public void applyCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public void insure(int lineIndex) throws NonInsurableException {
        if (lineIndex < 0 || lineIndex >= lines.size()) {
            throw new IllegalArgumentException("Invalid line index");
        }
        OrderLine line = lines.get(lineIndex);
        if (line.item() instanceof Insurable) {
            line.setInsured(true);
        } else {
            throw new NonInsurableException("Non Insurable Product");
        }
    }

    public PriceBreakdown quote(int day) throws CheckoutException {
        long subtotal = 0;
        long discountableBase = 0;
        long vat = 0;
        long insurance = 0;

        for (OrderLine line : lines) {
            long lValue = line.lineValue();
            subtotal += lValue;
            vat += line.lineVat();

            if (line.item() instanceof StockedGood) {
                discountableBase += lValue;
            }

            if (line.isInsured()) {
                long insFee = (long) Math.ceil(lValue * 0.01);
                insurance += Math.max(insFee, 20);
            }
        }
    }
}