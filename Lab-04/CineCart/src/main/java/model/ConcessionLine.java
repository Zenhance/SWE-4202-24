package model;

public class ConcessionLine extends LineItem{
    ConcessionItem c;
    int qty;

    public ConcessionLine(ConcessionItem c, int qty){
        this.c = c;
        this.qty = qty;
    }

    public ConcessionLine(ConcessionItem c){
        this(c,1);
    }

    public double subtotal(){return 0;}

}
