package model;

public class ConcessionLine extends LineItem{
    public ConcessionItem concessionItem;
    public int qty;
    public ConcessionLine(ConcessionItem concessionItem,int qty){
        this.concessionItem=concessionItem;
        this.qty=qty;

    }
    public double subtotal(){
        return 0;
    }
}
