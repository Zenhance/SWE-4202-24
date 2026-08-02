package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
import kenakata.catalog.Insurable;
import kenakata.exceptions.NotInsurableException;

import java.util.ArrayList;

public class Order {
    private Zone zone;
    private DeliveryCalculator deliveryCalculator;

    private ArrayList<OrderLine> lines;
    private ArrayList<Chargeable> addOns;

    private Coupon coupon;

    private ArrayList<Integer> insuredLines;

    private boolean placed;

    private PriceBreakdown finalBreakdown;

    private int placeDay;

    public Order(Zone zone, DeliveryCalculator deliveryCalculator){
        if(zone== null){
            throw new IllegalArgumentException("Zone cannot be null");
        }
        if(deliveryCalculator==null){
            throw new IllegalArgumentException("Calculator cannot be null");
        }
        this.zone=zone;
        this.deliveryCalculator=deliveryCalculator;


        lines= new ArrayList<>();
        addOns= new ArrayList<>();
        insuredLines= new ArrayList<>();

        placed=false;
        coupon=null;
        finalBreakdown=null;
    }

    public void addProduct(CatalogItem product, int quantity){
        OrderLine line = new OrderLine(product,quantity );
        lines.add(line);

    }

    public void addAddOn(Chargeable addOn){
        if(addOn==null){
            throw new IllegalArgumentException("Add-on cannot be null");
        }

        addOns.add(addOn);
    }

    public void applyCoupon(Coupon coupon){
        this.coupon=coupon;
    }

    public ArrayList<OrderLine> lines(){
        return lines;
    } // working as a getter. will return  the selected products like lamp, hilsha

    public boolean placed(){
        return placed;
    }

    public PriceBreakdown finalBreakdown(){
        return finalBreakdown;
    }

    public void insure(int lineIndex) throws NotInsurableException {
        OrderLine line = lines.get(lineIndex);

        if(!(line.product() instanceof Insurable)){
            throw new NotInsurableException("Item is not insurable");
        }

        insuredLines.add(lineIndex);
    }





}
