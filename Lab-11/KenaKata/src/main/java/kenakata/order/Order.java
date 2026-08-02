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

    public Order(Zone zone, DeliveryCalculator deliveryCalculator){
        this.zone= zone;
        this.deliveryCalculator = deliveryCalculator;
    }





}
