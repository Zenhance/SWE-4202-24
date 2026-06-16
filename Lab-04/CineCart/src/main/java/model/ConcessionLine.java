package model;

import java.security.PublicKey;

public class ConcessionLine extends LineItem{
    private ConcessionItem item;
    private int qty;
    public ConcessionLine(ConcessionItem item,int qty){
        this.item=item;
        this.qty=qty;
    }
    @Override
    public double subtotal(){
        return item.getUnitPrice()*qty;
    }
    @Override
    public String describe(){
        return item.getName()+ " x "+qty;
    }
}
