package kenakata.order;

import kenakata.catalog.Chargeable;
import kenakata.catalog.DigitalGood;
import kenakata.catalog.FreshGood;
import kenakata.catalog.StockedGood;

import java.util.ArrayList;

public class PriceBreakdown {



    ArrayList<Chargeable> items;
    Coupon cp;
    Zone z;
    int deliveryBase;

    PriceBreakdown(ArrayList<Chargeable> i){
        items = i;
    }

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
            if(c instanceof StockedGood)
                total += c.unitCharge();
        }
        int x = (int) Math.ceil(total* cp.percent/100.00);

        if(x > cp.capped) return cp.capped;
        return x;
    }

    public int delivery() {

        return 190;
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
        int total = subtotal() - discount() + vat() + delivery() + insurance() + serviceFee();
        return total;
    }
}
