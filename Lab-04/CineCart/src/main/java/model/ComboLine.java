package model;

public class ComboLine implements LineItem {
    private ConcessionItem itemA;
    private ConcessionItem itemB;

    public ComboLine(ConcessionItem itemA, ConcessionItem itemB) {
        this.itemA = itemA;
        this.itemB = itemB;
    }

    public ConcessionItem getItemA() {
        return itemA;
    }

    public ConcessionItem getItemB() {
        return itemB;
    }

    @Override
    public double subtotal() {
        return itemA.getUnitPrice() + itemB.getUnitPrice() - 50.00;
    }

    @Override
    public String describe() {
        return "Combo: " + itemA.getCode() + " + " + itemB.getCode()
                + " - BDT " + String.format("%.2f", subtotal());
    }

    @Override
    public boolean carriesCode(String code) {
        return itemA.getCode().equals(code) || itemB.getCode().equals(code);
    }
}