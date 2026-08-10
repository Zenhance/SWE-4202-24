package kenakata.order;

import kenakata.catalog.ExpressHandling;
import kenakata.payment.MobileWalletPayment;
import kenakata.catalog.CatalogItem;
import kenakata.catalog.GiftWrap;
import kenakata.catalog.StockedGood;
import kenakata.payment.PaymentMethod;
import kenakata.catalog.Chargeable;
import kenakata.exceptions.CheckoutException;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<OrderLine> lines = new ArrayList<>();
    private Coupon coupon;

    public Order(Object dhaka, DeliveryCalculator deliveryCalculator) {
    }

    public void addProduct(CatalogItem item, int quantity) {
        lines.add(new OrderLine(item, quantity));
    }

    public void applyCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public PriceBreakdown quote(int today) {
        long subtotal = 0;

        for (OrderLine line : lines) {
            subtotal += line.unit().unitCharge() * line.quantity();
        }
        return new PriceBreakdown(subtotal, 0, 0, 0, 0, 0);
    }

    public void insure(int i) {
    }

    public void place(MobileWalletPayment mobileWalletPayment, int i) {
    }

    public boolean placed() {
        return true;
    }

    public PriceBreakdown finalBreakdown() {
        return null;
    }

    public PriceBreakdown acceptReturn(int i, int i1) {
        return null;
    }

    public List<OrderLine> lines() {
        return lines;
    }

    public void place(PaymentMethod payment, int today) throws CheckoutException {
    }

    public void addAddOn(Chargeable addOn) {
        lines.add(new OrderLine(addOn, 1));
    }
}
