package kenakata.order;

import kenakata.catalog.*;
import kenakata.exceptions.*;
import kenakata.payment.PaymentMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private Zone zone;
    private DeliveryCalculator deliveryCalculator;
    private List<OrderLine> lines = new ArrayList<>();
    private Coupon coupon;
    private boolean isPlaced = false;
    private PriceBreakdown finalBreakdown;
    private int placementDay;

    public Order(Zone zone, DeliveryCalculator deliveryCalculator) {
        if (zone == null || deliveryCalculator == null) {
            throw new IllegalArgumentException("Zone and DeliveryCalculator must not be null");
        }
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

    public void insure(int lineIndex) throws NonInsurableException {
        if (lineIndex < 0 || lineIndex >= lines.size()) {
            throw new IllegalArgumentException("Invalid line index");
        }
        OrderLine line = lines.get(lineIndex);
        if (line.item() instanceof Insurable) {
            line.setInsured(true);
        } else {
            throw new NonInsurableException("Non Insurable Product");
        }
    }
}