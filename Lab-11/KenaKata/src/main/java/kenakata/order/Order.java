package kenakata.order;

import kenakata.catalog.*;
import kenakata.exceptions.CheckoutException;
import kenakata.exceptions.NotInsurableException;
import kenakata.exceptions.ReturnNotAllowedException;
import kenakata.payment.PaymentMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    
    private final Zone zone;
    private final DeliveryCalculator deliveryCalculator;
    private int placedDay = -1;
    private final List<OrderLine> lines = new ArrayList<>();
    private Coupon coupon;
    private boolean placed;
    private PriceBreakdown finalBreakdown;
    
    public Order(Zone zone, DeliveryCalculator deliveryCalculator) {
        if (zone == null || deliveryCalculator == null)
            throw new IllegalArgumentException();
        
        this.zone = zone;
        this.deliveryCalculator = deliveryCalculator;
    }

    public void addProduct(CatalogItem item, int quantity) {

        if (quantity <= 0)
            throw new IllegalArgumentException();

        lines.add(new OrderLine(item, quantity));
    }

    public void addAddOn(Chargeable addOn) {
        lines.add(new OrderLine(addOn));
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

    public void applyCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public void place(PaymentMethod paymentMethod, long amount){

    }

    public void insure(int lineIndex) throws NotInsurableException {
        if (placed) {
            throw new IllegalStateException();
        }
        OrderLine line = lineAt(lineIndex);
        if (!(line.getProduct() instanceof Insurable)) {
            throw new NotInsurableException("Line cannot be insured");
        }
        line.markInsured();
    }

    public PriceBreakdown quote(int currentDay) throws CheckoutException {
        if (currentDay < 0) {
            throw new IllegalArgumentException("");
        }
        return calculateBreakdown(currentDay);
    }

    public void acceptReturn(int lineIndex, int returnDay) throws ReturnNotAllowedException {
        if (!placed) {
            throw new ReturnNotAllowedException("");
        }
        if (returnDay < 0) {
            throw new IllegalArgumentException();
        }
        OrderLine line = lineAt(lineIndex);
        if (line.returned()) {
            throw new ReturnNotAllowedException("The line has been returned");
        }
        if (!(line.getProduct() instanceof Returnable returnable)) {
            throw new ReturnNotAllowedException("");
        }
        int finalReturnDay = placedDay + returnable.returnWindow();
        if (returnDay > finalReturnDay) {
            throw new ReturnNotAllowedException("Return window has expired");
        }
        line.markReturned();
        line.getProduct().release(line.getQuantity());
    }

    private OrderLine lineAt(int index) {
        if (index < 0 || index >= lines.size()) {
            throw new IllegalArgumentException("Invalid line index");
        }
        return lines.get(index);
    }

    public PriceBreakdown calculateBreakdown(int currentDay) throws CheckoutException {
        if (currentDay < 0) {
            throw new IllegalArgumentException("");
        }
        long subtotal=0;
        long vat=0;
        long discountableBase= 0;
        long insurance =0;
        for(OrderLine line : lines){
            long value = line.lineCharge();
            subtotal=Math.addExact(subtotal,value);
            vat=Math.addExact(vat,line.lineVat());
            if (line.getProduct() instanceof Discountable){
                discountableBase = Math.addExact(discountableBase,value);
            }
            if(line.isInsured()){
                Insurable insurable = (Insurable) line.getProduct();
                long insurableValue =insurable.insurableValue(line.getQuantity());
                long calculated = (long)Math.ceil(insurableValue*0.01);
                long lineInsurance =Math.max(20, calculated);
                insurance = Math.addExact(insurance,lineInsurance);
            }
        }
        long discount;
        if (coupon == null) {discount=0;}
        else{
            discount = coupon.discountFor(discountableBase,subtotal,currentDay);
        }
        long delivery = deliveryCalculator.calculate(lines,zone);

        long serviceFee =(long) Math.min(100, Math.ceil(subtotal*0.01));
        long grandTotal = subtotal;
        grandTotal = Math.subtractExact(grandTotal,discount);
        grandTotal = Math.addExact(grandTotal,delivery);
        grandTotal = Math.addExact(grandTotal,vat);
        grandTotal = Math.addExact(grandTotal,insurance);
        grandTotal = Math.addExact(grandTotal,serviceFee);
        return new PriceBreakdown(subtotal,discount,delivery,vat,insurance,serviceFee,grandTotal);
    }
}