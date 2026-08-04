package kenakata.order;

import kenakata.Main;
import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
import kenakata.payment.PaymentMethod;
import kenakata.exceptions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Order {
    private final Zone zone;
    private final DeliveryCalculator deliveryCalculator;
    private final List<OrderLine> lines = new ArrayList<>();
    private Coupon coupon;
    private boolean isPlaced = false;
    private PriceBreakdown finalBreakdown;
    private int placedDay;

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

    public void insure(int lineIndex) {
        if (lineIndex < 0 || lineIndex >= lines.size()) {
            throw new IndexOutOfBoundsException("Invalid line index");
        }
        OrderLine line = lines.get(lineIndex);
        if (line.item() instanceof CatalogItem item && item.isInsurable()) {
            line.setInsured(true);
        } else {
            throw new NotInsurableException("Line item is not insurable");
        }
    }

    public List<OrderLine> lines() {
        return Collections.unmodifiableList(lines);
    }

    public boolean placed() {
        return isPlaced;
    }

    public PriceBreakdown finalBreakdown() {
        return finalBreakdown;
    }

    public int placedDay() {
        return placedDay;
    }

    public PriceBreakdown quote(int currentDay) throws CouponRejectedException {
        long subtotal = 0;
        long discountableBase = 0;
        long vat = 0;
        long insuranceFee = 0;
        for (OrderLine line : lines) {
            subtotal += line.lineCharge();
            vat += line.lineVat();
            if (line.item() instanceof CatalogItem item) {
                if (item.isDiscountable()) {
                    discountableBase += line.lineCharge();
                }
                if (line.insured()) {
                    long fee = (long)Math.ceil(line.lineCharge() * 0.01);
                    insuranceFee += Math.max(fee, 20);
                }
            }
        }
        long discount = 0;
        if (coupon != null) {
            coupon.validate(subtotal, currentDay);
        }
        long deliveryFee=deliveryCalculator.calculate(zone,lines);
        long rawServiceFee=(long)Math.ceil(subtotal*0.01);
        long serviceFee=Math.min(rawServiceFee,100);
        long grandTotal=subtotal-discount+vat+deliveryFee+insuranceFee+serviceFee;
        return new PriceBreakdown(subtotal,discount,vat,deliveryFee,insuranceFee,serviceFee,grandTotal);
    }
    public void place(PaymentMethod paymentMethod,int day) throws CheckoutException {
        PriceBreakdown breakdown = quote(day);
        List<CatalogItem> reservedItems = new ArrayList<>();
        List<Integer> reservedQuantities = new ArrayList<>();
        try {
            for (OrderLine line : lines) {
                if (line.item() instanceof CatalogItem item) {
                    item.reserve(line.quantity());
                    reservedItems.add(item);
                    reservedQuantities.add(line.quantity());

                }
            }
            paymentMethod.authorise(breakdown.grandTotal());
            this.isPlaced = isPlaced;
            this.placedDay = placedDay;
            this.finalBreakdown = finalBreakdown;
        } catch (CheckoutException e) {
            for (int i = 0; i < reservedItems.size(); i++) {
                try {
                    var remainingField = CatalogItem.class.getDeclaredField("stock");
                    remainingField.setAccessible(true);
                    int currentStock = remainingField.getInt(reservedItems.get(i));
                    remainingField.setInt(reservedItems.get(i), currentStock + reservedQuantities.get(i));
                } catch (Exception ex) {

                }
            }
            throw e;
        }
    }
    public void acceptReturn(int lineIndex,int returnDay) throws ReturnNotAllowedException{
            if(lineIndex<0||lineIndex>=lines.size()){
                throw new ReturnNotAllowedException("Invalid line index");
            }
            OrderLine line=lines.get(lineIndex);
            if(line.returned()){
                throw new ReturnNotAllowedException("Line has already been returned");
            }
            if(!((line.item()) instanceof CatalogItem item)|| !item.isReturnable()){
                throw new ReturnNotAllowedException("Item is not returnable");
            }
            if(returnDay>placedDay+ item.returnWindowDays()){
                throw new ReturnNotAllowedException("Return window has expired");
            }
            line.markReturned();
    }

}