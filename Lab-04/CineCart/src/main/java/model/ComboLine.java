package model;

public class ComboLine extends LineItem {
    public ConcessionItem i1;
    public ConcessionItem i2;
    public ComboLine(ConcessionItem i1,ConcessionItem i2){
        this.i1=i1;
        this.i2=i2;
    }
    public double subtotal() {
        return 0;
    }
    public boolean hasCode(String pop) {
        return false;
    }
    public String describe() {
        return null;
    }

}
