package kenakata.order;
import kenakata.catalog.Chargeable;

public class OrderLine {
    private final Chargeable item;
    private final int quantity;
    private boolean returned;

    public OrderLine(Chargeable item, int quantity){
        if(item == null || quantity <=0){
            throw new IllegalArgumentException("Invalid order line");
        }
        this.item = item;
        this.quantity = quantity;
        this.returned = false;
    }
    public Chargeable item(){
        return item;
    }

    public int quantity(){
        return quantity;
    }

    public long lineValue(){
        return item.unitCharge() * quantity;
    }

    public boolean returned(){
        return returned;
    }

    public void markReturned(){
        returned = true;
    }

}