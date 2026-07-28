package kenakata.order;

import kenakata.catalog.Chargeable;
import kenakata.catalog.DigitalGood;
import kenakata.catalog.FreshGood;

import java.util.ArrayList;

public class PriceBreakdown {

    PriceBreakdown(ArrayList<Chargeable> i){
        items = i;
    }

    ArrayList<Chargeable> items;
    Coupon cp;

    public int subtotal() {
        int total = 0;
        for(Chargeable c: items){
            total += c.unitCharge();
        }
        return total;
    }

    public int discount() {
        int total = 0;
        for(Chargeable c: items){
            if(!(c instanceof DigitalGood || c instanceof FreshGood))
                total += c.unitVat();
        }
        int x = (int) Math.ceil(total* cp.percent/100.00);

        if(x > cp.capped) return cp.capped;
        return x;
    }

    public int delivery() {
        // do something with DeliveryCalculator
        return 0;
    }

    public int vat() {
        int total = 0;
        for(Chargeable c: items){
            total += c.unitVat();
        }
        return total;
    }

    public int insurance() {
        return 0;
    }

    public int serviceFee() {
        double x = Math.ceil(subtotal()*0.01);
        return (int) x;
    }

    public int grandTotal() {
        return 0;
    }
}
