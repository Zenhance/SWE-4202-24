package kenakata.order;

import kenakata.catalog.*;
import kenakata.exceptions.*;
import kenakata.payment.PaymentMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private Zone zone;
    private DeliveryCalculator deliveryCalculator;
    private List<OrderLine> lines = new ArrayList<>();
    private Coupon coupon;
    private boolean isPlaced = false;
    private PriceBreakdown finalBreakdown;
    private int placementDay;

    public Order(Zone zone, DeliveryCalculator deliveryCalculator) {
        if (zone == null || deliveryCalculator == null) {
            throw new IllegalArgumentException("Zone and DeliveryCalculator must not be null");
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
        if (lineIndex < 0 || lineIndex >= lines.size()) {
            throw new IllegalArgumentException("Invalid line index");
        }
        OrderLine line = lines.get(lineIndex);
        if (line.item() instanceof Insurable) {
            line.setInsured(true);
        } else {
            throw new NotInsurableException("Non Insurable Product");
        }
    }

    public PriceBreakdown quote(int day) throws CheckoutException {
        long subtotal = 0;
        long discountableBase = 0;
        long vat = 0;
        long insurance = 0;

        for (OrderLine line : lines) {
            long lValue = line.lineValue();
            subtotal += lValue;
            vat += line.lineVat();

            if (line.item() instanceof StockedGood) {
                discountableBase += lValue;
            }

            if (line.isInsured()) {
                long insFee = (long) Math.ceil(lValue * 0.01);
                insurance += Math.max(insFee, 20);
            }
        }
        long discount = (coupon != null) ? coupon.calculateDiscount(discountableBase, day) : 0;
        long delivery = deliveryCalculator.calculate(lines, zone);
        long serviceFee = Math.min((long) Math.ceil(subtotal * 0.01), 100);

        long grandTotal = subtotal - discount + delivery + vat + insurance + serviceFee;
        return new PriceBreakdown(subtotal, discount, delivery, vat, insurance, serviceFee, grandTotal);
    }

    public void place(PaymentMethod paymentMethod, int day) throws CheckoutException {
        if (isPlaced) {
            throw new IllegalStateException("Order has already been placed");
        }

        PriceBreakdown bd = quote(day);

        for (OrderLine line : lines) {
            if (line.item() instanceof AbstractItem abstractItem) {
                if (abstractItem.remaining() < line.quantity()) {
                    throw new OutOfStockException("Insufficient stock ");
                }
            }
        }

        paymentMethod.authorise(bd.grandTotal());

        for (OrderLine line : lines) {
            if (line.item() instanceof AbstractItem abstractItem) {
                abstractItem.reserve(line.quantity());
            }
        }

        this.isPlaced = true;
        this.placementDay = day;
        this.finalBreakdown = bd;
    }

    public void acceptReturn(int lineIndex, int returnDay) throws ReturnNotAllowedException {
        if (!isPlaced) {
            throw new ReturnNotAllowedException("Order is not placed yet");
        }
        if (lineIndex < 0 || lineIndex >= lines.size()) {
            throw new IllegalArgumentException("Invalid line index");
        }

        OrderLine line = lines.get(lineIndex);

        if (line.returned()) {
            throw new ReturnNotAllowedException("Line has already been returned");
        }

        if (!(line.item() instanceof Returnable returnableItem)) {
            throw new ReturnNotAllowedException("Item is not returnable");
        }

        int window = returnableItem.returnWindowDays();
        if (returnDay > placementDay + window) {
            throw new ReturnNotAllowedException("Return window expired");
        }

        line.markReturned();
    }

    public boolean placed() {
        return isPlaced;
    }

    public PriceBreakdown finalBreakdown() {
        return finalBreakdown;
    }

    public List<OrderLine> lines() {
        return Collections.unmodifiableList(lines);
    }
}