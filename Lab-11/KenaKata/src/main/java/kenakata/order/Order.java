package kenakata.order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import kenakata.catalog.*;
import kenakata.exceptions.CheckoutException;
import kenakata.exceptions.NotInsurableException;
import kenakata.exceptions.ReturnNotAllowedException;
import kenakata.payment.CardPayment;
import kenakata.payment.PaymentMethod;

public final class Order {

    private final Zone zone;
    private final DeliveryCalculator deliveryCalculator;
    private final List<OrderLine> lines;

    private Coupon coupon;
    private boolean placed;
    private int placedDay;
    private PriceBreakdown finalBreakdown;

    public Order(
            Zone zone,
            DeliveryCalculator deliveryCalculator
    ) {
        if (zone == null || deliveryCalculator == null) {
            throw new IllegalArgumentException(
                    "Zone and delivery calculator cannot be null"
            );
        }

        this.zone = zone;
        this.deliveryCalculator = deliveryCalculator;
        this.lines = new ArrayList<>();
        this.placedDay = -1;
    }

    public Order(Object dhaka, DeliveryCalculator deliveryCalculator) {

        this.deliveryCalculator = new DeliveryCalculator();
        lines = List.of();
        zone = null;
    }

    public void addProduct(
            CatalogItem item,
            int quantity
    ) {
        ensureEditable();

        if (item == null) {
            throw new IllegalArgumentException(
                    "Product cannot be null"
            );
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "Quantity must be positive"
            );
        }

        lines.add(new OrderLine(item, quantity));
    }

    public void addAddOn(Chargeable addOn) {
        ensureEditable();

        if (addOn == null) {
            throw new IllegalArgumentException(
                    "Add-on cannot be null"
            );
        }

        if (addOn instanceof CatalogItem) {
            throw new IllegalArgumentException(
                    "Catalogue products must be added with addProduct"
            );
        }

        lines.add(new OrderLine(addOn, 1));
    }

    public void applyCoupon(Coupon coupon) {
        ensureEditable();

        if (coupon == null) {
            throw new IllegalArgumentException(
                    "Coupon cannot be null"
            );
        }

        this.coupon = coupon;
    }

    public void insure(int lineIndex)
            throws NotInsurableException {

        ensureEditable();

        OrderLine line = lineAt(lineIndex);

        if (!(line.unit() instanceof Insurable)) {
            throw new NotInsurableException(
                    line.label() + " cannot be insured"
            );
        }

        line.markInsured();
    }

    public PriceBreakdown quote(int currentDay)
            throws CheckoutException {

        if (currentDay < 0) {
            throw new IllegalArgumentException(
                    "Current day cannot be negative"
            );
        }

        return calculateBreakdown(currentDay);
    }

    /**
     * Checks the coupon, complete stock requirements, and payment
     * before recording the order as successfully placed.
     */
    public void place(
            PaymentMethod payment,
            int currentDay
    ) throws CheckoutException {

        ensureEditable();

        if (payment == null) {
            throw new IllegalArgumentException(
                    "Payment method cannot be null"
            );
        }

        /*
         * Coupon validation and complete pricing happen before
         * stock or money changes.
         */
        PriceBreakdown breakdown =
                calculateBreakdown(currentDay);

        /*
         * Quantities are combined by product identity so adding the
         * same product through multiple lines cannot bypass the
         * stock check.
         */
        Map<CatalogItem, Integer> requestedStock =
                requestedStock();

        for (Map.Entry<CatalogItem, Integer> entry
                : requestedStock.entrySet()) {

            entry.getKey().ensureAvailable(
                    entry.getValue()
            );
        }

        /*
         * Payment implementations throw before modifying their
         * balances or limits when authorisation is refused.
         */
        payment.authorise(
                breakdown.grandTotal()
        );

        /*
         * Every quantity was already validated, so all reservations
         * now succeed in this single-threaded marketplace engine.
         */
        for (Map.Entry<CatalogItem, Integer> entry
                : requestedStock.entrySet()) {

            entry.getKey().reserve(
                    entry.getValue()
            );
        }

        placed = true;
        placedDay = currentDay;
        finalBreakdown = breakdown;
    }

    public void acceptReturn(
            int lineIndex,
            int currentDay
    ) throws ReturnNotAllowedException {

        if (!placed) {
            throw new ReturnNotAllowedException(
                    "An unplaced order cannot accept returns"
            );
        }

        if (currentDay < 0) {
            throw new IllegalArgumentException(
                    "Current day cannot be negative"
            );
        }

        OrderLine line = lineAt(lineIndex);

        if (line.returned()) {
            throw new ReturnNotAllowedException(
                    "This line has already been returned"
            );
        }

        if (!(line.unit() instanceof Returnable returnable)) {
            throw new ReturnNotAllowedException(
                    line.label() + " is not returnable"
            );
        }

        int lastReturnDay =
                placedDay + returnable.returnWindowDays();

        if (currentDay < placedDay
                || currentDay > lastReturnDay) {

            throw new ReturnNotAllowedException(
                    "The return window has closed"
            );
        }

        line.markReturned();
    }

    public boolean placed() {
        return placed;
    }

    public int placedDay() {
        return placedDay;
    }

    public PriceBreakdown finalBreakdown() {
        return finalBreakdown;
    }

    public Zone zone() {
        return zone;
    }

    public List<OrderLine> lines() {
        return Collections.unmodifiableList(lines);
    }

    private PriceBreakdown calculateBreakdown(
            int currentDay
    ) throws CheckoutException {

        long subtotal = 0;
        long discountableBase = 0;
        long vat = 0;
        long insurance = 0;

        for (OrderLine line : lines) {
            long lineCharge = line.charge();

            subtotal = Math.addExact(
                    subtotal,
                    lineCharge
            );

            vat = Math.addExact(
                    vat,
                    line.vat()
            );

            if (line.unit() instanceof Discountable) {
                discountableBase = Math.addExact(
                        discountableBase,
                        lineCharge
                );
            }

            if (line.insured()) {
                Insurable insurable =
                        (Insurable) line.unit();

                long insurableValue =
                        insurable.insurableValue(
                                line.quantity()
                        );

                long percentageFee = ceilFraction(
                        insurableValue,
                        1,
                        100
                );

                long lineInsurance =
                        Math.max(20, percentageFee);

                insurance = Math.addExact(
                        insurance,
                        lineInsurance
                );
            }
        }

        long discount;

        if (coupon == null) {
            discount = 0;
        } else {
            discount = coupon.discountFor(
                    discountableBase,
                    currentDay
            );
        }

        long delivery = deliveryCalculator.calculate(
                lines,
                zone
        );

        long serviceFee = Math.min(
                100,
                ceilFraction(subtotal, 1, 100)
        );

        long grandTotal = subtotal;

        grandTotal = Math.subtractExact(
                grandTotal,
                discount
        );

        grandTotal = Math.addExact(
                grandTotal,
                delivery
        );

        grandTotal = Math.addExact(
                grandTotal,
                vat
        );

        grandTotal = Math.addExact(
                grandTotal,
                insurance
        );

        grandTotal = Math.addExact(
                grandTotal,
                serviceFee
        );

        return new PriceBreakdown(
                subtotal,
                discount,
                delivery,
                vat,
                insurance,
                serviceFee,
                grandTotal
        );
    }

    private Map<CatalogItem, Integer> requestedStock() {
        Map<CatalogItem, Integer> requested =
                new IdentityHashMap<>();

        for (OrderLine line : lines) {
            if (line.unit() instanceof CatalogItem item) {
                requested.merge(
                        item,
                        line.quantity(),
                        Math::addExact
                );
            }
        }

        return requested;
    }

    private OrderLine lineAt(int lineIndex) {
        if (lineIndex < 0 || lineIndex >= lines.size()) {
            throw new IndexOutOfBoundsException(
                    "No order line at index " + lineIndex
            );
        }

        return lines.get(lineIndex);
    }

    private void ensureEditable() {
        if (placed) {
            throw new IllegalStateException(
                    "A placed order cannot be modified or placed again"
            );
        }
    }

    private static long ceilFraction(
            long amount,
            long numerator,
            long denominator
    ) {
        if (amount == 0 || numerator == 0) {
            return 0;
        }

        long multiplied = Math.multiplyExact(
                amount,
                numerator
        );

        long adjusted = Math.addExact(
                multiplied,
                denominator - 1
        );

        return adjusted / denominator;
    }

    public void addProduct(StockedGood stockedGood, int quantity) {
    }

    public void place(CardPayment cardPayment, int currentDay) {
    }

    public void addAddOn(GiftWrap giftWrap) {
    }

    public void addProduct(DigitalGood p2, int i) {
    }
}