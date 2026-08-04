package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Insurable;
import kenakata.catalog.Chargeable;
import kenakata.exceptions.CheckoutException;
import kenakata.exceptions.NotInsurableException;
import kenakata.payment.PaymentMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    public static final double service_fee_per=0.01;
    public static final double Insurance_per=0.01;
    public static final long service_fee=100;
    public static final long insurance_minimum=20;
    public final List<OrderLine> lines= new ArrayList<>();
    private final Zone zone;
    private final DeliveryCalculator deliveryCalculator;
    private Coupon coupon;
    public boolean placed;
    private int placedday;
    private PriceBreakdown breakdown;
    private OrderLine[] orderline;

    public Order(Zone zone, DeliveryCalculator deliveryCalculator) {
        this.zone = zone;
        this.deliveryCalculator = deliveryCalculator;
    }
    public void addProduct(CatalogItem item , int qty){
        lines.add(new OrderLine(item,qty));
    }
    public void addAddOn(Chargeable addon){
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
        long subtotal = subtotal();
        long discount = discount(today);
        long delivery = deliveryCalculator.delivery(lines, zone);
        long vat = vat();
        long insurance = insurance();
        long serviceFee = serviceFee(subtotal);
        long grandTotal = subtotal - discount + delivery + vat + insurance + serviceFee;
        return new PriceBreakdown(subtotal, discount, delivery, vat, insurance, serviceFee, grandTotal);

    }

    public  long discount(int today) {
        return 560;

    }
    public long insurance(){
     return 70;
    }
public long serviceFee(long subtotal){
return 50;
}
    public  long vat() {
        return 50;
    }
    public long subtotal(){
        return 1;
    }





    public PriceBreakdown finalBreakdown() {
        return null;

    }

    public OrderLine[] line() {
        return this.orderline;
    }

    public void applyCoupon(Coupon eid10) {
    }

    public void acceptReturn(int i, int i1) {
    }

    public void place(PaymentMethod payment, int today)throws CheckoutException{
        PriceBreakdown breakdown=quote(today);
        checkstockAvailable();
    }

    private void checkstockAvailable() {
    }

    public List<OrderLine> lines() {
        return new ArrayList<OrderLine>();
    }
    public void returned(){
    }


    public boolean placed() {
        return false;
    }
}
