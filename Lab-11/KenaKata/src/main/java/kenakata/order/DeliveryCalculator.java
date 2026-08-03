package kenakata.order;

import kenakata.catalog.Chargeable;
import kenakata.catalog.DigitalGood;

import java.util.ArrayList;

public class DeliveryCalculator {

    public boolean onlyColdChain(ArrayList<Chargeable> chargeables) {
        for (Chargeable c : chargeables) {
            if (!(c instanceof DigitalGood)) return false;
        }
        return true;
    }
}
