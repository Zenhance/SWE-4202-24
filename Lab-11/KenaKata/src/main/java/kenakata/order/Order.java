package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
import kenakata.exceptions.CheckoutException;
import kenakata.payment.PaymentMethod;

import java.util.ArrayList;

public class Order {
    ArrayList<Line> Lines = new ArrayList<>();
    public Coupon coupon;

    public Order(Zone zone, DeliveryCalculator deliveryCalculator) {

    }

    public void addProduct(CatalogItem item, int amount) {
        Lines.add(new Line(item,amount));

    }

    public void addAddOn(Chargeable e) {
        Lines.add(new Line(e));
    }

    public void applyCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public PriceBreakdown quote(int i) {
        return null;
    }

    public void insure(int i) {
    }

    public void place(PaymentMethod payment, int today) throws CheckoutException{
    }

    public void acceptReturn(int i, int i1) {
    }

    public boolean placed() {
        return false;
    }

    public PriceBreakdown finalBreakdown() {
        return null;
    }

    public ArrayList<Line> lines() {
        return Lines;
    }

    public void returned() {

    }
}
