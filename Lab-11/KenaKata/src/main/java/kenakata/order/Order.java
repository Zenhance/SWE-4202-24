package kenakata.order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
import kenakata.catalog.Insurable;
import kenakata.catalog.Returnable;
import kenakata.catalog.StockedGood;
import kenakata.exceptions.CouponRejectedException;
import kenakata.exceptions.NotInsurableException;
import kenakata.exceptions.OutOfStockException;
import kenakata.exceptions.PaymentDeclinedException;
import kenakata.exceptions.ReturnNotAllowedException;
import kenakata.payment.PaymentMethod;
import kenakata.util.Money;


public final class Order {

    private static final long SERVICE_FEE_PERMILLE = 10;  // 1%
    private static final long SERVICE_FEE_CAP = 100;
    private static final long INSURANCE_PERMILLE = 10;    // 1%
    private static final long INSURANCE_MINIMUM = 20;

    private final Zone zone;
    private final DeliveryCalculator deliveryCalculator;
    private final List<OrderLine> lines = new ArrayList<>();

    private Coupon coupon;
    private boolean placed;
    private int placementDay;
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
        lines.add(new OrderLine(item, quantity));
    }

    public void addAddOn(Chargeable addOn) {
        lines.add(new OrderLine(addOn, 1));
    }

    public void applyCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public void insure(int lineIndex) throws NotInsurableException {
        OrderLine line = lines.get(lineIndex);
        if (!(line.chargeable() instanceof Insurable)) {
            throw new NotInsurableException(
                    "line " + lineIndex + " (" + line.chargeable().label() + ") is not insurable");
        }
        line.markInsured();
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

    public PriceBreakdown quote(int today) throws CouponRejectedException {
        return priceOrder(today);
    }


    public void place(PaymentMethod payment, int today)
            throws CouponRejectedException, OutOfStockException, PaymentDeclinedException {
        PriceBreakdown breakdown = priceOrder(today);

        for (OrderLine line : lines) {
            if (line.chargeable() instanceof CatalogItem item && line.quantity() > item.remaining()) {
                throw new OutOfStockException(
                        "only " + item.remaining() + " of " + item.sku()
                                + " remain, cannot reserve " + line.quantity());
            }
        }

        payment.authorise(breakdown.grandTotal());

        for (OrderLine line : lines) {
            if (line.chargeable() instanceof CatalogItem item) {
                item.reserve(line.quantity());
            }
        }

        this.placementDay = today;
        this.finalBreakdown = breakdown;
        this.placed = true;
    }

    public void acceptReturn(int lineIndex, int today) throws ReturnNotAllowedException {
        OrderLine line = lines.get(lineIndex);
        if (line.returned()) {
            throw new ReturnNotAllowedException("line " + lineIndex + " was already returned");
        }
        if (!(line.chargeable() instanceof Returnable returnable)) {
            throw new ReturnNotAllowedException(
                    "line " + lineIndex + " (" + line.chargeable().label() + ") is not returnable");
        }
        if (today > placementDay + returnable.returnWindowDays()) {
            throw new ReturnNotAllowedException(
                    "line " + lineIndex + " is past its return window");
        }
        line.markReturned();
    }


    private PriceBreakdown priceOrder(int today) throws CouponRejectedException {
        long subtotal = 0;
        long discountableBase = 0;
        long vat = 0;
        long insurance = 0;

        for (OrderLine line : lines) {
            subtotal += line.lineCharge();
            vat += line.lineVat();
            if (line.chargeable() instanceof StockedGood) {
                discountableBase += line.lineCharge();
            }
            if (line.insured()) {
                long insurableValue = line.lineCharge();
                long fee = Money.ceilPermille(insurableValue, INSURANCE_PERMILLE);
                insurance += Math.max(fee, INSURANCE_MINIMUM);
            }
        }

        long discount = coupon == null ? 0 : coupon.discountFor(discountableBase, today);
        long delivery = deliveryCalculator.calculate(lines, zone);
        long serviceFee = Math.min(Money.ceilPermille(subtotal, SERVICE_FEE_PERMILLE), SERVICE_FEE_CAP);

        return new PriceBreakdown(subtotal, discount, delivery, vat, insurance, serviceFee,
                Collections.unmodifiableList(new ArrayList<>(lines)));
    }
}
