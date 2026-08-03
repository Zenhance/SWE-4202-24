package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
import kenakata.catalog.StockedGood;
import kenakata.exceptions.CheckoutException;
import kenakata.exceptions.CouponRejectedException;
import kenakata.exceptions.NotInsurableException;
import kenakata.exceptions.OutOfStockException;
import kenakata.payment.PaymentMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public final class Order {

    private static final double SERVICE_FEE_RATE = 1.0;
    private static final long SERVICE_FEE_CAP = 100;
    private static final double INSURANCE_RATE = 1.0;
    private static final long INSURANCE_MINIMUM = 20;

    private final Zone zone;
    private final DeliveryCalculator deliveryCalculator;
    private final List<OrderLine> lines = new ArrayList<>();

    private Coupon coupon;
    private boolean placed;
    private long placedDay;
    private PriceBreakdown finalBreakdown;

    public Order(Zone zone, DeliveryCalculator deliveryCalculator) {
        this.zone = zone;
        this.deliveryCalculator = deliveryCalculator;
    }

    public void addProduct(CatalogItem item, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        lines.add(new OrderLine(item, quantity));
    }

    public void addAddOn(Chargeable addOn) {
        lines.add(new OrderLine(addOn, 1));
    }

    public void applyCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public void insure(int lineIndex) throws NotInsurableException {
        lines.get(lineIndex).insure();
    }

    public List<OrderLine> lines() {
        return Collections.unmodifiableList(lines);
    }

    public boolean placed() {
        return placed;
    }

    public PriceBreakdown finalBreakdown() {
        return finalBreakdown;
    }

    /** Produces a full price breakdown, committing nothing. */
    public PriceBreakdown quote(long day) throws CouponRejectedException {
        long subtotal = 0;
        long discountableBase = 0;
        long vat = 0;
        long insurance = 0;

        for (OrderLine line : lines) {
            subtotal += line.charge();
            vat += line.vat();
            if (line.content() instanceof StockedGood) {
                discountableBase += line.charge();
            }
            if (line.insured()) {
                long value = line.charge();
                insurance += (long) Math.max(Math.ceil(value*INSURANCE_RATE), INSURANCE_MINIMUM);
            }
        }

        long discount = coupon == null ? 0 : coupon.discountFor(subtotal, discountableBase, day);
        long delivery = deliveryCalculator.calculate(zone, lines);
        long serviceFee = Math.min((long)Math.ceil(subtotal*SERVICE_FEE_RATE), SERVICE_FEE_CAP);
        long grandTotal = subtotal - discount + delivery + vat + insurance + serviceFee;

        return new PriceBreakdown(subtotal, discount, delivery, vat, insurance, serviceFee, grandTotal);
    }

    /**
     * Places the order: reserves stock and takes payment atomically. Every reason the
     * order could be refused -- invalid coupon, insufficient stock on any line, declined
     * payment -- is checked before any stock is reserved or any money moves, so a refusal
     * leaves every stock count and balance exactly as it was.
     */
    public void place(PaymentMethod payment, long day) throws CheckoutException {
        PriceBreakdown breakdown = quote(day); // validates the coupon; throws before anything moves

        for (OrderLine line : lines) {
            if (line.isProduct() && line.quantity() > line.asItem().remaining()) {
                throw new OutOfStockException(
                        line.asItem().title() + ": insufficient stock for this order");
            }
        }

        payment.authorise(breakdown.grandTotal()); // moves money; nothing reserved yet

        for (OrderLine line : lines) {
            if (line.isProduct()) {
                line.asItem().reserve(line.quantity());
            }
        }

        this.placed = true;
        this.placedDay = day;
        this.finalBreakdown = breakdown;
    }

    /** Accepts a return of the line at {@code lineIndex}, refusing if it cannot be
     * returned, has already been returned, or is past its window. */
    public void acceptReturn(int lineIndex, long returnDay) throws Throwable {
        lines.get(lineIndex).markReturned(placedDay, returnDay);
    }
}
