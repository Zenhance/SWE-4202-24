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
        return itemA.getUnitPrice()+itemB.getUnitPrice()-50.00;
    }
    @Override
    public String describe(){
        return "Combo: "+itemA.getCode()+" + "+itemB.getCode();
    }
    @Override
    public boolean hasCode(String code){
        return itemA.getCode().equals(code)||itemB.getCode().equals(code);
    }
}
