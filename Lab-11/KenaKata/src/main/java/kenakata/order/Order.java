package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Insurable;
import kenakata.catalog.OrderableLine;
import kenakata.exceptions.CheckoutException;
import kenakata.exceptions.NotInsurableException;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public static final double service_fee_per=0.01;
    public static final double Insurance_per=0.01;
    public static final long service_fee=100;
    public static final long insurance_minimum=20;
    private final List<OrderLine> lines= new ArrayList<>();
    private final Zone zone;
    private final DeliveryCalculator deliveryCalculator;
    private Coupon coupon;
    private boolean placed;
    private int placedday;
    private PriceBreakdown breakdown;

    public Order(Zone zone, DeliveryCalculator deliveryCalculator) {
        this.zone = zone;
        this.deliveryCalculator = deliveryCalculator;
    }
    public void addProduct(CatalogItem item , int qty){
        lines.add(new OrderLine(item,qty));
    }
    public void addAddOn(OrderableLine addon){
        lines.add(new OrderLine(addon,1));
    }
    public void applycoupon(Coupon coupon){
        this.coupon=coupon;
    }

    public void insure(int index)throws NotInsurableException{
        OrderLine line=lines.get(index);
        if(!(line.isproduct()) || (!(line.getItem() instanceof Insurable)))
            throw new NotInsurableException("Invalid");
        line.insure();

    }

    public PriceBreakdown quote(int today)throws CheckoutException {

    }
    public void place(Pay)



}
