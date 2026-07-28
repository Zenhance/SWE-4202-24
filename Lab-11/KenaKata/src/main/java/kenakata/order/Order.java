package kenakata.order;

import kenakata.catalog.AddOn;
import kenakata.catalog.Chargeable;
import kenakata.catalog.Good;
import java.util.ArrayList;

public class Order {
    private Zone zone;
    private DeliveryCalculator calculator;
    private ArrayList<Chargeable> chargeables;

    public Order(Zone zone, DeliveryCalculator calculator) {
        this.zone = zone;
        this.calculator = calculator;
    }

    public void addProduct(Good product) {
        chargeables.add(product);
    }

    public void addAddOn(AddOn addOn) {
        chargeables.add(addOn);
    }
}
