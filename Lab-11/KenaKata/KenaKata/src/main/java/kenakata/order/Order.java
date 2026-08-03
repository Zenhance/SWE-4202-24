package kenakata.order;

import kenakata.catalog.*;
import kenakata.exceptions.*;
import kenakata.payment.PaymentMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public final class Order {
    private final Zone zone;
    private final DeliveryCalculator deliveryCalculator;
    private final List<OrderLine> lines = new ArrayList<>();
    private Coupon coupon;
    private boolean placed;
    private int placedDay = -1;
    private PriceBreakdown finalBreakdown;

    public Order(Zone zone, DeliveryCalculator deliveryCalculator) {
        if (zone == null || deliveryCalculator == null) {
            throw new IllegalArgumentException("Zone and delivery calculator are required");
        }
        this.zone = zone;
        this.deliveryCalculator = deliveryCalculator;
    }

    public void addProduct(CatalogItem item, int quantity) {
        ensureMutable();
        if (item == null) {
            throw new IllegalArgumentException("Product is required");
        }
        lines.add(new OrderLine(item, quantity));
    }

    public void addAddOn(Chargeable addOn) {
        ensureMutable();
        if (addOn == null) {
            throw new IllegalArgumentException("Add-on is required");
        }
        if (addOn instanceof CatalogItem) {
            throw new IllegalArgumentException("Use addProduct for catalogue items");
        }
        lines.add(new OrderLine(addOn, 1));
    }

    public void applyCoupon(Coupon coupon) {
        ensureMutable();
        if (coupon == null) {
            throw new IllegalArgumentException("Coupon is required");
        }
        this.coupon = coupon;
    }

    public void insure(int lineIndex) throws NotInsurableException {
        ensureMutable();
        OrderLine line = lineAt(lineIndex);
        if (!(line.unit() instanceof Insurable)) {
            throw new NotInsurableException("Line cannot be insured: " + line.label());
        }
        line.markInsured();
    }

    public PriceBreakdown quote(int currentDay) throws CheckoutException {
        if (currentDay < 0) {
            throw new IllegalArgumentException("Day cannot be negative");
        }
        long subtotal = 0;
        long vat = 0;
        long insurance = 0;
        long discountableBase = 0;

        for (OrderLine line : lines) {
            subtotal = Math.addExact(subtotal, line.charge());
            vat = Math.addExact(vat, line.vat());
            insurance = Math.addExact(insurance, line.insuranceFee());
            if (line.unit() instanceof StockedGood) {
                discountableBase = Math.addExact(discountableBase, line.charge());
            }
        }

        long discount = coupon == null ? 0 : coupon.discount(discountableBase, subtotal, currentDay);
        long delivery = deliveryCalculator.calculate(lines, zone);
        long serviceFee = Math.min(100, MoneyMath.ceilRate(subtotal, 1, 100));
        long grandTotal = subtotal;
        grandTotal = Math.subtractExact(grandTotal, discount);
        grandTotal = Math.addExact(grandTotal, delivery);
        grandTotal = Math.addExact(grandTotal, vat);
        grandTotal = Math.addExact(grandTotal, insurance);
        grandTotal = Math.addExact(grandTotal, serviceFee);

        return new PriceBreakdown(subtotal, discount, delivery, vat,
                insurance, serviceFee, grandTotal);
    }

    public void place(PaymentMethod payment, int currentDay) throws CheckoutException {
        ensureMutable();
        if (payment == null) {
            throw new IllegalArgumentException("Payment method is required");
        }

        PriceBreakdown breakdown = quote(currentDay); // coupon validation first
        Map<CatalogItem, Integer> needed = stockRequirements();
        for (Map.Entry<CatalogItem, Integer> entry : needed.entrySet()) {
            if (!entry.getKey().canReserve(entry.getValue())) {
                throw new OutOfStockException("Insufficient stock for " + entry.getKey().sku());
            }
        }

        // Built-in payment methods perform this refusal check without changing balances/limits.
        payment.validate(breakdown.grandTotal());

        for (Map.Entry<CatalogItem, Integer> entry : needed.entrySet()) {
            entry.getKey().reserve(entry.getValue());
        }
        payment.authorise(breakdown.grandTotal());

        placed = true;
        placedDay = currentDay;
        finalBreakdown = breakdown;
    }

    private Map<CatalogItem, Integer> stockRequirements() {
        Map<CatalogItem, Integer> needed = new IdentityHashMap<>();
        for (OrderLine line : lines) {
            CatalogItem item = line.item();
            if (item != null) {
                needed.merge(item, line.quantity(), Math::addExact);
            }
        }
        return needed;
    }

    public void acceptReturn(int lineIndex, int currentDay) throws ReturnNotAllowedException {
        if (!placed) {
            throw new ReturnNotAllowedException("Only placed orders can accept returns");
        }
        if (currentDay < 0) {
            throw new IllegalArgumentException("Day cannot be negative");
        }
        OrderLine line = lineAt(lineIndex);
        if (line.returned()) {
            throw new ReturnNotAllowedException("Line was already returned");
        }
        if (!(line.unit() instanceof Returnable returnable)) {
            throw new ReturnNotAllowedException("Line is not returnable");
        }
        if (currentDay > placedDay + returnable.returnWindowDays()) {
            throw new ReturnNotAllowedException("Return window has expired");
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

    public List<OrderLine> lines() {
        return Collections.unmodifiableList(lines);
    }

    public Zone zone() {
        return zone;
    }

    private OrderLine lineAt(int index) {
        if (index < 0 || index >= lines.size()) {
            throw new IllegalArgumentException("Invalid line index: " + index);
        }
        return lines.get(index);
    }

    private void ensureMutable() {
        if (placed) {
            throw new IllegalStateException("A placed order cannot be changed");
        }
    }
}
