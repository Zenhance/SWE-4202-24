package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
import kenakata.catalog.FreshGood;
import kenakata.catalog.StockedGood;

public class Line {
    CatalogItem item;
    Chargeable charge;
    int quantity;
    public boolean insurable=false;
    public boolean returnable=false,returned=false;
    public Line(CatalogItem item, int quantity) {
        if(quantity<=0) throw new IllegalArgumentException();
        this.item = item;
        this.quantity = quantity;
        if(item instanceof StockedGood||item instanceof FreshGood) returnable=true;
    }
    public Line(Chargeable charge) {
        this.charge= charge;
    }
    public boolean returned() {return returned;}
}
