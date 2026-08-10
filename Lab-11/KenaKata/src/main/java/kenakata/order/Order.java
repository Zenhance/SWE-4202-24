package kenakata.order;

import kenakata.catalog.*;
import kenakata.exceptions.*;
import kenakata.payment.*;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final Zone zone;
    private final DeliveryCalculator deliveryCalculator;
    private final List<OrderLine> lines = new ArrayList<>();
    private Coupon coupon;
    private boolean placed;
    private int placeDay = -1;
    private PriceBreakdown breakdown;

    public Order(Zone zone, DeliveryCalculator deliveryCalculator) {
        if (zone == null)
            throw new IllegalArgumentException("Zone cannot be null");

        if (deliveryCalculator == null)
            throw new IllegalArgumentException("Delivery calculator cannot be null");

        this.zone = zone;
        this.deliveryCalculator = deliveryCalculator;
    }
    public void addProduct(CatalogItem item, int quantity) {
        lines.add(new OrderLine(item, quantity));
    }
    public void addAddOn(Chargeable addOn) {
        lines.add(new OrderLine(addOn, 1));
    }
    public List<OrderLine> lines() {
        return lines;
    }
    public boolean placed() {
        return placed;
    }
    public int placeDay() {
        return placeDay;
    }
    public void applyCoupon(Coupon coupon) {
        this.coupon = coupon;
    }
    public PriceBreakdown quote(int today)
            throws CouponRejectedException {
        long subtotal = 0;
        long vat = 0;
        long weight = 0;
        int freshLines = 0;
        long insurance = 0;
        for (OrderLine line : lines) {

            subtotal += line.charge();
            vat += line.vat();

            if (line.item() instanceof Weighable w) {
                weight += (long) w.unitWeightGrams() * line.quantity();
            }

            if (line.item() instanceof FreshGood) {
                freshLines++;
            }

            if (line.insured()) {
                insurance += Math.max(20, line.charge() / 100);
            }
        }

        long discount = 0;

        if (coupon != null) {
            discount = discountFor(subtotal, today);
        }

        long delivery =
                deliveryCalculator.calculate(
                        zone,
                        weight,
                        freshLines
                );

        long serviceFee =
                Math.min(100, (long) Math.ceil(subtotal * 0.01));

        long grandTotal =
                subtotal
                        - discount
                        + vat
                        + delivery
                        + insurance
                        + serviceFee;

        breakdown = new PriceBreakdown(
                subtotal,
                discount,
                delivery,
                vat,
                insurance,
                serviceFee,
                grandTotal
        );

        return breakdown;
    }

    public PriceBreakdown finalBreakdown() {
        return breakdown;
    }

    public long discountFor(long base, int today)
            throws CouponRejectedException {

        if (coupon == null)
            return 0;

        return coupon.discount(base, today);
    }

    public void insure(int index)
            throws NotInsurableException {

        if (index < 0 || index >= lines.size())
            throw new IllegalArgumentException();

        OrderLine line = lines.get(index);

        if (!(line.item() instanceof Insurable))
            throw new NotInsurableException("Item is not insurable");

        line.insure();
    }
    public void place(
            PaymentMethod payment,
            int today
    ) throws CheckoutException {

        if (payment == null)
            throw new IllegalArgumentException("Payment cannot be null");

        PriceBreakdown b = quote(today);

        try {

            for (OrderLine line : lines) {

                if (line.item() instanceof CatalogItem item) {
                    item.reserve(line.quantity());
                }
            }

            payment.authorise(b.grandTotal());

            for (OrderLine line : lines) {
                line.markPlaced(today);
            }

            placed = true;
            placeDay = today;

        } catch (PaymentDeclinedException e) {
            throw e;
        }
    }

    public void acceptReturn(
            int index,
            int today
    ) throws CheckoutException {

        if (index < 0 || index >= lines.size())
            throw new IllegalArgumentException();
        OrderLine line = lines.get(index);
        if (!(line.item() instanceof Returnable))
            throw new ReturnNotAllowedException(
                    "Item is not returnable"
            );
        if (line.returned())
            throw new ReturnNotAllowedException(
                    "Already returned"
            );
        int window = 7;
        if (line.item() instanceof FreshGood)
            window = 2;
        if (today > line.placedDay() + window)
            throw new ReturnNotAllowedException(
                    "Return window expired"
            );
        line.markReturned(today);
    }
}