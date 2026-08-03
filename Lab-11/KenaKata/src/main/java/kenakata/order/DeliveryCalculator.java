package kenakata.order;

import kenakata.catalog.Chargeable;
import kenakata.catalog.DigitalGood;
import kenakata.catalog.FreshGood;
import kenakata.catalog.Weighable;

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
            return 60;
        else return  120;
    }

    public int billedWeight() {
        int totalWeight = 0;
        for (Chargeable c : chargeables) {
            if (c instanceof Weighable)
                totalWeight += ((Weighable) c).weight();
        }

        double weightInKG = (double) totalWeight / 1000;

        return ((int) Math.ceil(weightInKG)) * 20;
    }
}
