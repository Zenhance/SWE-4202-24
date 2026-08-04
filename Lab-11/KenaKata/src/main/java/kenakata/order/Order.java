package kenakata.order;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kenakata.catalog.*;
import kenakata.exceptions.CouponRejectedException;
import kenakata.exceptions.EmptyWalletException;
import kenakata.exceptions.NotInsurableException;
import kenakata.exceptions.ReturnNotAllowedException;
import kenakata.payment.MobileWalletPayment;
import kenakata.payment.PaymentMethod;

import java.util.ArrayList;
import java.util.Map;

public class Order {
    private final List<OrderLine> lines = new ArrayList<>();
    private PriceBreakdown finalBreakdown;
    public Order(Object dhaka, DeliveryCalculator deliveryCalculator) {
    }

    public void addProduct(CatalogItem item, int quantity) {

    }

    public void addAddOn(GiftWrap giftWrap) {
    }

    public void applyCoupon(Coupon eid10) {
    }

    public PriceBreakdown quote(int i) throws CouponRejectedException {

        return finalBreakdown;
    }


    public void insure(int i) throws NotInsurableException {
    }

    public void place(PaymentMethod payment, int i) throws EmptyWalletException {
    }

    public boolean placed() {
        return true;
    }

    public PriceBreakdown finalBreakdown() {
        return finalBreakdown;
    }

    public void acceptReturn(int i, int i1) throws ReturnNotAllowedException {
    }



    public List<OrderLine> lines() {
        return Collections.unmodifiableList(lines);
    }

    public void addAddOn(Chargeable unit) {
    }

    public void addAddOn(ExpressHandling expressHandling) {
    }
}
