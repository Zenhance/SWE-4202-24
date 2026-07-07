package model;

public class ConcessionLine extends LineItem {

    private ConcessionItem item;
    private int quantity;

    public ConcessionLine(ConcessionItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    @Override
    public double subtotal() {
        return item.getPrice() * quantity;
    }

    @Override
    public String describe() {
        return quantity + " x " + item.getName();
    }

    public ConcessionItem getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean hasCode(String code) {
        return item.getCode().equalsIgnoreCase(code);
    }
}