package kenakata.order;

import java.util.ArrayList;
import java.util.List;

public class Order {
    
    private final Zone zone;
    private final DeliveryCalculator deliveryCalculator;
    
    private final List<OrderLine> lines = new ArrayList<>();
    
    private Coupon coupon;
    
    private boolean placed;
    private PriceBreakdown finalBreakdown;
    
    public Order(Zone zone, DeliveryCalculator deliveryCalculator) {
        if (zone == null || deliveryCalculator == null)
            throw new IllegalArgumentException();
        
        this.zone = zone;
        this.deliveryCalculator = deliveryCalculator;
    }
    
}