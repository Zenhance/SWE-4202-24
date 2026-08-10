package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
import kenakata.catalog.ColdChain;
import kenakata.catalog.Insurable;
import kenakata.catalog.Returnable;
import kenakata.catalog.Weighable;
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

    private Coupon coupon;
    private boolean placed;
    private PriceBreakdown finalBreakdown;
    private int placedDay = -1;

    public Order(Zone zone, DeliveryCalculator deliveryCalculator) {

        if (zone == null) {
            throw new IllegalArgumentException("Zone cannot be null");
        }

        if (deliveryCalculator == null) {
            throw new IllegalArgumentException(
                    "Delivery calculator cannot be null"
            );
        }

        this.zone = zone;
        this.deliveryCalculator = deliveryCalculator;
    }

    public void addProduct(CatalogItem item, int quantity) {

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

        if (addOn == null) {
            throw new IllegalArgumentException(
                    "Add-on cannot be null"
            );
        }

        lines.add(new OrderLine(addOn, 1));
    }

    public void applyCoupon(Coupon coupon) {

        if (coupon == null) {
            throw new IllegalArgumentException(
                    "Coupon cannot be null"
            );
        }

        this.coupon = coupon;
    }

    public void insure(int lineIndex)
            throws NotInsurableException {

        OrderLine line = getLine(lineIndex);

        if (!(line.item() instanceof Insurable)) {
            throw new NotInsurableException(
                    "This line cannot be insured"
            );
        }

        line.insure();
    }

    public PriceBreakdown quote(int today)
            throws CouponRejectedException {

        return calculateBreakdown(today);
    }

    public void place(
            PaymentMethod payment,
            int today
    ) throws CheckoutException {

        if (payment == null) {
            throw new IllegalArgumentException(
                    "Payment method cannot be null"
            );
        }

        if (placed) {
            throw new IllegalStateException(
                    "Order has already been placed"
            );
        }

        // First calculate everything.
        // If coupon is invalid, nothing happens.
        PriceBreakdown breakdown =
                calculateBreakdown(today);

        // Check stock BEFORE payment.
        for (OrderLine line : lines) {

            if (line.isProduct()) {

                CatalogItem item =
                        line.catalogItem();

                if (item.remaining() < line.quantity()) {

                    throw new OutOfStockException(
                            "Not enough stock for "
                                    + item.title()
                    );
                }
            }
        }

        // Payment happens only after all stock checks pass.
        payment.authorise(
                breakdown.grandTotal()
        );
        // Reserve stock only after successful payment.
        for (OrderLine line : lines) {
            if (line.isProduct()) {

                line.catalogItem().reserve(
                        line.quantity()
                );
            }
        }
        placed = true;
        placedDay = today;
        finalBreakdown = breakdown;
        for (OrderLine line : lines) {
            line.setPlacedDay(today);
        }
    }
    public void acceptReturn(
            int lineIndex,
            int today
    ) throws ReturnNotAllowedException {
        if (!placed) {
            throw new ReturnNotAllowedException(
                    "Order has not been placed"
            );
        }
        OrderLine line = getLine(lineIndex);
        if (!(line.item() instanceof Returnable returnable)) {
            throw new ReturnNotAllowedException(
                    "This line is not returnable"
            );
        }
        if (line.returned()) {
            throw new ReturnNotAllowedException(
                    "This line has already been returned"
            );
        }
        if (today < line.placedDay()) {
            throw new ReturnNotAllowedException(
                    "Invalid return day"
            );
        }

        if (today >
                line.placedDay()
                        + returnable.returnWindowDays()) {

            throw new ReturnNotAllowedException(
                    "Return window has expired"
            );
        }

        line.markReturned();
        line.setReturnedDay(today);
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

    public int placedDay() {
        return placedDay;
    }

    public Zone zone() {
        return zone;
    }

    public Coupon coupon() {
        return coupon;
    }

    private OrderLine getLine(int index) {

        if (index < 0 || index >= lines.size()) {

            throw new IllegalArgumentException(
                    "Invalid line index"
            );
        }

        return lines.get(index);
    }

    private PriceBreakdown calculateBreakdown(
            int today
    ) throws CouponRejectedException {

        long subtotal = 0;
        long vat = 0;
        long insurance = 0;

        long discountableBase = 0;

        long totalWeightGrams = 0;
        int freshLineCount = 0;

        for (OrderLine line : lines) {

            Chargeable item = line.item();

            long lineCharge = line.charge();

            subtotal += lineCharge;

            vat += line.vat();

            // Only StockedGood is discountable.
            if (line.isProduct()) {

                CatalogItem catalogItem =
                        line.catalogItem();

                if (isDiscountable(catalogItem)) {

                    discountableBase += lineCharge;
                }

                // Calculate total weight.
                if (catalogItem instanceof Weighable weighable) {

                    totalWeightGrams +=
                            weighable.weightGrams()
                                    * line.quantity();
                }

                // Each fresh line adds one cold-chain surcharge.
                if (catalogItem instanceof ColdChain) {

                    freshLineCount++;
                }

                // Insurance.
                if (line.insured()) {

                    Insurable insurable =
                            (Insurable) catalogItem;

                    long value =
                            insurable.insurableValue(
                                    line.quantity()
                            );

                    long fee =
                            (long) Math.ceil(
                                    value * 0.01
                            );

                    insurance +=
                            Math.max(20, fee);
                }
            }
        }

        long discount = 0;

        if (coupon != null) {

            discount =
                    coupon.discount(
                            discountableBase,
                            today
                    );
        }
        long delivery =
                deliveryCalculator.calculate(
                        zone,
                        totalWeightGrams,
                        freshLineCount
                );
        long serviceFee =
                (long) Math.ceil(
                        subtotal * 0.01
                );
        serviceFee =
                Math.min(serviceFee, 100);
        long grandTotal = subtotal - discount + delivery + vat + insurance + serviceFee;
        return new PriceBreakdown(subtotal, discount, delivery, vat, insurance, serviceFee, grandTotal);
    }
    private boolean isDiscountable(
            CatalogItem item
    ) {
        return item instanceof kenakata.catalog.StockedGood;
    }
}