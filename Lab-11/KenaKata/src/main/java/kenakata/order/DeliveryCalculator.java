package kenakata.order;

import kenakata.catalog.Chargeable;
import kenakata.catalog.DigitalGood;
import kenakata.catalog.FreshGood;


public class DeliveryCalculator {
    Zone z;
    int charge  =0;
    int calculateDeliveryCharge() {
        if(z == Zone.DHAKA)
            charge += 60;

        if(z == Zone.OUTSIDE)
            charge += 120;

        return charge;
    }
}
