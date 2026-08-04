package kenakata.order;
import kenakata.catalog.Chargeable;

public class OrderLine {
    private final Chargeable item;
    private final int quantity;
    private boolean insured;
    private boolean returned;
    public OrderLine(Chargeable item,int quantity){
        if(quantity<=0){
            throw new IllegalArgumentException("Quantity must be positive");
        }
        this.item=item;
        this.quantity=quantity;
        this.insured=false;
        this.returned=false;
    }
    public Chargeable item(){
        return item;
    }
    public int quantity(){
        return quantity;
    }

    public boolean insured() {
        return insured;
    }
    public boolean returned(){
        return returned;
    }
    public void setInsured(boolean insured){
        this.insured=insured;
    }
    public void markReturned(){
        this.returned=true;
    }
    public long lineCharge(){
        return item.unitCharge()*quantity;
    }
    public long lineVat(){
        return item().unitVat()*quantity;
    }
}
