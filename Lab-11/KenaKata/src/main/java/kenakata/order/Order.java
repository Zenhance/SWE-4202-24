package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
import kenakata.catalog.Discountable;
import kenakata.catalog.Insurable;
import kenakata.catalog.Money;
import kenakata.catalog.Returnable;
import kenakata.exceptions.CheckoutException;
import kenakata.exceptions.NotInsurableException;
import kenakata.exceptions.OutOfStockException;
import kenakata.exceptions.ReturnNotAllowedException;
import kenakata.payment.PaymentMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {

    private static final long INSURANCE_BASIS_POINTS = 10;
    private static final long INSURANCE_MINIMUM = 20;
    private static final long SERVICE_FEE_BASIS_POINTS = 10;
    private static final long SERVICE_FEE_CAP = 100;

    private final Zone zone;
    private final DeliveryCalculator deliveryCalculator;
    private final List<OrderLine> lines = new ArrayList<>();

    private Coupon coupon;
    private boolean placed;
    private long placedOnDay;
    private PriceBreakdown finalBreakdown;

    public Order(Zone zone, DeliveryCalculator deliveryCalculator) {
        if (zone == null) {
            throw new IllegalArgumentException("zone must not be null");
        }
        if (deliveryCalculator == null) {
            throw new IllegalArgumentException("deliveryCalculator must not be null");
        }
        this.zone = zone;
        this.deliveryCalculator = deliveryCalculator;
    }

    public void addProduct(CatalogItem item, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity must be positive");
        }
        lines.add(new OrderLine(item, quantity));
    }

    public void addAddOn(Chargeable addOn) {
        lines.add(new OrderLine(addOn, 1));
    }

    public void applyCoupon(Coupon coupon) {
        this.coupon = coupon;
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

    public void insure(int lineIndex) throws NotInsurableException {
        OrderLine line = lines.get(lineIndex);
        if (!(line.item() instanceof Insurable)) {
            throw new NotInsurableException("Line " + lineIndex + " (" + line.item().label() + ") cannot be insured");
        }
        line.markInsured();
    }

    public PriceBreakdown quote(long day) throws CouponRejectedException {
        long subtotal = 0;
        long discountableBase = 0;
        long vat = 0;

        for (OrderLine line : lines) {
            subtotal += line.value();
            vat += line.vatTotal();
            if (line.item() instanceof Discountable) {
                discountableBase += line.value();
            }
        }

        long discount = 0;
        if (coupon != null) {
            discount = coupon.apply(discountableBase, subtotal, day);
        }

        long delivery = deliveryCalculator.calculate(zone, lines);

        long insurance = 0;
        for (OrderLine line : lines) {
            if (line.insured()) {
                long fee = Money.ceilPercent(line.value(), INSURANCE_BASIS_POINTS);
                insurance += Math.max(fee, INSURANCE_MINIMUM);
            }
        }

        long serviceFee = Math.min(Money.ceilPercent(subtotal, SERVICE_FEE_BASIS_POINTS), SERVICE_FEE_CAP);

        return new PriceBreakdown(subtotal, discount, vat, delivery, insurance, serviceFee);
    }

    public void place(PaymentMethod payment, long day) throws CheckoutException {
        PriceBreakdown breakdown = quote(day);

        for (OrderLine line : lines) {
            if (line.item() instanceof CatalogItem catalogItem) {
                if (!catalogItem.hasStock(line.quantity())) {
                    throw new OutOfStockException(
                            "Not enough stock of " + catalogItem.sku() + " to reserve " + line.quantity() + " unit(s)");
                }
            }
        }

        payment.authorise(breakdown.grandTotal());

        for (OrderLine line : lines) {
            if (line.item() instanceof CatalogItem catalogItem) {
                catalogItem.reserve(line.quantity());
            }
        }

        this.placed = true;
        this.placedOnDay = day;
        this.finalBreakdown = breakdown;
    }

    public void acceptReturn(int lineIndex, long day) throws ReturnNotAllowedException {
        OrderLine line = lines.get(lineIndex);
        Chargeable item = line.item();

        if (!(item instanceof Returnable returnable)) {
            throw new ReturnNotAllowedException("Line " + lineIndex + " (" + item.label() + ") is not returnable");
        }
        if (line.returned()) {
            throw new ReturnNotAllowedException("Line " + lineIndex + " has already been returned");
        }
        long daysSincePlacement = day - placedOnDay;
        if (daysSincePlacement > returnable.returnWindowDays()) {
            throw new ReturnNotAllowedException("Return window has closed for line " + lineIndex);
        }
        line.markReturned();
    }
}