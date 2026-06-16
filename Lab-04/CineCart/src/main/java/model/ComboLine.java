package model;

public class ComboLine extends LineItem {
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
        double subtotal = itemA.getUnitPrice() + itemB.getUnitPrice();

        if (itemA.getCode().equals("POP") && itemB.getCode().equals("SODA")) {
            subtotal -= 50.00;
        }

        return subtotal;
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