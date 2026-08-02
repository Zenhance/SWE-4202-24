package kenakata.order;

import kenakata.catalog.*;
import kenakata.exceptions.*;
import kenakata.payment.CashOnDeliveryPayment;
import kenakata.payment.MobileWalletPayment;
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
    ArrayList<Integer> count = new ArrayList<>();
    Coupon cp;
    PaymentMethod pay;
    int payDay;
    boolean orderPlaced = false;

    public Order(Zone z, DeliveryCalculator d) {
        this.zone = z;
        this.d = d;
        this.pb = new PriceBreakdown(items);
        d.z = z;
        d.items = this.items;
        d.count = this.count;
        pb.count = this.count;
        pb.d = this.d;
        pb.deliveryBase = d.calculateDeliveryCharge();
    }

    public void addProduct(CatalogItem g, int n){
        if(n<=0)
            throw new IllegalArgumentException("invalid amount");
        items.add(g);
        count.add(n);
    }

    public void addAddOn(Chargeable w){
        items.add(w);
        count.add(1);
    }

    public void applyCoupon(Coupon c) {
        pb.cp = c;
        this.cp = c;
    }

    public void place(PaymentMethod p, int day) throws Exception {
        this.pay = p;
        payDay = day;

        if(pay instanceof MobileWalletPayment) {
            if (((MobileWalletPayment) pay).w.balance() < pb.grandTotal())
                throw new EmptyWalletException("Balance too low");
        }

        if(pay instanceof CashOnDeliveryPayment) {
            if (pay.x != pb.grandTotal())
                throw new CodCeilingExceededException("Wrong amount");
        }

        for(int i=0; i< items.size(); i++){
            if(items.get(i) instanceof CatalogItem) {
                CatalogItem c = (CatalogItem) items.get(i);
                if (c.getAmount() < count.get(i))
                    throw new OutOfStockException("Out of Stock!");
            }
        }

        if(cp != null && cp.day < day)
            throw new CouponRejectedException("Expired");

        p.authorise(pb.grandTotal());

        orderPlaced = true;

        for(int i = 0; i < items.size(); i++){
            Chargeable c = items.get(i);
            if(c instanceof CatalogItem)
                ((CatalogItem)c).reserve(count.get(i));
        }
    }

    public void insure (int n) throws Exception{
        Chargeable item =items.get(n) ;

        if(!(item instanceof Insurable))
            throw new NotInsurableException("Not insurable");

        else
            ((CatalogItem) item).insured = true;
    }

    public PriceBreakdown quote (int day) throws CouponRejectedException {
        if(cp!= null && (cp.day < day || cp.minSpend > pb.subtotal()))
            throw new CouponRejectedException("Coupon expired or not enough spent!");

        return pb;
    }

    public void acceptReturn(int i, int day) throws ReturnNotAllowedException {

        Chargeable c = items.get(i);
        if(c instanceof CatalogItem){
            if(((CatalogItem) c).isReturned())
                throw new ReturnNotAllowedException("Already returned");
        }

        if(!(c instanceof Returnable))
            throw new ReturnNotAllowedException("Not returnable");

        if(c instanceof StockedGood) {
            if (day - this.payDay <= 7)
                ((Returnable) c).returnItem();
            else throw new ReturnNotAllowedException("Return window is past");
        }
        if(c instanceof FreshGood){
            if((day - this.payDay) <= 2)
                ((Returnable) c).returnItem();
            else throw new ReturnNotAllowedException("Return window is past");
        }

    }

    public boolean placed() {

        return orderPlaced;
    }

    public SettlementReport finalBreakdown() {

        SettlementReport report = new SettlementReport();

        return report;
    }

    public StockedGood lines() {
        ArrayList<StockedGood> stockedGoods = new ArrayList<>();
        for(Chargeable c: items){
            if(c instanceof StockedGood)
                stockedGoods.add((StockedGood) c);

            else stockedGoods.add(null);
        }

        return stockedGoods.get(0);
    }
}
