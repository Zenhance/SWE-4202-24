package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
import kenakata.catalog.Insurable;
import kenakata.exceptions.CheckoutException;
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

    public PriceBreakdown quote(int day){
        return null;
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
