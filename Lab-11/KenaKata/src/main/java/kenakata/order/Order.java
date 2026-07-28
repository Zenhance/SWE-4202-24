package kenakata.order;

import kenakata.catalog.AddOn;
import kenakata.catalog.Good;
import java.util.ArrayList;

public class Order {
    private Zone zone;
    private DeliveryCalculator calculator;
    private ArrayList<Good> products;
    private ArrayList<AddOn> addOns;

    public Order(Zone zone, DeliveryCalculator calculator) {
        this.zone = zone;
        this.calculator = calculator;
    }

    public void addProduct(Good product) {
        products.add(product);
    }

    public void addAddOn(AddOn addOn) {
        addOns.add(addOn);
    }
}
