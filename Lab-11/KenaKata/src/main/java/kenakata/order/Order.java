package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
import kenakata.exceptions.CheckoutException;
import kenakata.exceptions.NotInsurableException;
import kenakata.exceptions.ReturnNotAllowedException;
import kenakata.payment.PaymentMethod;

import java.util.ArrayList;
import java.util.List;

public final class Order {


    private final Zone zone;
    private final DeliveryCalculator deliveryCalculator;
    private final List<OrderLine> lines = new ArrayList<>();
    private Coupon coupon;
    private boolean placed;
    private PriceBreakdown finalBreakdown;

    public Order(Zone zone, DeliveryCalculator deliveryCalculator) {
        this.zone = zone;
        this.deliveryCalculator = deliveryCalculator;
    }
    public void addProduct(CatalogItem item, int quantity) {

    }

    public void addAddOn(Chargeable addOn) {
    }

    public void applyCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public void insure(int lineIndex) throws NotInsurableException {
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


