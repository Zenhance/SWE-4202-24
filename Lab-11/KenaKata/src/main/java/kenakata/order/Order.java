package kenakata.order;

//import kenakata.catalog.AddOn;
import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
import kenakata.exceptions.CheckoutException;
import kenakata.exceptions.CouponRejectedException;
import kenakata.exceptions.NotInsurableException;
import kenakata.exceptions.OutOfStockException;
import kenakata.exceptions.ReturnNotAllowedException;
import kenakata.payment.PaymentMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private final Zone zone;
    private final DeliveryCalculator deliveryCalculator;
    private final List<OrderLine> lines = new ArrayList<>();
    private Coupon appliedCoupon;

    private boolean placed;
    private int placedDay;
    private PriceBreakdown finalBreakdown;

    public Order(Zone zone, DeliveryCalculator deliveryCalculator) {
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
        this.appliedCoupon = coupon;
    }

    public void insure(int lineIndex) throws NotInsurableException {
        OrderLine line = lines.get(lineIndex);
        if (line.unit() instanceof CatalogItem item && item.isInsurable()) {
            line.setInsured(true);
        } else {
            throw new NotInsurableException("Line is not insurable");
        }
    }

    public PriceBreakdown quote(int today) throws CouponRejectedException {
        long subtotal = 0;
        long discountableBase = 0;
        long vat = 0;
        long insurance = 0;

        for (OrderLine line : lines) {
            subtotal += line.lineCharge();
            vat += line.lineVat();

            if (line.unit() instanceof CatalogItem item) {
                if (item.isDiscountable()) discountableBase += line.lineCharge();
                if (line.isInsured()) {
                    long baseInsurance = (long) Math.ceil(line.lineCharge() * 0.01);
                    insurance += Math.max(20, baseInsurance);
                }
            }
        }

        long discount = (appliedCoupon != null) ? appliedCoupon.discount(discountableBase, subtotal, today) : 0;
        long delivery = deliveryCalculator.calculate(lines, zone);
        long serviceFee = Math.min(100, (long) Math.ceil(subtotal * 0.01));

        long grandTotal = subtotal - discount + delivery + vat + insurance + serviceFee;

        return new PriceBreakdown(subtotal, discount, delivery, vat, insurance, serviceFee, grandTotal);
    }

    public void place(PaymentMethod payment, int today) throws CheckoutException {
        if (placed) return;

        PriceBreakdown breakdown = quote(today);

        // Pre-flight check: Stock availability
        for (OrderLine line : lines) {
            if (line.unit() instanceof CatalogItem item && item.remaining() < line.quantity()) {
                throw new OutOfStockException("Insufficient stock for " + item.label());
            }
        }

        // Attempt Authorization (Atomic step before mutation)
        payment.authorise(breakdown.grandTotal());

        // Payment succeeded, execute reserves
        for (OrderLine line : lines) {
            if (line.unit() instanceof CatalogItem item) {
                item.reserve(line.quantity());
            }
        }

        this.placed = true;
        this.placedDay = today;
        this.finalBreakdown = breakdown;
    }

    public void acceptReturn(int lineIndex, int today) throws ReturnNotAllowedException {
        if (!placed) throw new ReturnNotAllowedException("Order is not placed");
        OrderLine line = lines.get(lineIndex);
        if (line.returned()) throw new ReturnNotAllowedException("Line already returned");

        if (!(line.unit() instanceof CatalogItem item) || !item.isReturnable()) {
            throw new ReturnNotAllowedException("Item is not returnable");
        }

        if (today > placedDay + item.returnWindowDays()) {
            throw new ReturnNotAllowedException("Return window expired");
        }

        line.markReturned();
    }

    public boolean placed() { return placed; }
    public PriceBreakdown finalBreakdown() { return finalBreakdown; }
    public List<OrderLine> lines() { return Collections.unmodifiableList(lines); }
}