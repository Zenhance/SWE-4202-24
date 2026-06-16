package model;

public class ComboLine {
    private ConcessionItem itemA;
    private ConcessionItem itemB;
    public ComboLine(ConcessionItem itemA,ConcessionItem itemB){
        this.itemA=itemA;
        this.itemB=itemB;
    }
    public double subtotal(){
        return itemA.getUnitPrice()+itemB.getUnitPrice()-50.0;
    }
    public String describe(){
        return itemA.getName()+"+"+itemB.getName()+"Combo";
    }
    public boolean hasCode(String code){
        return itemA.getCode().equals(code) || itemB.getCode().equals(code);
    }
}
