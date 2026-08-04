package kenakata.order;

import kenakata.catalog.*;
import kenakata.exceptions.*;
import kenakata.payment.*;

import java.util.*;

public class Order {
    private final Zone zone;
    private final DeliveryCalculator deliveryCalc;
    private final List<OrderLine> lines = new ArrayList<>();
    private final List<Chargeable> addOns = new ArrayList<>();
    private Coupon coupon;
    private PriceBreakdown finalBreakdown;
    private boolean placed = false;

    public Order(Zone zone, DeliveryCalculator delivery) {
        this.zone = zone;
        this.deliveryCalc = delivery;
    }

    public void addProduct(CatalogItem item, int qty) throws OutOfStockException {
        if (qty <= 0) throw new IllegalArgumentException("Quantity must be positive");
        lines.add(new OrderLine(item, qty));
    }

    public void addAddOn(Chargeable addOn) {
        addOns.add(addOn);
    }

    public void applyCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public void place(CashOnDeliveryPayment cashOnDeliveryPayment, int today) {
    }

    public void acceptReturn(int i, int i1) {
    }

    public PriceBreakdown quote(int today) {
    }
}


