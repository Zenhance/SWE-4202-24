package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
import kenakata.catalog.FreshGood;
import kenakata.catalog.StockedGood;
import kenakata.catalog.Weighable;
import kenakata.exceptions.CouponRejectedException;
import kenakata.exceptions.CheckoutException;
import kenakata.exceptions.NotInsurableException;
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
    public Order(Zone zone, DeliveryCalculator deliveryCalculator) {

        if (zone == null || deliveryCalculator == null) {
            throw new IllegalArgumentException();
        }

        this.zone = zone;
        this.deliveryCalculator = deliveryCalculator;
    }

    public void addProduct(CatalogItem item, int quantity) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        lines.add(new OrderLine(item, quantity));
    }

    public void addAddOn(Chargeable item) {
        lines.add(new OrderLine(item, 1));
    }

    public void applyCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public List<OrderLine> lines() {
        return lines;
    }

    public boolean placed() {
        return placed;
    }

    public PriceBreakdown finalBreakdown() {
        return finalBreakdown;
    }

    public PriceBreakdown quote(int today)
            throws CouponRejectedException {

        long subtotal = 0;
        long vat = 0;
        long weight = 0;
        int freshLines = 0;
        long discountable = 0;
        long insurance = 0;

        for (OrderLine line : lines) {

            subtotal += line.charge();
            vat += line.vat();

            if (line.isProduct()) {

                CatalogItem item = line.catalogItem();

                if (item instanceof StockedGood) {
                    discountable += line.charge();
                }

                if (item instanceof Weighable) {
                    Weighable w = (Weighable) item;
                    weight += w.weightGrams() * line.quantity();
                }

                if (item instanceof FreshGood) {
                    freshLines++;
                }

                if (line.insured()) {
                    insurance += Math.max(
                            20,
                            (long) Math.ceil(
                                    item.unitCharge()
                                            * line.quantity()
                                            * 0.01
                            )
                    );
                }
            }
        }

        long discount = 0;

        if (coupon != null) {
            discount = coupon.discount(discountable, today);
        }

        long delivery =
                deliveryCalculator.calculate(
                        zone,
                        weight,
                        freshLines
                );

        long serviceFee =
                Math.min(
                        100,
                        (long) Math.ceil(subtotal * 0.01)
                );

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

    public void place(
            PaymentMethod payment,
            int today
    ) throws CheckoutException {

        if (payment == null) {
            throw new IllegalArgumentException();
        }

        PriceBreakdown breakdown = quote(today);

        // Reserve stock first.
        for (OrderLine line : lines) {

            if (line.isProduct()) {
                line.catalogItem().reserve(line.quantity());
            }
        }

        // Payment.
        payment.authorise(breakdown.grandTotal());

        for (OrderLine line : lines) {
            line.markPlaced(today);
        }

        placed = true;
        finalBreakdown = breakdown;
    }

    public void insureLine(int index) {

        if (index < 0 || index >= lines.size()) {
            throw new IllegalArgumentException();
        }

        lines.get(index).insure();
    }

    public void acceptReturn(
            int index,
            int today
    ) throws CheckoutException {

        if (index < 0 || index >= lines.size()) {
            throw new IllegalArgumentException();
        }

        OrderLine line = lines.get(index);

        if (!line.isProduct()) {
            throw new CheckoutException("Not a product");
        }
        CatalogItem item = line.catalogItem();
        if (!(item instanceof kenakata.catalog.Returnable)) {
            throw new CheckoutException("Item is not returnable");
        }
        kenakata.catalog.Returnable r =
                (kenakata.catalog.Returnable) item;
        if (today > line.placeDay() + r.returnWindowDays()) {
            throw new CheckoutException("Return window expired");
        }
        line.markReturned(today);
    }
}