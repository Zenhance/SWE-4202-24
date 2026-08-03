package kenakata.order;
import kenakata.catalog.CatalogItem;
import kenakata.catalog.StockedGood;
import kenakata.exceptions.*;
import kenakata.payment.PaymentMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Order {
    private final Zone zone;
    private final DeliveryCalculator deliveryCalculator;
    private final List<OrderLine> lines = new ArrayList<>();
    private Coupon coupon;
    private boolean placed = false;
    private PriceBreakdown finalBreakdown;
    private int placementDay;

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
        if (lineIndex < 0 || lineIndex >= lines.size()) {
            throw new NotInsurableException("Invalid line index");
        }
        OrderLine line = lines.get(lineIndex);
        if (!(line.item() instanceof Insurable)) {
            throw new NotInsurableException("Line item is not insurable");
        }
        line.setInsured(true);
    }

    public PriceBreakdown quote(int currentDay) throws CouponRejectedException {
        long subtotal = 0;
        long discountableBase = 0;
        long vat = 0;
        long insurance = 0;
        for (OrderLine line : lines) {
            subtotal += line.lineValue();
            vat += line.lineVat();
            insurance += line.insuranceFee();
            if (line.item() instanceof StockedGood) {
                discountableBase += line.lineValue();
            }
        }
        long discount=0;
        if (coupon!=null){
            discount=coupon.calculateDiscount(discountableBase, currentDay);
        }
        long delivery = deliveryCalculator.calculateDelivery(lines, zone);
        long serviceFee = (long) Math.ceil(subtotal * 0.01);
        serviceFee = Math.min(serviceFee, 100);
        long grandTotal = subtotal - discount + delivery + vat + insurance + serviceFee;
        return new PriceBreakdown(subtotal, discount, vat, delivery, insurance, serviceFee, grandTotal);
    }
    public void place(PaymentMethod paymentMethod, int currentDay) throws CheckoutException{
        PriceBreakdown breakdown = quote(currentDay);
        paymentMethod.authorise(breakdown.grandTotal());
        for (OrderLine line : lines) {
            if (line.item() instanceof CatalogItem catalogItem) {
                catalogItem.reserve(line.quantity());
            }
        }
        this.placed = true;
        this.finalBreakdown = breakdown;
        this.placementDay = currentDay;
    }
}
