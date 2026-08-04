package kenakata.order;
import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
import kenakata.exceptions.CheckoutException;
import kenakata.payment.PaymentMethod;


import javax.sound.sampled.Line;
import java.util.ArrayList;

public class Order {
    ArrayList<OrderLine> Lines = new ArrayList<>();
    public Coupon coupon;
    public Order(Zone zone,DeliveryCalculator deliveryCalculator) {}

public void addProduct(CatalogItem item,int amount){
        Lines.add(new OrderLine(item,amount));
}

public void addAddOn(Chargeable e){
        Lines.add(new OrderLine(e));
}

    public void applyCoupon(Coupon coupon){
        this.coupon = coupon;
    }

    public PriceBreakdown qoute(int i){
        return null;
    }

    public void insure(int idx){

    }

    public void place(PaymentMethod payment,int today) throws CheckoutException {

    }

    public void acceptReturn(int i1,int i2){

    }

    public void returned(){

    }

    public boolean placed(){
        return false;
    }

    public PriceBreakdown finalBreakdown() {
        return null;
    }

    public ArrayList<OrderLine> lines() {
        return Lines;
    }

}
