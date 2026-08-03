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
}