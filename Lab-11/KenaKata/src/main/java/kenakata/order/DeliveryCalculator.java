package kenakata.order;

import kenakata.catalog.Chargeable;
import kenakata.catalog.DigitalGood;
import kenakata.catalog.FreshGood;

import java.util.ArrayList;

public class DeliveryCalculator {
    private ArrayList<Chargeable> chargeables;

    public DeliveryCalculator(ArrayList<Chargeable> chargeables) {
        this.chargeables = chargeables;
    }

    public DeliveryCalculator() {

    }

    public boolean onlyDigitalGood() {
        for (Chargeable c : chargeables) {
            if (!(c instanceof DigitalGood)) return false;
        }
        return true;
    }

    public boolean hasFreshGood() {
        for (Chargeable c : chargeables) {
            if (c instanceof FreshGood)
                return true;
        }
        return false;
    }

    public int deliveryZone(Zone zone) {
        if (zone == Zone.DHAKA)
            return 140;
        else return  120;
    }

}
