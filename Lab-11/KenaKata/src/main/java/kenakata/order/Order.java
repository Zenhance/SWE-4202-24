package kenakata.order;

import kenakata.catalog.*;
import kenakata.exceptions.CheckoutException;
import kenakata.exceptions.CouponRejectedException;
import kenakata.payment.MobileWalletPayment;
import kenakata.payment.PaymentMethod;

import javax.xml.catalog.Catalog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Order {
    Zone zone;
    Coupon coupon;
    private PaymentMethod paymentMethod;
    List<OrderLines> orderLines = new ArrayList<>();
    DeliveryCalculator deliveryCalculator;

    public Order(Zone zone, DeliveryCalculator deliveryCalculator) {
        this.zone = zone;
        this.deliveryCalculator = deliveryCalculator;
    }


    public PriceBreakdown quote(int day)throws CouponRejectedException {
        long subTotal = 0;
        for(OrderLines line : orderLines) {
            subTotal += line.item.unitCharge() * line.quantity;
        }
        long discount = 0;
        if(coupon.validDate >= day && coupon.minSpend <= subTotal) {
            long temp = 0;
            for(OrderLines line : orderLines) {
                if(line.item instanceof StockedGood){
                     temp += (long) Math.ceil(line.item.unitCharge() * line.quantity);
                }
            }
            temp = (long) Math.ceil(temp * coupon.percentage / 100);
            if(temp > coupon.cap) {
                discount = coupon.cap;
            }else{
                discount = temp;
            }
        }else{
            throw new CouponRejectedException("COUPON_REJECTED");
        }
        long vat = 0;
        for(OrderLines line : orderLines) {
            vat += (long) Math.ceil(line.item.unitVat() * line.quantity);
        }

        long serviceFee = (long) Math.ceil(0.01 * subTotal);

        long insurance = 0;
        for(OrderLines line : orderLines) {
            if(line.item instanceof StockedGood || line.item instanceof FreshGood){
                long temp = (long) Math.ceil(line.item.unitCharge() * line.quantity * 0.01);
                if(temp >= 20){
                    insurance += temp;
                }
            }
        }
        long delivery = deliveryCalculator.calculateDelivery(orderLines, zone);


        return new PriceBreakdown(subTotal, discount, vat, delivery, insurance, serviceFee);

    }

    public void addAddOn(Chargeable chargeable) {
        orderLines.add(new OrderLines(chargeable));
    }

    public void applyCoupon(Coupon c) {
        this.coupon = c;
    }

    public void insure(int i) {
    }

    public void place(PaymentMethod p, int i) throws CheckoutException {
        this.paymentMethod = p;
    }

    public boolean placed() {
        return false;
    }

    public void acceptReturn(int i, int i1) {
    }

    public List<OrderLines> lines() {
        return orderLines;
    }

    public PriceBreakdown finalBreakdown() {
        return null;
    }




    public void addProduct(CatalogItem item, int qty){
        if(qty <= 0){
            throw new IllegalArgumentException("qty must be greater than 0");
        }
        orderLines.add(new OrderLines(item, qty));
    }

}
