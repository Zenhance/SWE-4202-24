package model;

public class ConcessionLine extends LineItem {
    private ConcessionItem item;
    private int qty;

    public ConcessionLine(ConcessionItem item, int qty) {
        this.item=item;
        this.qty=qty;
    }


}
