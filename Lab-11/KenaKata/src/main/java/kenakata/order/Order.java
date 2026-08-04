package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
import kenakata.catalog.GiftWrap;
import kenakata.catalog.StockedGood;
import kenakata.exceptions.CheckoutException;
import kenakata.exceptions.NotInsurableException;
import kenakata.exceptions.ReturnNotAllowedException;
import kenakata.payment.MobileWalletPayment;
import kenakata.payment.PaymentMethod;

import java.util.ArrayList;
import java.util.List;

public class Order
{
    private Zone zone;
    private DeliveryCalculator deliveryCalculator;
    public final List<OrderLine> lines = new ArrayList<>();
    private Coupon coupon;
    public PriceBreakdown priceBreakdown;
    private ArrayList<Chargeable> items;
    private ArrayList<Integer> quantities;
    private ArrayList<Boolean> insured;
    private ArrayList<Boolean> returned;

    public Order(Zone zone, DeliveryCalculator deliveryCalculator)
    {
        if(zone==null)
            throw new IllegalArgumentException("Zone can not be null");
        if(deliveryCalculator==null)
            throw new IllegalArgumentException("Delivery Calculator can not be null");
        this.zone = zone;
        this.deliveryCalculator = deliveryCalculator;
    }

    public void addProduct(CatalogItem item, int qty)
    {
        items.add(item);
        quantities.add(qty);
        insured.add(false);
        returned.add(false);
    }

    public void addAddOn(Chargeable addOn)
    {
        items.add(addOn);
        quantities.add(1);
        insured.add(false);
        returned.add(false);
    }

    public void applyCoupon(Coupon coupon)
    {
        this.coupon=coupon;
    }

    public PriceBreakdown quote(int day) throws CheckoutException
    {
        return null;
    }

    public void insure(int qty) throws NotInsurableException
    {

    }

    public void place(PaymentMethod payment, int day) throws CheckoutException
    {

    }

    public boolean placed()
    {
        return false;
    }

    public PriceBreakdown finalBreakdown()
    {
        return null;
    }

    public void acceptReturn(int serial, int day) throws ReturnNotAllowedException
    {

    }

    public List<OrderLine> lines()
    {
        return lines;
    }
}