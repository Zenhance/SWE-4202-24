package kenakata.order;

import kenakata.catalog.*;

import java.util.ArrayList;

public class PriceBreakdown {



    ArrayList<Chargeable> items;
    ArrayList<Integer> count;
    Coupon cp;
    Zone z;
    int deliveryBase;
    DeliveryCalculator d;
    int itemSubtotal;

    PriceBreakdown(ArrayList<Chargeable> i){
        items = i;
    }

    public int subtotal() {
        int total = 0;
        for(int i = 0; i < items.size(); i++){
            total += items.get(i).unitCharge() * count.get(i);
        }
        return total;
    }

    public int discount() {
        if (cp == null) return 0;
        int total = 0;
        for(int i = 0; i < items.size(); i++){
            Chargeable c = items.get(i);
            if(c instanceof StockedGood)
                total += c.unitCharge() * count.get(i);
        }
        int x = (int) Math.ceil(total* cp.percent/100.00);

        if(x > cp.capped) return cp.capped;
        return x;
    }

    public int delivery() {
        return d.calculateDeliveryCharge();
    }

    public int vat() {
        int total = 0;
        for(int i = 0; i < items.size(); i++){
            total += items.get(i).unitVat() * count.get(i);
        }
        return total;
    }

    public int insurance() {
        int total = 0;
        for(int i = 0; i < items.size(); i++){
            Chargeable c = items.get(i);
            if(c instanceof Insurable)
                if (((CatalogItem) c).insured)
                    total += c.unitCharge() * count.get(i);
        }
        double x = Math.ceil(total / 100.00);

        if(x < 20 && x > 0) return 20;
        return (int) x;
    }

    public int serviceFee() {
        double x = Math.ceil(subtotal()*0.01);
        if(x > 100) return 100;
        return (int) x;
    }

    public int grandTotal() {
        int total = subtotal() - discount() + vat() + delivery() + insurance() + serviceFee();
        return total;
    }
}
