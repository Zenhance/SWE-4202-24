package kenakata.order;

public class OrderLine{
    private final Chargeable item;
    private final int quantity;
    private boolean insured = false;
    private boolean returned = false;
    public OrderLine(Chargeable item,int quantity){
        if (quantity<=0){
            throw new IllegalArgumentException("Quantity must be positive");
        }
        this.item = item;
        this.quantity = quantity;
    }
    public Chargeable item(){
        return item;
    }
    public int quantity(){
        return quantity;
    }
    public boolean insured(){
        return insured;
    }
    public void setInsured(boolean insured){
        this.insured = insured;
    }
    public boolean returned(){
        return returned;
    }
    public void setReturned(boolean returned){
        this.returned = returned;
    }
}
