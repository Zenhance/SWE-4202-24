package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
import kenakata.catalog.Insurable;
import kenakata.exceptions.CheckoutException;
import kenakata.exceptions.CouponRejectedException;
import kenakata.exceptions.NotInsurableException;
import kenakata.exceptions.ReturnNotAllowedException;
import kenakata.payment.PaymentMethod;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Zone zone;
    private Coupon coupon;
    private PriceBreakdown priceBreakdown;
    private DeliveryCalculator deliveryCalculator;
    private List<OrderLine> lines=new ArrayList<>();
    private ArrayList<Chargeable> items;
    private ArrayList<Integer> quantities;
    private ArrayList<Boolean> insured;
    private ArrayList<Boolean> returned;


    public Order(Zone zone,DeliveryCalculator deliveryCalculator){
       if(zone==null) throw new IllegalArgumentException("Zone can't be null");
       if(deliveryCalculator==null) throw new IllegalArgumentException("Delivery calculator can't be null");
        this.zone=zone;
        this.deliveryCalculator=deliveryCalculator;
    }

    public void addProduct(CatalogItem item,int quantity){
        items.add(item);
        quantities.add(quantity);
        insured.add(false);
        returned.add(false);

    }

    public void addAddOn(Chargeable addOn){
        items.add(addOn);
        quantities.add(1);
        insured.add(false);
        returned.add(false);

    }

    public void place(PaymentMethod payment,int day) throws CheckoutException{

    }

    public void applyCoupon(Coupon coupon){
            this.coupon=coupon;
    }

    public PriceBreakdown quote(int day) throws CouponRejectedException {
        long subtotal=0;
        long discountable=0;
        long vat=0;
        long insurance=0;

        for(int i=0;i<items.size();i++){
            Chargeable item=items.get(i);
            int quantity=quantities.get(i);

            subtotal+=item.unitCharge()*quantity;
            vat+=item.unitVat()*quantity;

            if(insured.get(i)&& item instanceof Insurable insurable){
                long value=insurable.insure(quantity);
                long fee = (long)Math.ceil(value*0.01);

                insurance+=Math.max(20,fee);
            }
        }
        long discount=0;
        if(coupon!=null){
            discount=coupon.calculateDiscount(discount,day);
        }

        long delivery=deliveryCalculator.calculate(items,quantities,zone);
        long serviceFee=Math.min(100,(long)Math.ceil(subtotal*0.01));

        long grandTotal=subtotal-discount+delivery+vat+insurance+serviceFee;
        priceBreakdown=new PriceBreakdown(subtotal,discount,delivery,vat,insurance,serviceFee,grandTotal);

        return priceBreakdown;
    }

    public void insure(long quantity){

    }

    public boolean placed(){
        return false;
    }

    public PriceBreakdown finalBreakdown(){
        return null;
    }

    public void acceptReturn(int serial, int day) throws ReturnNotAllowedException {
    }

    public List<OrderLine> lines(){
        return  lines;
    }

    public void insure(int i) throws NotInsurableException {
        Chargeable item=items.get(i);
        if(!(item instanceof Insurable)){
            throw new NotInsurableException("Item is not insured");
        }
        insured.set(i,true);

    }
}
