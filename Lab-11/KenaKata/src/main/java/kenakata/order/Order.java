package kenakata.order;
import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
import kenakata.exceptions.CheckoutException;
import kenakata.exceptions.NotInsurableException;
import kenakata.exceptions.ReturnNotAllowedException;
import kenakata.payment.PaymentMethod;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final Zone zone;
    private final DeliveryCalculator deliveryCalculator;

    public Order(Zone zone, DeliveryCalculator deliveryCalculator) {
        this.zone = zone;
        this.deliveryCalculator = deliveryCalculator;
    }

    public Zone getZone() {
        return zone;
    }

    public List<OrderLine> lines() {
        return new ArrayList<>();
    }

    public boolean placed() {
        return false;
    }

    public PriceBreakdown finalBreakdown() {
        return null;
    }

    public void addProduct(CatalogItem item, int quantity) {
    }

    public void addAddOn(Chargeable addOn) {
    }

    public void applyCoupon(Coupon coupon) {
    }

    public void insure(long day) throws NotInsurableException {
    }

    public PriceBreakdown quote(long day) throws CheckoutException {
        return new PriceBreakdown(0, 0, 0, 0, 0, 0, 0);
    }

    public void place(PaymentMethod paymentMethod, long day) throws CheckoutException {
    }

    public void acceptReturn(int lineIndex, long day) throws ReturnNotAllowedException {
    }
}
