package kenakata.order;

import kenakata.catalog.*;
import kenakata.exceptions.CheckoutException;
import kenakata.payment.MobileWalletPayment;
import kenakata.payment.PaymentMethod;

import javax.xml.catalog.Catalog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Order {
    private PaymentMethod paymentMethod;
    List<OrderLines> orderLines = new ArrayList<>();


    public Order(Enum delivery, DeliveryCalculator deliveryCalculator) {

    }


    public PriceBreakdown quote(int i) {
        PriceBreakdown priceBreakdown = new PriceBreakdown();
        return priceBreakdown;

    }

    public void addAddOn(Chargeable chargeable) {

    }

    public void applyCoupon(Coupon c) {
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




    public void addProduct(CatalogItem item, int i){
        orderLines.add(new OrderLines(item, i));
    }

}
