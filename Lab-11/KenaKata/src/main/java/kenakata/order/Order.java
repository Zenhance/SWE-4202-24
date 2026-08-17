package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
import kenakata.catalog.FreshGood;
import kenakata.catalog.StockedGood;
import kenakata.exceptions.*;
import kenakata.payment.PaymentMethod;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

public class Order {
    ArrayList<Line> Lines = new ArrayList<>();
    public Coupon coupon;
    DeliveryCalculator deliveryCal;
    Zone zone;
    int placedate;
    PriceBreakdown fin;
    Boolean place=false;

    public Order(Zone zone, DeliveryCalculator deliveryCalculator) {
        this.zone = zone;
        this.deliveryCal = deliveryCalculator;
    }

    public void addProduct(CatalogItem item, int amount) {
        Line line = new Line(item, amount);
        Lines.add(line);
        try {
            item.reserve(amount);
        }
        catch(Exception e) {
            lines().remove(line);
        }
    }
    public void addAddOn(Chargeable e) {
        Line line = new Line(e);
        Lines.add(line);
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
        for(Line line : Lines) if(line.insurable) insurance+=(int) (0.01*(line.item.unitCharge()*line.quantity));
        for(Line line : Lines) if(line.insurable) insurance=max(20,insurance);

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
        placedate=today;
        if(coupon!=null&&coupon.validdate < today) throw new CouponRejectedException();
        fin= quote(today);
        place=true;
    }

    public void acceptReturn(int idx, int day) throws ReturnNotAllowedException {
    if(!lines().get(idx).returnable||lines().get(idx).returned) throw new ReturnNotAllowedException();
    if(lines().get(idx).item instanceof StockedGood ) if(day>placedate+7) throw new ReturnNotAllowedException();
    if(lines().get(idx).item instanceof FreshGood ) if(day>placedate+2) throw new ReturnNotAllowedException();
    lines().get(idx).returned=true;
    }

    public boolean placed() {
        return place;
    }

    public PriceBreakdown finalBreakdown() {
        return fin;
    }

    public ArrayList<Line> lines() {
        return Lines;
    }

}
