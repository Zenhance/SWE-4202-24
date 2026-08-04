package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
import kenakata.catalog.Insurable;
import kenakata.exceptions.*;
import kenakata.payment.PaymentMethod;

import java.util.ArrayList;

public class Order {
    private Zone zone;
    private DeliveryCalculator calculator;
    private ArrayList<Chargeable> chargeables;
    private Coupon coupon;
    private PriceBreakdown priceBreakdown;
    private boolean hasStock = true;
    private String itemOutOfStock;

    public Order(Zone zone, DeliveryCalculator calculator) {
        if (zone == null)
            throw new IllegalArgumentException("Delivery zone cannot be null");
        this.zone = zone;

        if (calculator == null)
            throw new IllegalArgumentException("Delivery calculator cannot be null");
        this.calculator = calculator;

        chargeables = new ArrayList<>();
        priceBreakdown = new PriceBreakdown(chargeables, zone);
    }

    public void addProduct(CatalogItem product, int qty) {
        for (int i = 0; i < qty; i++)
            chargeables.add(product);
        if (qty > product.remaining()) {
            hasStock = false;
            itemOutOfStock = product.getTitle();
        }

    }

    public void addAddOn(Chargeable addOn) {
        chargeables.add(addOn);
    }

    public void applyCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public PriceBreakdown quote(int day) throws CouponRejectedException {
        priceBreakdown.setCoupon(coupon);

        if (coupon != null) {
            if (isCouponExpired(day))
                throw new CouponRejectedException("An expired coupon is refused");
            if (!hasSpentMinimum())
                throw new CouponRejectedException("A coupon below its minimum spend is refused");

        }

        return priceBreakdown;
    }

    public boolean isCouponExpired(int day) {
        return day > coupon.getLastValidDay();
    }

    public boolean hasSpentMinimum() {
        return priceBreakdown.discountableAmount() > coupon.getMinimumSpend();
    }

    public void insure(int index) throws NotInsurableException {
        Chargeable c = chargeables.get(index);
        if (c instanceof Insurable)
            ((Insurable) c).insure();
    }

    // check the parameter
    public void place(PaymentMethod p, int day) throws CheckoutException {
        if (!hasStock)
            throw new OutOfStockException(itemOutOfStock + " is out-of-stock");
        p.authorise(priceBreakdown.grandTotal());
    }

    public boolean placed() {
        return false;
    }

    public PriceBreakdown finalBreakdown() {
        return new PriceBreakdown(chargeables, zone);
    }

    public void acceptReturn(int serial, int day) throws ReturnNotAllowedException {

    }

    public ArrayList<Chargeable> lines() {
        return chargeables;
    }
}
