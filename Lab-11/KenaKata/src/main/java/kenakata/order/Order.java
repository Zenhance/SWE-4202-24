package kenakata.order;

import kenakata.catalog.*;
import kenakata.payment.PaymentMethod;
import kenakata.settlement.SettlementReport;

import java.util.ArrayList;
import java.util.Map;

public class Order {

    Zone zone;
    DeliveryCalculator d;
    PriceBreakdown pb;
    ArrayList<Chargeable> items = new ArrayList<>();
    Coupon cp;


    public Order(Zone z, DeliveryCalculator d) {
        this.zone = z;
        d.z = z;
        this.d = d;
        this.pb = new PriceBreakdown(items);
        pb.deliveryBase = d.calculateDeliveryCharge();
    }

    public void addProduct(CatalogItem g, int n){
        for(int i=0; i<n; i++){
            items.add(g);
        }
    }

    public void addAddOn(Chargeable w){
        items.add(w);
    }

    public void applyCoupon(Coupon c){
        pb.cp = c;
    }

    public void place(PaymentMethod p, int no){}

    public void insure (int n){}

    public PriceBreakdown quote (int day){
        return pb;
    }

    public void acceptReturn(int a, int b){}

    public boolean placed() {
        return false;
    }

    public SettlementReport finalBreakdown() {


        return null;
    }

    public StockedGood lines() {
        return null;
    }
}
