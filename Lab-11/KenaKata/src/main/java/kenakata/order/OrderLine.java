package kenakata.order;
import kenakata.catalog.Chargeable;

public class OrderLine {
    private final Chargeable item;
    private final int quantity;
    private boolean insured;
    private boolean returned;

    public OrderLine(Chargeable item,int quantity){
        if(item==null){
            throw new IllegalArgumentException();
        }
        if(quantity<=0){
            throw new IllegalArgumentException();
        }
        this.item=item;
        this.quantity=quantity;
    }

    public Chargeable item(){
        return item;
    }

    public int quantity(){
        return quantity;
    }

    public int lineVat(){
        return item.unitVat()*quantity;
    }

    public boolean insured(){
        return insured;
    }

    public void insure(){
        insured=true;
    }

    public boolean returned(){
        return returned;
    }

    public void markReturned(){
        returned=true;
    }
}
