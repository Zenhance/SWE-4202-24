package kenakata.order;

import kenakata.catalog.FreshGood;
import kenakata.catalog.Weighable;
import kenakata.catalog.Chargeable;

import java.util.List;

public class DeliveryCalculator {

    public long calculate(List<OrderLine> lines, Zone zone) {
        long totalWeight = 0;
        long coldCharge = 0;
        for(OrderLine line : lines) {
            Chargeable item = line.item();
            if(item instanceof Weighable) {
                Weighable product = (Weighable) item;
                totalWeight += product.weight() * line.quantity();
            }
            if(item instanceof FreshGood) {
                coldCharge += 50;
            }
        }
        if(totalWeight == 0) {
            return 0;
        }
        long kg = (totalWeight + 999) / 1000;
        long delivery;
        if(zone == Zone.DHAKA) {
            delivery = 60 + kg * 20;
        } else {
            delivery = 120 + kg * 35;
        }
        return delivery + coldCharge;
    }
}