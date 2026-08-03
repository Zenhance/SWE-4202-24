package kenakata.order;

import kenakata.catalog.*;
import kenakata.exceptions.*;
import kenakata.payment.PaymentMethod;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Zone zone;
    private DeliveryCalculator deliveryCalculator;
    private List<OrderLine> lines;
    private Coupon coupon;
    private boolean placed;
    private PriceBreakdown finalBreakdown;
    private int placedDay;

    public Order(Zone zone, DeliveryCalculator deliveryCalculator) {
        this.zone = zone;
        this.deliveryCalculator = deliveryCalculator;
        this.lines = new ArrayList<>();
    }
    public void addProduct(CatalogItem item, int quantity) {
        if(quantity <= 0) {
            throw new IllegalArgumentException("Invalid quantity");
        }
        lines.add(new OrderLine(item,quantity));
    }
    public void addAddOn(Chargeable addOn) {
        lines.add(new OrderLine(addOn,1));
    }
    public List<OrderLine> lines() {
        return lines;
    }
    public void applyCoupon(Coupon coupon) {
        this.coupon = coupon;
    }
    public PriceBreakdown quote(int day)
            throws CouponRejectedException {
        long subtotal = 0;
        long vat = 0;
        long discountBase = 0;
        for(OrderLine line : lines) {
            Chargeable item = line.item();
            long value = line.value();
            subtotal += value;
            vat += item.unitVat() * line.quantity();
            if(item instanceof Discountable) {
                discountBase += value;
            }
        }
        long discount = 0;
        if(coupon != null) {
            if(day > coupon.expiryDay()) {
                throw new CouponRejectedException("Coupon expired");
            }
            if(subtotal < coupon.minimumSpend()) {
                throw new CouponRejectedException("Minimum spend not reached");
            }
            discount = (discountBase * coupon.percentage() +99) /100;
            if(discount > coupon.maximumDiscount()) {
                discount = coupon.maximumDiscount();
            }
        }
        long delivery = deliveryCalculator.calculate(lines, zone);
        long insurance = calculateInsurance();
        long serviceFee = (subtotal + 99) /100;
        if(serviceFee > 100) {
            serviceFee = 100;
        }
        return new PriceBreakdown(subtotal, discount, delivery, vat, insurance, serviceFee);
    }
    private long calculateInsurance() {
        long total = 0;
        for(OrderLine line: lines) {
            if(line.insured()) {
                long value = line.value();
                long fee = (value + 99)/100;
                if(fee < 20) {
                    fee = 20;
                }
                total += fee;
            }
        }
        return total;
    }
    public void insure(int index) throws NotInsurableException {
        if(index <0 || index >= lines.size()) {
            throw new NotInsurableException("Invalid line");
        }
        OrderLine line = lines.get(index);
        if(!(line.item() instanceof Insurable)) {
            throw new NotInsurableException("Item cannot be insured");
        }
        line.makeInsured();
    }
    public void place(PaymentMethod payment, int day) throws CheckoutException {
        PriceBreakdown breakdown = quote(day);
        for(OrderLine line: lines) {
            if(line.item() instanceof StockedGood) {
                StockedGood product = (StockedGood) line.item();
                if(product.remaining() < line.quantity()) {
                    throw new OutOfStockException("Not enough stock");
                }
            }
        }
        payment.authorise(breakdown.grandTotal());

        for(OrderLine line: lines) {
            if(line.item() instanceof StockedGood) {
                StockedGood product = (StockedGood) line.item();
                product.reserve(line.quantity());
            }
        }
        placed = true;
        placedDay = day;
        finalBreakdown = breakdown;
    }
    public boolean placed() {
        return placed;
    }
    public PriceBreakdown finalBreakdown() {
        return finalBreakdown;
    }
    public void acceptReturn(int index, int day)
            throws ReturnNotAllowedException {
        if(!placed) {
            throw new ReturnNotAllowedException("Order not placed");
        }
        OrderLine line = lines.get(index);

        if(line.returned()) {
            throw new ReturnNotAllowedException("Already returned");
        }
        if(!(line.item() instanceof Returnable)) {
            throw new ReturnNotAllowedException("Cannot return");
        }
        Returnable item = (Returnable) line.item();

        if(day > placedDay + item.returnDays()) {
            throw new ReturnNotAllowedException("Return period ended");
        }
        line.makeReturned();
    }
}