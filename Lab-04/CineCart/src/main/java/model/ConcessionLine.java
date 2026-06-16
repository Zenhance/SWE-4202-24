package model;

public class ConcessionLine extends LineItem{
    private final ConcessionItem item;
    private final int qty;

    public ConcessionLine(ConcessionItem item,int qty){
        this.item=item;
        this.qty=qty;
    }

    public double subtotal(){
        return item.getUnitPrice() * qty ;
    }

    public String describe(){
        return item.getName() + " x" + qty;
    }
}
