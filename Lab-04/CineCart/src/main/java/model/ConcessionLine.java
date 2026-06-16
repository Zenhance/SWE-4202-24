package model;

public class ConcessionLine implements LineItem {
    private ConcessionItem item;
    private int qty;

    public ConcessionLine(ConcessionItem item, int qty) {
        this.item = item;
        this.qty = qty;
    }

    public ConcessionItem getItem() {
        return item;
    }

    public int getQty() {
        return qty;
    }

    @Override
    public double subtotal() {
        return item.getUnitPrice() * qty;
    }

    @Override
    public String describe() {
        return item.getCode() + " x" + qty + " - BDT "
                + String.format("%.2f", subtotal());
    }

    @Override
    public boolean carriesCode(String code) {
        return item.getCode().equals(code);
    }
}