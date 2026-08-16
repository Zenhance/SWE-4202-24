package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
import kenakata.catalog.FreshGood;
import kenakata.catalog.StockedGood;
import kenakata.exceptions.CheckoutException;
import kenakata.exceptions.CouponRejectedException;
import kenakata.exceptions.NotInsurableException;
import kenakata.payment.PaymentMethod;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

public class Order {
    ArrayList<Line> Lines = new ArrayList<>();
    public Coupon coupon;
    DeliveryCalculator deliveryCal;
    Zone zone;

    public Order(Zone zone, DeliveryCalculator deliveryCalculator) {
        this.zone = zone;
        this.deliveryCal = deliveryCalculator;
    }

    public void addProduct(CatalogItem item, int amount) {
        Lines.add(new Line(item,amount));
    }
    public void addAddOn(Chargeable e) {
        Lines.add(new Line(e));
    }

    public void applyCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public PriceBreakdown quote(int day) throws CouponRejectedException {
        int subtotal=0,discount=0,insurance = 0,servicefee,vat=0,delivery;
        for(Line line : Lines)
        {
            if(line.charge==null) subtotal += line.item.unitCharge() * line.quantity;
            if(line.item==null)subtotal+=line.charge.unitCharge();
        }
        if(coupon!=null&&coupon.validdate>day&&coupon.minspend<=subtotal){
            int total=0;

            for(Line line : Lines) if(line.item instanceof StockedGood s) total+=s.unitCharge()*line.quantity;
            discount= (int) ( total*(coupon.percent/100.0));
            if(discount>coupon.cap) discount=coupon.cap;
            else if(discount>15000)discount=15000;
            }
        if (coupon != null && (coupon.validdate < day || coupon.minspend > subtotal))
            throw new CouponRejectedException();
        for(Line line : Lines) if(line.insurable) insurance+=(int) (0.01*line.item.unitCharge());
        for(Line line : Lines) if(line.insurable) insurance+=max(20,insurance);

        servicefee =(int)min(ceil(subtotal*0.01),100);
        for(Line line : Lines)
        {
            if(line.charge==null) vat += line.item.unitVat() * line.quantity;
            if(line.item==null) vat+=line.charge.unitVat();
        }
        delivery =deliveryCal.Calculatedelivery(lines(),zone);
        return new PriceBreakdown(subtotal,discount,insurance,servicefee,vat,delivery);
    }

    public void insure(int idx) throws NotInsurableException {
        if(!(Lines.get(idx).item instanceof StockedGood ||Lines.get(idx).item instanceof FreshGood )) throw new NotInsurableException();
        lines().get(idx).insurable=true;

    }

    public void place(PaymentMethod payment, int today) throws CheckoutException{

    }

    public void acceptReturn(int idx, int day) {
    }

    public boolean placed() {
        return false;
    }

    public PriceBreakdown finalBreakdown() {
        return null;
    }

    public ArrayList<Line> lines() {
        return Lines;
    }

    public void returned() {

    }
}
