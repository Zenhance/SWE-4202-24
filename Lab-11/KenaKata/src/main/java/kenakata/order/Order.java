package kenakata.order;
import kenakata.catalog.CatalogItem;
import kenakata.catalog.StockedGood;
import kenakata.exceptions.*;
import kenakata.payment.PaymentMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private final Zone zone;
    private final DeliveryCalculator deliveryCalculator;
    private final List<OrderLine> line = new ArrayList<>();
    private Coupon coupon;
    private boolean placed = false;
    private PriceBreakdown finalBreakdown;
    private int placementDay;

    public Order(Zone zone, DeliveryCalculator deliveryCalculator) {
        this.zone = zone;
        this.deliveryCalculator = deliveryCalculator;
    }

    public void addProduct(CatalogItem item, int quantity) {
        lines.add(new OrderLine(item, quantity));
    }

    public void addAddOn(Chargeable addOn) {
        lines.add(new OrderLine(addOn, 1));
    }

    public void applyCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public void insure(int lineIndex) throws NotInsurableException {
    }
    if(!(line.item()instanceof Insurable))

    {
        throw new NotInsurableException("Line item is not insurable");
    }
    line.setInsured(true);
}




}
