package model;

public class ConcessionLine extends LineItem {
    private ConcessionItem item;
    private int qty;

    public ConcessionLine(ConcessionItem item, int qty) {
        this.item=item;
        this.qty=qty;
    }

    public double subtotal(){
        return 0.0;
    }

    public String describe() {
        return null;
    }

    public boolean hasCode(String code){
        return false;
    }
}
