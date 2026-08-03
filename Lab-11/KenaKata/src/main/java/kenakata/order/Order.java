package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
import kenakata.catalog.StockedGood;
import kenakata.exceptions.*;
import kenakata.payment.PaymentMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private final Zone zone;
    private final DeliveryCalculator deliveryCalculator;
    private final List<OrderLine> lines= new ArrayList<>();
    private Coupon coupon;
    private boolean placed=false;
    private PriceBreakdown finalBreakdown;
    private int placementDay= -1;
    public Order(Zone zone,DeliveryCalculator deliveryCalculator){
        this.zone=zone;
        this.deliveryCalculator=deliveryCalculator;
    }
    public void addAddOn(Chargeable addOn){
        if(addOn==null) throw new IllegalArgumentException("Add-ON cannot be null");
        lines.add(new OrderLine(addOn,1));
    }
    public void addProduct(CatalogItem item, int quantity) {
        if (item == null) throw new IllegalArgumentException("Item cannot be null");
        lines.add(new OrderLine(item, quantity));
    }
    public void applyCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public void insure(int lineIndex) throws NotInsurableException {
        lines.get(lineIndex).insure();
    }
    public PriceBreakdown quote(int currentDay) throws CouponRejectedException{
        long subtotal=0;
        long discountableBase=0;
        long vat=0;
        long insurance=0;
        for(OrderLine line:lines){
            long lineTotal=line.getItem().unitCharge()*line.getQuantity();
            subtotal+=lineTotal;
            vat+=line.getItem().unitVat()*line.getQuantity();
            insurance+=line.getInsuranceFee();
            if(line.getItem() instanceof StockedGood){
                discountableBase+=lineTotal;
            }
        }
        long discount=0;
        if(coupon!=null){
            discount=coupon.calculateDiscount(discountableBase,subtotal,currentDay);
        }
        long delivery = deliveryCalculator.calculate(lines, zone);
        long serviceFee = Math.min((long) Math.ceil(subtotal * 0.01), 100);
        long grandTotal = subtotal - discount + delivery + vat + insurance + serviceFee;

        return new PriceBreakdown(subtotal, discount, vat, delivery, insurance, serviceFee, grandTotal);
    }
    public void place(PaymentMethod paymentMethod,int currentDay) throws CheckoutException {
        if(placed) return;
        PriceBreakdown breakdown=quote(currentDay);
        for(OrderLine line:lines){
            if(line.getItem() instanceof CatalogItem c){
                if(line.getQuantity()<=0){
                    throw new IllegalArgumentException();
                }
                if (line.getQuantity() > c.remaining()) {
                    throw new OutOfStockException();
                }
            }
        }
        paymentMethod.authorise(breakdown.grandTotal());
        for (OrderLine line : lines) {
            if (line.getItem() instanceof CatalogItem c) {
                c.reserve(line.getQuantity());
            }
        }

        this.placed=true;
        this.finalBreakdown=breakdown;
        this.placementDay=currentDay;
    }
    public boolean placed(){
        return placed;
    }
    public PriceBreakdown finalBreakdown(){
        return finalBreakdown;
    }
    public List<OrderLine> lines(){
        return Collections.unmodifiableList(lines);
    }
    public void acceptReturn(int lineIndex,int currentDay) throws ReturnNotAllowedException{
        if(!placed) throw new ReturnNotAllowedException();
        lines.get(lineIndex).processReturn(placementDay,currentDay);
    }

}
