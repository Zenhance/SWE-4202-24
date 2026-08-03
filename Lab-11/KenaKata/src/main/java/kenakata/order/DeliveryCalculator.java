package kenakata.order;

import kenakata.catalog.Chargeable;
import kenakata.catalog.DigitalGood;
import kenakata.catalog.FreshGood;

import java.util.ArrayList;

public class DeliveryCalculator {

    public boolean onlyDigitalGood(ArrayList<Chargeable> chargeables) {
        for (Chargeable c : chargeables) {
            if (!(c instanceof DigitalGood)) return false;
        }
        return true;
    }

    public boolean hasFreshGood(ArrayList<Chargeable> chargeables) {
        for (Chargeable c : chargeables) {
            if (c instanceof FreshGood)
                return true;
        }
        return false;
    }
}
