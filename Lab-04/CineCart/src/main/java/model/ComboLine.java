package model;

public class ComboLine extends LineItem {
    private ConcessionItem itemA;
    private ConcessionItem itemB;
    public ComboLine(ConcessionItem itemA,ConcessionItem itemB){
        this.itemA=itemA;
        this.itemB=itemB;
    }


}
