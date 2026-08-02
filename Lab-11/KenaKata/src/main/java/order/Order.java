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

/**
 * A customer's basket. Every line -- product or add-on -- is held as a {@link OrderLine} wrapping
 * a {@link Chargeable}, so pricing never has to ask what kind of line it is looking at. An order
 * can be quoted freely (committing nothing), placed exactly once (atomically reserving stock and
 * taking payment), and afterwards have individual lines returned.
 */
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

    /** Adds a product line for {@code quantity} units of {@code item}. */
    public void addProduct(CatalogItem item, int quantity) {
        lines.add(new OrderLine(item, quantity));
    }

    /** Adds a non-product add-on as its own line. */
    public void addAddOn(Chargeable addOn) {
        lines.add(new OrderLine(addOn, 1));
    }

    /** Applies a coupon to the order; it is only validated when the order is next priced. */
    public void applyCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    /** Marks the line at {@code lineIndex} to be insured, refusing if it cannot be. */
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

    /** Produces a full price breakdown as of {@code today}, committing nothing. */
    public PriceBreakdown quote(int today) throws CouponRejectedException {
        return priceOrder(today);
    }

    /**
     * Places the order: reserves every product line's stock and takes payment atomically.
     * Every reason the order could be refused -- an invalid coupon, insufficient stock on any
     * line, a declined payment -- is checked before any stock is reserved or any money moves, so
     * a refusal leaves stock counts and balances exactly as they were.
     */
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

    /** Accepts the return of the line at {@code lineIndex}, if it is returnable and in-window. */
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

    // ---- Pricing -------------------------------------------------------------------------

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
