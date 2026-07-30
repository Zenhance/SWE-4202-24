package kenakata.order;

import kenakata.catalog.*;
import kenakata.exceptions.CouponRejectedException;
import kenakata.exceptions.NotInsurableException;
import kenakata.payment.PaymentMethod;
import kenakata.settlement.SettlementReport;

import javax.xml.catalog.Catalog;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Order {

    Zone zone;
    DeliveryCalculator d;
    PriceBreakdown pb;
    ArrayList<Chargeable> items = new ArrayList<>();
    Coupon cp;

    public Order(Zone z, DeliveryCalculator d) {
        this.zone = z;
        this.d = d;
        this.pb = new PriceBreakdown(items);
        d.z = z;
        d.items = this.items;
        pb.d = this.d;
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

    public void applyCoupon(Coupon c) {
        pb.cp = c;
        this.cp = c;
    }

    public void place(PaymentMethod p, int no){}

    public void insure (int n) throws Exception{
        Chargeable item =items.get(n) ;

        if(!(item instanceof Insurable))
            throw new NotInsurableException("Not insurable");

        else
            ((CatalogItem) item).insured = true;
    }

    public PriceBreakdown quote (int day) throws Exception{
        if(cp!= null && (cp.day < day || cp.minSpend > pb.subtotal()))
            throw new CouponRejectedException("Coupon expired or not enough spent!");

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
