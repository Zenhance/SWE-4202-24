package kenakata.order;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import kenakata.catalog.*;
import kenakata.exceptions.*;
import kenakata.payment.PaymentMethod;

public final class Order {

    private final Zone zone;
    private final DeliveryCalculator delivery;
    private final List<OrderLine> lines = new ArrayList<>();

    private Coupon coupon;
    private boolean placed;
    private int placedDay = -1;
    private PriceBreakdown finalBreakdown;

    public Order(Zone zone, DeliveryCalculator delivery) {
        if (zone == null || delivery == null)
            throw new IllegalArgumentException("Null order information");

        this.zone = zone;
        this.delivery = delivery;
    }

    public void addProduct(CatalogItem item, int quantity) {
        editable();

        if (item == null || quantity <= 0)
            throw new IllegalArgumentException("Invalid product or quantity");

        lines.add(new OrderLine(item, quantity));
    }

    public void addAddOn(Chargeable addOn) {
        editable();

        if (addOn == null)
            throw new IllegalArgumentException("Add-on cannot be null");

        lines.add(new OrderLine(addOn, 1));
    }

    public void applyCoupon(Coupon coupon) {
        editable();

        if (coupon == null)
            throw new IllegalArgumentException("Coupon cannot be null");

        this.coupon = coupon;
    }

    public void insure(int index) throws NotInsurableException {
        editable();

        OrderLine line = lines.get(index);

        if (!(line.unit() instanceof Insurable))
            throw new NotInsurableException("Line cannot be insured");

        line.markInsured();
    }

    public PriceBreakdown quote(int day) throws CheckoutException {
        return calculate(day);
    }

    public void place(PaymentMethod payment, int day)
            throws CheckoutException {

        editable();

        if (payment == null)
            throw new IllegalArgumentException("Payment cannot be null");

        PriceBreakdown breakdown = calculate(day);

        Map<CatalogItem, Integer> required = new IdentityHashMap<>();

        for (OrderLine line : lines) {
            if (line.unit() instanceof CatalogItem item) {
                required.merge(item, line.quantity(), (a, b) -> Math.addExact(a, b)
                );
            }
        }
        for (Map.Entry<CatalogItem, Integer> entry : required.entrySet())
            entry.getKey().ensureAvailable(entry.getValue());

        payment.authorise(breakdown.grandTotal());
        for (Map.Entry<CatalogItem, Integer> entry : required.entrySet())
            entry.getKey().reserve(entry.getValue());

        finalBreakdown = breakdown;
        placedDay = day;
        placed = true;
    }

    public void acceptReturn(int index, int day)
            throws ReturnNotAllowedException {

        if (!placed)
            throw new ReturnNotAllowedException("Order is not placed");

        OrderLine line = lines.get(index);

        if (line.returned())
            throw new ReturnNotAllowedException("Already returned");

        if (!(line.unit() instanceof Returnable returnable))
            throw new ReturnNotAllowedException("Line is not returnable");

        if (day < placedDay ||
                day > placedDay + returnable.returnWindowDays()) {

            throw new ReturnNotAllowedException(
                    "Return window has ended"
            );
        }

        line.markReturned();
    }

    private PriceBreakdown calculate(int day)
            throws CheckoutException {

        if (day < 0)
            throw new IllegalArgumentException("Day cannot be negative");

        long subtotal = 0;
        long discountable = 0;
        long vat = 0;
        long insurance = 0;

        for (OrderLine line : lines) {
            subtotal += line.charge();
            vat += line.vat();

            if (line.unit() instanceof Discountable)
                discountable += line.charge();

            if (line.insured()) {
                Insurable item = (Insurable) line.unit();

                long value = item.insurableValue(line.quantity());
                insurance += Math.max(20, percent(value, 1));
            }
        }

        long discount = coupon == null ? 0 : coupon.discountFor(discountable, placedDay);

        long deliveryFee = delivery.calculate(lines, zone);
        long serviceFee = Math.min(100, percent(subtotal, 1));

        long total = subtotal - discount + deliveryFee + vat + insurance + serviceFee;

        return new PriceBreakdown(subtotal, discount, deliveryFee, vat, insurance, serviceFee, total
        );
    }

    private static long percent(long amount, int discount) {
        return (amount * discount + 99) / 100;
    }

    private void editable() {
        if (placed)
            throw new IllegalStateException(
                    "Placed order cannot be modified"
            );
    }

    public List<OrderLine> lines() {
        return List.copyOf(lines);
    }

    public boolean placed() {
        return placed;
    }

    public PriceBreakdown finalBreakdown() {
        return finalBreakdown;
    }

    public Zone zone() {
        return zone;
    }

    public int placedDay() {
        return placedDay;
    }

    public Coupon coupon() {
        return coupon;
    }
}