package model;

public class ComboLine extends LineItem{
    private final ConcessionItem itemA;
    private final ConcessionItem itemB;

    public ComboLine(ConcessionItem itemA,ConcessionItem itemB){
        this.itemA=itemA;
        this.itemB=itemB;
    }
    @Override
    public double subtotal(){
        return itemA.getUnitPrice()+itemB.getUnitPrice();
    }
}
