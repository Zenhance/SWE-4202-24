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
import java.util.Currency;
import java.util.List;
import java.util.function.Supplier;

public class Order {
private  Zone zone;
private  DeliveryCalculator deliveryCalculator;
public  List<OrderLine> lines =  new ArrayList<>();
private Coupon coupon;
private boolean placed;
private PriceBreakdown priceBreakdown;
private int placementDay;

    public Order(Zone zone, DeliveryCalculator deliveryCalculator) {
        this.zone = zone;
        this.deliveryCalculator = deliveryCalculator;
    }

    public void addProduct(CatalogItem item, int quantity) {
        lines.add(new OrderLine(item, quantity));
    }

    public void insure(int i) throws NotInsurableException {
        if (i < 0 || i >= lines.size()) {
            throw new IndexOutOfBoundsException("Invalid line index");
        }
        OrderLine line = lines.get(i);
        if (!line.getItem().insurable()) {
            throw new NotInsurableException("Not Insurable");
        }
        line.setInsured(true);
    }

    public void applyCoupon(Coupon c) {
        coupon = c;
    }

    public void addAddOn(Chargeable addon) {
        lines.add(new OrderLine(addon,1));
    }

    public boolean placed() {
        return false;
    }



    public PriceBreakdown finalBreakdown() {
        return null;
    }

    public void acceptReturn(int index, int day) throws ReturnNotAllowedException {
        OrderLine line = lines.get(index);
        Chargeable item = line.getItem();
        if(!item.returnable()|| day> placementDay+ item.returnDays()){
            throw new ReturnNotAllowedException("Product is not returnable now ");
        }
        line.setReturned(true);
    }


    public PriceBreakdown quote(int i) {

        return null;
    }

    public void place(PaymentMethod payment, int today) throws CheckoutException {

    }

    public List<OrderLine> lines() {
        return lines;
    }
}

