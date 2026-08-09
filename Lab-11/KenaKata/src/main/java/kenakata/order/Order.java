package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.ColdChain;
import kenakata.catalog.Insurable;
import kenakata.catalog.Returnable;
import kenakata.catalog.Weighted;
import kenakata.exceptions.CheckoutException;
import kenakata.exceptions.NotInsurableException;
import kenakata.exceptions.OutOfStockException;
import kenakata.exceptions.ReturnNotAllowedException;
import kenakata.payment.PaymentMethod;

import java.util.ArrayList;
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
        if (zone == null || deliveryCalculator == null) {
            throw new IllegalArgumentException();
        }

        this.zone = zone;
        this.deliveryCalculator = deliveryCalculator;
    }

    public void addProduct(CatalogItem item, int quantity) {
        if (item == null || quantity <= 0) {
            throw new IllegalArgumentException();
        }

        if (placed) {
            throw new IllegalStateException("Order already placed");
        }

        lines.add(new OrderLine(item, quantity));
    }

    public void addAddOn(Chargeable addOn) {
        if (addOn == null) {
            throw new IllegalArgumentException();
        }

        if (placed) {
            throw new IllegalStateException("Order already placed");
        }

        lines.add(new OrderLine(addOn, 1));
    }

    public void applyCoupon(Coupon coupon) {
        if (coupon == null) {
            throw new IllegalArgumentException();
        }

        if (placed) {
            throw new IllegalStateException("Order already placed");
        }

        this.coupon = coupon;
    }

    public void insure(int lineIndex) throws NotInsurableException {
        if (lineIndex < 0 || lineIndex >= lines.size()) {
            throw new IllegalArgumentException();
        }

        OrderLine line = lines.get(lineIndex);

        if (!(line.chargeable() instanceof Insurable)) {
            throw new NotInsurableException();
        }

        line.insure();
    }

    public PriceBreakdown quote(int day) throws CheckoutException {
        return calculate(day);
    }

    public void place(PaymentMethod payment, int day)
            throws CheckoutException {

        if (payment == null) {
            throw new IllegalArgumentException();
        }

        if (placed) {
            throw new IllegalStateException("Order already placed");
        }

        PriceBreakdown breakdown = calculate(day);

        for (OrderLine line : lines) {
            if (line.chargeable() instanceof CatalogItem item) {
                if (line.quantity() > item.remaining()) {
                    throw new OutOfStockException();
                }
            }
        }

        payment.authorise(breakdown.grandTotal());

        for (OrderLine line : lines) {
            if (line.chargeable() instanceof CatalogItem item) {
                item.reserve(line.quantity());
            }
        }

        placed = true;
        placedDay = day;
        finalBreakdown = breakdown;
    }

    public void acceptReturn(int lineIndex, int day)
            throws ReturnNotAllowedException {

        if (lineIndex < 0 || lineIndex >= lines.size()) {
            throw new IllegalArgumentException();
        }

        if (!placed) {
            throw new ReturnNotAllowedException();
        }

        OrderLine line = lines.get(lineIndex);

        if (line.returned()) {
            throw new ReturnNotAllowedException();
        }

        if (!(line.chargeable() instanceof Returnable returnable)) {
            throw new ReturnNotAllowedException();
        }

        int window = returnable.returnWindow();

        if (day < placedDay || day > placedDay + window) {
            throw new ReturnNotAllowedException();
        }

        line.markReturned();
    }

    private PriceBreakdown calculate(int day)
            throws CheckoutException {

        long subtotal = 0;
        long discountableBase = 0;
        long vat = 0;
        long insurance = 0;

        for (OrderLine line : lines) {

            long lineCharge = line.lineCharge();

            subtotal += lineCharge;

            if (line.chargeable() instanceof CatalogItem item) {
                if (isDiscountable(item)) {
                    discountableBase += lineCharge;
                }
            }

            vat += line.chargeable().unitVat() * line.quantity();

            if (line.insured()) {

                if (!(line.chargeable() instanceof Insurable)) {
                    throw new NotInsurableException();
                }

                long value = line.insurableValue();
                long fee = ceilPercent(value, 1, 100);

                if (fee < 20) {
                    fee = 20;
                }

                insurance += fee;
            }
        }

        long discount = 0;

        if (coupon != null) {
            discount = coupon.discount(discountableBase, day);
        }

        long delivery = calculateDelivery();

        long serviceFee = ceilPercent(subtotal, 1, 100);

        if (serviceFee > 100) {
            serviceFee = 100;
        }

        long grandTotal =
                subtotal
                        - discount
                        + delivery
                        + vat
                        + insurance
                        + serviceFee;

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

    private boolean isDiscountable(CatalogItem item) {
        return item.getClass().getSimpleName().equals("StockedGood");
    }

    private long calculateDelivery() {

        long totalWeight = 0;
        int freshLines = 0;
        boolean hasWeighableLine = false;

        for (OrderLine line : lines) {

            if (line.chargeable() instanceof Weighted weighted) {
                hasWeighableLine = true;
                totalWeight += weighted.weightGrams() * line.quantity();
            }

            if (line.chargeable() instanceof ColdChain) {
                freshLines++;
            }
        }

        if (!hasWeighableLine) {
            return 0;
        }

        long billedKg = (totalWeight + 999) / 1000;

        long shipping;

        if (zone == Zone.DHAKA) {
            shipping = 60 + billedKg * 20;
        } else {
            shipping = 120 + billedKg * 35;
        }

        long coldChain = freshLines * 50;

        return shipping + coldChain;
    }

    private static long ceilPercent(
            long amount,
            long numerator,
            long denominator) {

        return (amount * numerator + denominator - 1)
                / denominator;
    }

    public boolean placed() {
        return placed;
    }

    public PriceBreakdown finalBreakdown() {
        return finalBreakdown;
    }

    public List<OrderLine> lines() {
        return List.copyOf(lines);
    }

    public Zone zone() {
        return zone;
    }

    public static class OrderLine {

        private final Chargeable chargeable;
        private final int quantity;

        private boolean insured;
        private boolean returned;

        public OrderLine(Chargeable chargeable, int quantity) {

            if (chargeable == null || quantity <= 0) {
                throw new IllegalArgumentException();
            }

            this.chargeable = chargeable;
            this.quantity = quantity;
        }

        public Chargeable chargeable() {
            return chargeable;
        }

        public int quantity() {
            return quantity;
        }

        public long lineCharge() {
            return chargeable.unitCharge() * quantity;
        }

        public boolean insured() {
            return insured;
        }

        public void insure() {
            insured = true;
        }

        public boolean returned() {
            return returned;
        }

        public void markReturned() {
            returned = true;
        }

        public long insurableValue() {

            if (chargeable instanceof Insurable insurable) {
                return insurable.insurableValue(quantity);
            }

            throw new IllegalArgumentException();
        }
    }
}