package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
import kenakata.catalog.Insurable;
import kenakata.catalog.Returnable;
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
            throw new IllegalArgumentException("Product cannot be null");
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
            throw new IllegalArgumentException("Add-on cannot be null");
        }

        lines.add(new OrderLine(addOn, 1));
    }

    public void applyCoupon(Coupon coupon) {

        if (coupon == null) {
            throw new IllegalArgumentException("Coupon cannot be null");
        }

        this.coupon = coupon;
    }

    public void insure(int lineIndex) throws NotInsurableException {

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

    public void place(PaymentMethod payment, int today)
            throws Exception {

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

        PriceBreakdown breakdown = calculateBreakdown(today);
        for (OrderLine line : lines) {

            if (line.isProduct()) {

                CatalogItem item =
                        (CatalogItem) line.item();

                if (item.remaining() < line.quantity()) {
                    throw new OutOfStockException(
                            "Not enough stock for " + item.title()
                    );
                }
            }
        }
        payment.authorise(breakdown.grandTotal());
        for (OrderLine line : lines) {

            if (line.isProduct()) {

                CatalogItem item =
                        (CatalogItem) line.item();

                item.reserve(line.quantity());
            }
        }

        placed = true;
        placedDay = today;
        finalBreakdown = breakdown;

        for (OrderLine line : lines) {
            line.markPlaced(today);
        }
    }

    public void acceptReturn(int lineIndex, int today)
            throws ReturnNotAllowedException {

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

        int window = returnable.returnWindowDays();

        if (today > line.placeDay() + window) {
            throw new ReturnNotAllowedException(
                    "Return window has expired"
            );
        }

        if (today < line.placeDay()) {
            throw new ReturnNotAllowedException(
                    "Invalid return day"
            );
        }

        line.markReturned(today);
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

    private PriceBreakdown calculateBreakdown(int today)
            throws CouponRejectedException {

        long subtotal = 0;
        long vat = 0;
        long insurance = 0;

        long discountableBase = 0;

        for (OrderLine line : lines) {

            Chargeable item = line.item();

            long lineCharge =
                    item.unitCharge() * line.quantity();

            subtotal += lineCharge;
            long unitVat = item.unitVat();

            vat += unitVat * line.quantity();


            if (line.isProduct()
                    && isDiscountable((CatalogItem) item)) {

                discountableBase += lineCharge;
            }

            if (line.insured()
                    && item instanceof Insurable) {

                long value = getInsurableValue(
                        (CatalogItem) item,
                        line.quantity()
                );

                long fee = (long) Math.ceil(value * 0.01);

                insurance += Math.max(20, fee);
            }
        }

        long discount = 0;

        if (coupon != null) {
            discount =
                    coupon.discountFor(
                            discountableBase,
                            today
                    );
        }

        long delivery =
                deliveryCalculator.calculate(lines, zone);

        long serviceFee =
                (long) Math.ceil(subtotal * 0.01);

        serviceFee = Math.min(serviceFee, 100);

        return new PriceBreakdown(subtotal, discount, vat, delivery, insurance, serviceFee);
    }

    private boolean isDiscountable(CatalogItem item) {

        return item instanceof kenakata.catalog.StockedGood;
    }

    private long getInsurableValue(
            CatalogItem item,
            int quantity) {

        return item.unitCharge() * quantity;
    }
}