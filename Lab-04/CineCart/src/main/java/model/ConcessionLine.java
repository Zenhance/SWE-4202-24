package model;

public class ConcessionLine extends LineItem{
    private final ConcessionItem item;
    private final int qty;

    public ConcessionLine(ConcessionItem item, int qty) {
        this.item = item;
        this.qty = qty;
    }

    @Override
    public double subtotal() {
        return 0;
    }

    @Override
    public String describe() {
        return "";
    }
    public boolean hasCode(String code){
        return item.getCode().equals(code);
    }
}
