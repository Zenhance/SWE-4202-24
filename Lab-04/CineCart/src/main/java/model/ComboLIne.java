package model;

public class ComboLIne extends LineItem{
    private ConcessionItem itemA;
    private ConcessionItem itemB;
    public ComboLIne(ConcessionItem itemA,ConcessionItem itemB) {
        this.itemA = itemA;
        this.itemB = itemB;
    }
    public ConcessionItem getItemA() {
        return itemA;
    }

    public ConcessionItem getItemB() {
        return itemB;
    }
    public double subtotal(){
        return (itemA.getUnitPrice()+itemB.getUnitPrice())-50.00;
    }
    public String describe(){
        return String.format("Combo:%s & %s-BDT %.2f",itemA.getName(),itemB.getName(),subtotal());
    }

}
