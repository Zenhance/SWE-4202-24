package kenakata.order;

import java.util.ArrayList;
import java.util.List;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
import kenakata.catalog.Discountable;
import kenakata.catalog.Insurable;
import kenakata.catalog.MoneyMath;
import kenakata.catalog.Returnable;
import kenakata.exceptions.CheckoutException;
import kenakata.exceptions.NotInsurableException;
import kenakata.exceptions.OutOfStockException;
import kenakata.exceptions.PaymentDeclinedException;
import kenakata.exceptions.ReturnNotAllowedException;
import kenakata.payment.PaymentMethod;

public final class Order {

    private static final double SERVICE_FEE_PERCENT = 1;
    private static final long SERVICE_FEE_CAP = 100;
    private static final double INSURANCE_PERCENT = 1;
    private static final long INSURANCE_MINIMUM = 20;

    private final List<OrderLine> lines = new ArrayList<>();
    private final Zone zone;
    private final DeliveryCalculator deliveryCalculator;
    private Coupon coupon;
    private boolean placed;
    private int placedDay;
    private PriceBreakdown finalBreakdown;

    public Order(Zone zone, DeliveryCalculator deliveryCalculator) {
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
        if (!line.isProduct() || !(line.product() instanceof Insurable)) {
            throw new NotInsurableException("Line " + lineIndex + " cannot be insured");
        }
        line.insure();
    }

    public PriceBreakdown quote(int today) throws CheckoutException {
        long subtotal = subtotal();
        long discount = discount(today);
        long delivery = deliveryCalculator.delivery(lines, zone);
        long vat = vat();
        long insurance = insurance();
        long serviceFee = serviceFee(subtotal);
        long grandTotal = subtotal - discount + delivery + vat + insurance + serviceFee;
        return new PriceBreakdown(subtotal, discount, delivery, vat, insurance, serviceFee, grandTotal);
    }

    public void place(PaymentMethod payment, int today) throws CheckoutException {
        PriceBreakdown breakdown = quote(today);
        checkStockAvailable();
        authorisePayment(payment, breakdown.grandTotal());
        reserveStock();

        placed = true;
        placedDay = today;
        finalBreakdown = breakdown;
    }

    public void acceptReturn(int lineIndex, int today) throws ReturnNotAllowedException {
        OrderLine line = lines.get(lineIndex);
        if (!placed) {
            throw new ReturnNotAllowedException("Order has not been placed");
        }
        if (!line.isProduct() || !(line.product() instanceof Returnable returnable)) {
            throw new ReturnNotAllowedException("Line " + lineIndex + " is not returnable");
        }
        if (line.returned()) {
            throw new ReturnNotAllowedException("Line " + lineIndex + " has already been returned");
        }
        if (today > placedDay + returnable.returnWindowDays()) {
            throw new ReturnNotAllowedException("Line " + lineIndex + " is past its return window");
        }
        line.markReturned();
    }

    public boolean placed() {
        return placed;
    }

    public PriceBreakdown finalBreakdown() {
        return finalBreakdown;
    }

    public List<OrderLine> lines() {
        return lines;
    }

    // ---- pricing helpers ----

    private long subtotal() {
        long total = 0;
        for (OrderLine line : lines) {
            total += line.charge();
        }
        return total;
    }

    private long discount(int today) throws CheckoutException {
        if (coupon == null) {
            return 0;
        }
        return coupon.discount(discountableBase(), today);
    }

    private long discountableBase() {
        long base = 0;
        for (OrderLine line : lines) {
            if (line.isProduct() && line.product() instanceof Discountable) {
                base += line.charge();
            }
        }
        return base;
    }

    private long vat() {
        long total = 0;
        for (OrderLine line : lines) {
            total += line.vat();
        }
        return total;
    }

    private long insurance() {
        long total = 0;
        for (OrderLine line : lines) {
            if (line.insured()) {
                total += Math.max(INSURANCE_MINIMUM, MoneyMath.ceilPercentage(line.charge(), INSURANCE_PERCENT));
            }
        }
        return total;
    }

    private long serviceFee(long subtotal) {
        return Math.min(MoneyMath.ceilPercentage(subtotal, SERVICE_FEE_PERCENT), SERVICE_FEE_CAP);
    }

    // ---- placement helpers ----

    private void checkStockAvailable() throws OutOfStockException {
        for (OrderLine line : lines) {
            if (!line.isProduct()) {
                continue;
            }
            CatalogItem item = line.product();
            if (line.quantity() > item.remaining()) {
                throw new OutOfStockException(item.sku(), line.quantity(), item.remaining());
            }
        }
    }

    private void authorisePayment(PaymentMethod payment, long grandTotal) throws PaymentDeclinedException {
        payment.authorise(grandTotal);
    }

    private void reserveStock() throws OutOfStockException {
        for (OrderLine line : lines) {
            if (line.isProduct()) {
                line.product().reserve(line.quantity());
            }
        }
    }
}