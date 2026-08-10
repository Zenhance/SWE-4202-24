package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
import kenakata.exceptions.CheckoutException;
import kenakata.exceptions.NotInsurableException;

import kenakata.payment.PaymentMethod;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private final Zone zone;
    private final DeliveryCalculator delivery;

    private final List<OrderLine> lines = new ArrayList<>();

    private Coupon coupon;
    private PaymentMethod payment;

    private boolean placed = false;

    public Order(Zone zone, DeliveryCalculator delivery) {
        if (zone == null) {
            throw new IllegalArgumentException("Zone cannot be null");
        }

        if (delivery == null) {
            throw new IllegalArgumentException("Delivery calculator cannot be null");
        }

        this.zone = zone;
        this.delivery = delivery;
    }

    public Zone zone() {
        return zone;
    }

    public List<OrderLine> lines() {
        return lines;
    }

    public boolean placed() {
        return placed;
    }

    public void addProduct(CatalogItem item, int quantity) {
        lines.add(new OrderLine(item, quantity));
    }

    public void addProduct(Chargeable item, int quantity) {
        lines.add(new OrderLine(item, quantity));
    }

    public void addAddon(Chargeable addon) {
        lines.add(new OrderLine(addon, 1));
    }

    public void applyCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public void place(PaymentMethod payment, int day)
            throws CheckoutException {

        this.payment = payment;

        for (OrderLine line : lines) {
            line.markPlaced(day);
        }

        placed = true;
    }

    public PriceBreakdown quote(int day) {
        long subtotal = 0;

        for (OrderLine line : lines) {
            subtotal += line.charge();
        }

        return new PriceBreakdown(
                subtotal,
                0,
                0,
                0,
                0,
                0,
                subtotal
        );
    }

    public void insure(int index) throws NotInsurableException {

        if (index < 0 || index >= lines.size()) {
            throw new IllegalArgumentException();
        }

        OrderLine line = lines.get(index);

        if (!(line.item() instanceof kenakata.catalog.Insurable)) {
            throw new NotInsurableException("Item is not insurable");
        }

        line.insure();
    }

    public void acceptReturn(int index, int day)
            throws CheckoutException {

        if (index < 0 || index >= lines.size()) {
            throw new IllegalArgumentException();
        }

        lines.get(index).markReturned(day);
    }
}