package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
import kenakata.catalog.Discountable;
import kenakata.catalog.FreshGood;
import kenakata.catalog.Insurable;
import kenakata.catalog.Returnable;
import kenakata.catalog.StockedGood;
import kenakata.catalog.Weighable;
import kenakata.exceptions.CheckoutException;
import kenakata.exceptions.CouponRejectedException;
import kenakata.exceptions.NotInsurableException;
import kenakata.exceptions.OutOfStockException;
import kenakata.exceptions.ReturnNotAllowedException;
import kenakata.payment.PaymentMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private final Zone zone;
    private final DeliveryCalculator deliveryCalculator;
    private final List<OrderLine> lines=new ArrayList<>();
    private Coupon coupon;
    private boolean placed;
    private int placeDay;
    private PriceBreakdown finalBreakdown;

    public Order(Zone zone,DeliveryCalculator deliveryCalculator){
        this.zone=zone;
        this.deliveryCalculator=deliveryCalculator;
    }

    public void addProduct(CatalogItem item,int quantity){
        lines.add(new OrderLine(item,quantity));
    }

    public void applyCoupon(Coupon coupon){
        this.coupon=coupon;
    }

    public void insure(int lineIndex)throws NotInsurableException{
        OrderLine line=lines.get(lineIndex);
        if(!(line.item() instanceof Insurable)){
            throw new NotInsurableException("Line " + lineIndex + "cannot be insured");
        }
        line.insure();
    }

    public PriceBreakdown quote(int day)throws CouponRejectedException{
        int subtotal=0;
        int vat=0;
        int discountableBase=0;
        int weightGrams=0;
        int freshLines=0;

        for(OrderLine line: lines){
            Chargeable item=line.item();
            int lineCharge=item.unitCharge()*line.quantity();
            subtotal+=lineCharge;
            vat+=line.lineVat();

            if(item instanceof Discountable){
                discountableBase+=lineCharge;
            }
            if(item instanceof Weighable weighable){
                weightGrams+=weighable.weightGrams()*line.quantity();
            }
            if(item instanceof FreshGood){
                freshLines++;
            }
        }

        int discount=0;
        if(coupon !=null){
            if(day>coupon.validUntil()){
                throw new CouponRejectedException("Coupon "+ coupon.code()+ " has expired");
            }
            if(subtotal<coupon.minimumSpend()){
                throw new CouponRejectedException("Coupon "+coupon.code()+" requires a minimum spend of "+coupon.minimumSpend());
            }
            int rawDiscount=ceilPercent(discountableBase,coupon.percentage());
            discount=Math.min(rawDiscount,coupon.maximumDiscount());
        }

        int delivery=deliveryCalculator.calculator(weightGrams,zone,freshLines);
        int insurance=0;
        for(OrderLine line:lines){
            if(line.insured()){
                int lineCharge=line.item().unitCharge()*line.quantity();
                insurance+=Math.max(20,ceilPercent(lineCharge,1));
            }
        }

        int serviceFee=Math.min(100,ceilPercent(subtotal,1));
        int grandTotal=subtotal-discount+delivery+vat+insurance+serviceFee;
        return new PriceBreakdown(subtotal,discount,delivery,vat,insurance,serviceFee,grandTotal);
    }

    public void place(PaymentMethod payment,int day)throws CheckoutException{
        for(OrderLine line:lines){
            if(line.item() instanceof StockedGood stockedGood && line.quantity()>stockedGood.remaining()){
                throw new OutOfStockException();
            }
        }
        PriceBreakdown breakdown=quote(day);
        payment.authorise(breakdown.grandTotal());
        for(OrderLine line:lines){
            if(line.item() instanceof StockedGood stockedGood){
                stockedGood.reserve(line.quantity());
            }
        }
        this.placed=true;
        this.placeDay=day;
        this.finalBreakdown=breakdown;
    }

    public boolean placed(){
        return placed;
    }

    public PriceBreakdown finalBreakdown(){
        return finalBreakdown;
    }

    public void acceptReturn(int lineIndex,int day)throws ReturnNotAllowedException{
        OrderLine line=lines.get(lineIndex);
        if(!(line.item() instanceof Returnable returnable)){
            throw new ReturnNotAllowedException("Line "+lineIndex+" cannot be returned");
        }
        if(line.returned()){
            throw new ReturnNotAllowedException("Line "+lineIndex+" has already returned");
        }
        if(day>placeDay+returnable.returnWindowDays()){
            throw new ReturnNotAllowedException("Line "+lineIndex+" is past its return window");
        }
        line.markReturned();
    }

    public List<OrderLine> lines() {
        return Collections.unmodifiableList(lines);
    }

    private int ceilPercent(int value,double percent){
        return (int) Math.ceil(value*percent/100.0);
    }
}
