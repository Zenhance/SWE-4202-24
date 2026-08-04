package kenakata.order;
import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;


import javax.sound.sampled.Line;
import java.util.ArrayList;

public class Order {
    ArrayList<Line> Lines = new ArrayList<>();
    public Coupon coupon;
    public Order(Zone zone,DeliveryCalculator deliveryCalculator) {}

public void addProduct(CatalogItem item,int amount){
        Lines.add(new Line(item,amount));
}

public void addAddOn(Chargeable e)

}
